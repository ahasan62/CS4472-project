package atm.dispatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import atm.session.transactions.ATMTransaction;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;
import bank.transactions.utils.TransactionType;

public class RESTDispatcher implements MessageDispatcher {
	private Gson gson = new Gson();

	@Override
	public boolean checkCredentials(String cardNumber, char[] pin) {
		Map<String, String> credentials = new HashMap<>();
		credentials.put("cardNumber", cardNumber);
		credentials.put("pin", String.valueOf(pin));
		String message = gson.toJson(credentials);
		String response = sendMessage("checkCredentials", message);
		
		return Boolean.parseBoolean(response);
		
	}

	@Override
	public TransactionResult performTransaction(String cardNumber, char[] pin, ATMTransaction transaction) {
		TransactionType transactionType = transaction.getTransactionType();
		double amount = transaction.getAmount();
		
		AccountType[] accounts = new AccountType[2];
		if (transactionType == TransactionType.Withdrawal) {
			accounts[0] = transaction.getFromAccount();
		} else if (transactionType == TransactionType.Deposit) {
			accounts[0] = transaction.getToAccount();
		} if (transactionType == TransactionType.Transfer) {
			accounts[0] = transaction.getFromAccount();
			accounts[1] = transaction.getToAccount();
		}
		
		TransactionData data = new TransactionData(cardNumber, pin, transactionType, accounts, amount);
		String message = gson.toJson(data);
		String response = sendMessage("performTransaction", message);	
		
		Type type = new TypeToken<TransactionResult>() {}.getType();
		TransactionResult result = gson.fromJson(response, type);
		return result;
	}
	
	private String sendMessage(String endpoint, String message) {
		URL url;
		
		//TODO How many retries??
		while (true) {
			try {
				System.out.println("Sending message => " + message);
				url = new URL("http://localhost:9000/" + endpoint);

				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");

				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setDoOutput(true);

				try (OutputStream os = con.getOutputStream()) {
					byte[] input = message.getBytes("utf-8");
					os.write(input, 0, input.length);
				}

				int responseCode = con.getResponseCode();
				
				if (responseCode == 200) {
					try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
						StringBuilder response = new StringBuilder();
						String responseLine = null;
						while ((responseLine = br.readLine()) != null) {
							response.append(responseLine.trim());
						}
						System.out.println(response.toString());
						return response.toString();
					}
				}
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}

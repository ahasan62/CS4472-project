package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import bank.exceptions.WrongOperationException;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;

public class BankHandler {
	private Gson gson;
	private BankFacade facade;
	
	public BankHandler(BankFacade facade) {
		this.gson = new Gson();
		this.facade = facade;
	}

	private String getRequestBody(HttpExchange exchange) throws WrongOperationException {
		Headers headers = exchange.getRequestHeaders();
		String query = null;

		if ((exchange.getRequestMethod().contentEquals("POST"))
				&& ("application/json; utf-8".contentEquals(headers.get("Content-Type").get(0)))) {

			InputStreamReader isr;
			try {
				isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				query = br.readLine();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return query;
		} else {
			throw new WrongOperationException();
		}
	}

	private void sendResponse(HttpExchange exchange, int responseCode, String response) {
		// send response
		try {
			exchange.sendResponseHeaders(responseCode, response.length());
			OutputStream os = exchange.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();
			exchange.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void performTransaction(HttpExchange exchange) {

		int responseCode;
		String response;

		String query;
		try {
			query = getRequestBody(exchange);
			try {
			Type type = new TypeToken<TransactionData>() {}.getType();
			TransactionData transactionData = gson.fromJson(query, type);
			
			// handle get request
			TransactionResult result = facade.performTransaction(transactionData);
			response = gson.toJson(result);

			// prepare response
			responseCode = 200;
			} catch (JsonSyntaxException jsonException) {
				// prepare response
				responseCode = 405;
				response = "Incorrect JSON format.";
			}
		} catch (WrongOperationException e) {
			// prepare response
			responseCode = 405;
			response = "This type of get operation is not supported.";
		}
		
		sendResponse(exchange, responseCode, response);

	}
	
	public void checkCredentials(HttpExchange exchange) {

		int responseCode;
		String response;

		String query;
		try {
			query = getRequestBody(exchange);
			try {
			Type type = new TypeToken<Map<String, String>>() {}.getType();
			Map<String, String> credentials = gson.fromJson(query, type);
			
			// handle get request
			String cardNumber = credentials.get("cardNumber");
			char[] pin = credentials.get("pin").toCharArray();
			boolean result = facade.checkCredentials(cardNumber, pin);
			response = gson.toJson(result);

			// prepare response
			responseCode = 200;
			} catch (JsonSyntaxException jsonException) {
				// prepare response
				responseCode = 405;
				response = "Incorrect JSON format.";
			}
		} catch (WrongOperationException e) {
			// prepare response
			responseCode = 405;
			response = "This type of get operation is not supported.";
		}
		
		sendResponse(exchange, responseCode, response);

	}

}

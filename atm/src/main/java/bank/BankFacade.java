package bank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import bank.db.DBHandler;
import bank.exceptions.CardNotFoundException;
import bank.exceptions.UserNotFoundException;
import bank.transactions.BankDeposit;
import bank.transactions.BankTransaction;
import bank.transactions.BankTransfer;
import bank.transactions.BankWithdrawal;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;
import bank.transactions.utils.TransactionType;
import bank.utils.FeesCalculator;

public class BankFacade {
	private DBHandler dbHandler;
	private Map<TransactionType, BankTransaction> transactions;

	public BankFacade(DBHandler dbHandler, BankTransaction withdrawal, BankTransaction deposit,
			BankTransaction transfer) {
		super();
		this.dbHandler = dbHandler;
		
		transactions = new HashMap<>();
		transactions.put(TransactionType.Withdrawal, withdrawal);
		transactions.put(TransactionType.Deposit, deposit);
		transactions.put(TransactionType.Transfer, transfer);
	}

	public boolean checkCredentials(String cardNumber, char[] inputPIN) {
		String user;
		char[] pin;
		try {
			user = dbHandler.getCardOwner(cardNumber);
		} catch (CardNotFoundException e) {
			return false;
		}
		try {
			pin = dbHandler.getPIN(user);
		} catch (UserNotFoundException e) {
			return false;
		}
		
		return Arrays.equals(pin, inputPIN);
	}
	
	public TransactionResult performTransaction(TransactionData data) {
		char[] pin = data.getPin();
		TransactionResult result;
		TransactionType transactionType = data.getType();
		String cardNumber = data.getCardNumber();
		if (checkCredentials(cardNumber, pin)) {
			result = transactions.get(transactionType).perform(data);
		} else {
			result = new TransactionResult(false, "Invalid credentials.", 0.0, null);
		}
		
		return result;
	}

}

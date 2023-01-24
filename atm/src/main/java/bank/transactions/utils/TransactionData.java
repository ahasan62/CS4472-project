package bank.transactions.utils;

public class TransactionData {
	private String cardNumber;
	private char[] pin;
	private TransactionType type;
	private AccountType[] accounts;
	private double amount;
	
	public TransactionData(String cardNumber, char[] pin, TransactionType type, AccountType[] accounts, double amount) {
		super();
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.type = type;
		this.accounts = accounts;
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	
	public char[] getPin() {
		return pin;
	}

	public TransactionType getType() {
		return type;
	}
	
	public AccountType[] getAccounts() {
		return accounts;
	}
	
	public double getAmount() {
		return amount;
	}

}

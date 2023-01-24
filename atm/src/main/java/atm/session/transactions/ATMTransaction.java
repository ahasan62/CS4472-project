package atm.session.transactions;

import atm.ATM;
import atm.dispatcher.MessageDispatcher;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionResult;
import bank.transactions.utils.TransactionType;

abstract public class ATMTransaction {
	protected TransactionType type;
	protected AccountType from;
	protected AccountType to;
	protected double amount;
	
	public ATMTransaction(TransactionType type) {
		this.type = type;
	}


	public TransactionType getTransactionType() {
		return type;
	}


	public void setFromAccount(AccountType from) {
		this.from = from;
	}


	public void setToAccount(AccountType to) {
		this.to = to;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

	public AccountType getFromAccount() {
		return from;
	}


	public AccountType getToAccount() {
		return to;
	}


	public double getAmount() {
		return amount;
	}

	public TransactionResult perform(String cardNumber, char[] pin, MessageDispatcher dispatcher) {
		TransactionResult result = dispatcher.performTransaction(cardNumber, pin, this);
		return result;
	}
}

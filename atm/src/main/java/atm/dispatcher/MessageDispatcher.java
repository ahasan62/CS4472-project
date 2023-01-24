package atm.dispatcher;

import atm.session.transactions.ATMTransaction;
import bank.transactions.utils.TransactionResult;

public interface MessageDispatcher {
	public boolean checkCredentials(String cardNumber, char[] pin);
	public TransactionResult performTransaction(String cardNumber, char[] pin, ATMTransaction transaction);
}

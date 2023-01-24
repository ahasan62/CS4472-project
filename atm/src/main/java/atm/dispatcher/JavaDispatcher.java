package atm.dispatcher;

import atm.session.transactions.ATMTransaction;
import atm.session.transactions.ATMWithdrawal;
import bank.BankFacade;
import bank.db.DBHandler;
import bank.transactions.BankTransaction;
import bank.transactions.BankWithdrawal;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;
import bank.transactions.utils.TransactionType;

public class JavaDispatcher implements MessageDispatcher {
	private BankFacade bankFacade;

	public JavaDispatcher(BankFacade bankFacade) {
		super();
		this.bankFacade = bankFacade;
	}

	public boolean checkCredentials(String cardNumber, char[] pin) {
		return bankFacade.checkCredentials(cardNumber, pin);
	}

	public TransactionResult performTransaction(String cardNumber, char[] pin, ATMTransaction transaction) {
		TransactionType transactionType = transaction.getTransactionType();
		TransactionResult result;
		
		AccountType[] accounts;
		switch (transactionType) {
		case Withdrawal:
			accounts = new AccountType[1];
			accounts[0] = transaction.getFromAccount();
			break;
		case Deposit:
			accounts = new AccountType[1];
			accounts[0] = transaction.getToAccount();
			break;
		case Transfer:
			accounts = new AccountType[2];
			accounts[0] = transaction.getFromAccount();
			accounts[1] = transaction.getToAccount();
			break;
		default:
			accounts = null;
		}
		
		double amount = transaction.getAmount();
		TransactionData bankTransaction = new TransactionData(cardNumber, pin, transactionType, accounts, amount);
		result = bankFacade.performTransaction(bankTransaction);
		
		return result;
	}

}

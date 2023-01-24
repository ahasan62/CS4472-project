package bank.transactions;

import bank.db.DBHandler;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;
import bank.utils.FeesCalculator;

public abstract class BankTransaction {
	
	protected FeesCalculator feesCalculator;
	protected DBHandler dbHandler;
	
	

	public BankTransaction(FeesCalculator feesCalculator, DBHandler dbHandler) {
		super();
		this.feesCalculator = feesCalculator;
		this.dbHandler = dbHandler;
	}
	
	abstract public TransactionResult perform(TransactionData data);
}

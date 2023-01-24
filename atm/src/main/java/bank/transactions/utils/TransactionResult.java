package bank.transactions.utils;

import java.util.HashMap;
import java.util.Map;

public class TransactionResult {
	private boolean successful;
	private String reason;
	private double fees;
	private double[] accountBalances;
	
	public TransactionResult(boolean successful, String reason, double fees, double[] accountBalances) {
		super();
		this.successful = successful;
		this.reason = reason;
		this.fees = fees;
		this.accountBalances = accountBalances;
	}
	
	public boolean isSuccessful() {
		return successful;
	}
	
	public String getReason() {
		return reason;
	}

	public double getFees() {
		return fees;
	}

	public double[] getAccountBalances() {
		return accountBalances;
	}
}
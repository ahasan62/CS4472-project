package atm.session.transactions;

import bank.transactions.utils.TransactionType;

public class ATMDeposit extends ATMTransaction {

	public ATMDeposit() {
		super(TransactionType.Deposit);
	}
}

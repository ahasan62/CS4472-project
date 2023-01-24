package atm.session.transactions;

import bank.transactions.utils.TransactionType;

public class ATMWithdrawal extends ATMTransaction {

	public ATMWithdrawal() {
		super(TransactionType.Withdrawal);
	}

}

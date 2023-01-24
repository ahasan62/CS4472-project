package atm.session.transactions;

import bank.transactions.utils.TransactionType;

public class ATMTransfer extends ATMTransaction {

	public ATMTransfer() {
		super(TransactionType.Transfer);
	}

}

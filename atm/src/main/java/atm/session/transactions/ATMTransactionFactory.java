package atm.session.transactions;

import bank.transactions.utils.TransactionType;

public class ATMTransactionFactory {
	public static ATMTransaction createTransaction(TransactionType type) {
		switch (type) {
		case Withdrawal:
			return new ATMWithdrawal();
		case Deposit:
			return new ATMDeposit();
		case Transfer:
			return new ATMTransfer();
		default:
			return new ATMNoTransaction();
		}
	}

}

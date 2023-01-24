package bank.transactions;

import bank.db.DBHandler;
import bank.exceptions.CardNotFoundException;
import bank.exceptions.UnsuccessfulBalanceUpdate;
import bank.exceptions.UserNotFoundException;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;
import bank.utils.FeesCalculator;

public class BankDeposit extends BankTransaction {

	public BankDeposit(FeesCalculator feesCalculator, DBHandler dbHandler) {
		super(feesCalculator, dbHandler);
	}

	@Override
	public TransactionResult perform(TransactionData data) {
		String cardNumber = data.getCardNumber();
		AccountType to = data.getAccounts()[0];
		double amount = data.getAmount();
		
		String user;
		boolean isStudent;
		try {
			user = dbHandler.getCardOwner(cardNumber);
		} catch (CardNotFoundException e) {
			return new TransactionResult(false, "Card number not found.", 0.0, null);
		}
		double balance;
		try {
			balance = dbHandler.getBalance(user, to);
			isStudent = dbHandler.isStudent(user);
		} catch (UserNotFoundException e) {
			return new TransactionResult(false, "User not found.", 0.0, null);
		}
		
		double interest = feesCalculator.calculateDepositInterest(amount, balance, isStudent);
		double newAmount = balance + amount + interest;
		try {
			dbHandler.setBalance(user, to, newAmount);
		} catch (UnsuccessfulBalanceUpdate e) {
			return new TransactionResult(false, "Unsuccessful update of account balance.", 0.0, null);
		} 
		
		double[] accountsBalances = new double[1];
		accountsBalances[0] = newAmount;
		return new TransactionResult(true, "", interest, accountsBalances);
	}

}

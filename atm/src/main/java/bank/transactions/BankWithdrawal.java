package bank.transactions;

import java.util.Calendar;

import bank.db.DBHandler;
import bank.exceptions.CardNotFoundException;
import bank.exceptions.UnsuccessfulBalanceUpdate;
import bank.exceptions.UserNotFoundException;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;
import bank.utils.FeesCalculator;

public class BankWithdrawal extends BankTransaction {

	public BankWithdrawal(FeesCalculator feesCalculator, DBHandler dbHandler) {
		super(feesCalculator, dbHandler);
	}

	@Override
	public TransactionResult perform(TransactionData data) {
		String cardNumber = data.getCardNumber();
		AccountType from = data.getAccounts()[0];
		double amount = data.getAmount();
		int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		
		String user;
		boolean isStudent;
		try {
			user = dbHandler.getCardOwner(cardNumber);
		} catch (CardNotFoundException e) {
			return new TransactionResult(false, "Card number not found.", 0.0, null);
		}
		double balance;
		try {
			balance = dbHandler.getBalance(user, from);
			isStudent = dbHandler.isStudent(user);
		} catch (UserNotFoundException e) {
			return new TransactionResult(false, "User not found.", 0.0, null);
		}
		
		double fees = feesCalculator.calculateWithdrawalFee(amount, balance, isStudent, dayOfWeek);
		
		double amountRequired = amount + fees;
		
		TransactionResult result;
		double newAmount = balance - amountRequired;
		if (newAmount >= 0) {
			try {
				dbHandler.setBalance(user, from, balance - amountRequired);
			} catch (UnsuccessfulBalanceUpdate e) {
				return new TransactionResult(false, "Unsuccessful update of account balance.", 0.0, null);
			}
			double[] accountsBalances = new double[1];
			accountsBalances[0] = newAmount;
			result = new TransactionResult(true, "", fees, accountsBalances);
		} else {
			result = new TransactionResult(false, "Insufficient funds.", 0.0, null);
		}
		
		return result;
	}

}

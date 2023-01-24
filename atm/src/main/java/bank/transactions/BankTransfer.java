package bank.transactions;

import bank.db.DBHandler;
import bank.exceptions.CardNotFoundException;
import bank.exceptions.UnsuccessfulBalanceUpdate;
import bank.exceptions.UserNotFoundException;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionData;
import bank.transactions.utils.TransactionResult;
import bank.utils.FeesCalculator;

public class BankTransfer extends BankTransaction {

	public BankTransfer(FeesCalculator feesCalculator, DBHandler dbHandler) {
		super(feesCalculator, dbHandler);
	}

	@Override
	public TransactionResult perform(TransactionData data) {
		TransactionResult result;
		
		String cardNumber = data.getCardNumber();
		AccountType from = data.getAccounts()[0];
		AccountType to = data.getAccounts()[1];
		double amount = data.getAmount();
		
		String user;
		try {
			user = dbHandler.getCardOwner(cardNumber);
		} catch (CardNotFoundException e) {
			return new TransactionResult(false, "Card number not found.", 0.0, null);
		}
		
		double fromBalance, toBalance;
		boolean isStudent;
		try {
			fromBalance = dbHandler.getBalance(user, from);
			toBalance = dbHandler.getBalance(user, to);
			isStudent = dbHandler.isStudent(user);
		} catch (UserNotFoundException e) {
			return new TransactionResult(false, "User not found.", 0.0, null);
		}
		
		double fees = feesCalculator.calculateTransferFee(amount, fromBalance, toBalance, isStudent);
		double amountRequired = amount + fees;
		double newFromAmount = fromBalance - amountRequired;
		double newToAmount = toBalance + amount;
		if (newFromAmount >= 0) {
			try {
				dbHandler.setBalance(user, from, newFromAmount);
				dbHandler.setBalance(user, to, newToAmount);
			} catch (UnsuccessfulBalanceUpdate e) {
				return new TransactionResult(false, "User not found.", 0.0, null);
			}
			
			double[] accountsBalances = new double[2];
			accountsBalances[0] = newFromAmount;
			accountsBalances[1] = newToAmount;
			result = new TransactionResult(true, "", fees, accountsBalances);
		} else {
			result = new TransactionResult(false, "Insufficient funds.", 0.0, null);
		}
		
		return result;
	}

}

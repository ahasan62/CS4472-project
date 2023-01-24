package atm.session;

import atm.dispatcher.MessageDispatcher;
import atm.exceptions.InvalidAmountException;
import atm.session.states.PendingCardState;
import atm.session.states.PinNumberState;
import atm.session.states.SessionState;
import atm.session.transactions.ATMTransaction;
import atm.ui.panels.MainPanel;
import atm.utils.CashValidator;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionResult;
import bank.transactions.utils.TransactionType;

public class Session {
	private MainPanel mainPanel;
	private MessageDispatcher dispatcher;
	private SessionState state;
	private String card;
	private char[] pin;
	private ATMTransaction transaction;
	private int allegedAmount; 
	TransactionResult result;



	public Session(MainPanel mainPanel, MessageDispatcher dispatcher) {
		super();
		this.mainPanel = mainPanel;
		this.dispatcher = dispatcher;
		state = new PendingCardState();
	}

	public void setState(SessionState state) {
		this.state = state;
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void insertCard() {
		state.perform(this);
	}

	public void addCard(String card) {
		this.card = card;
		state.perform(this);
		
	}

	public String getCard() {
		return card;
	}

	public void addPin(char[] pin) {
		this.pin = pin;
		state.perform(this);
	}

	public void setTransaction(ATMTransaction t) {
		transaction = t;
		state.perform(this);
	}

	public TransactionType getTransactionType() {
		return transaction.getTransactionType();
	}

	public void setFromAccount(AccountType type) {
		transaction.setFromAccount(type);
		state.perform(this);
	}

	public void setToAccount(AccountType type) {
		transaction.setToAccount(type);
		state.perform(this);
	}

	public void setAmount(int amount) throws InvalidAmountException {
		boolean isAmountValid = false;
		if (transaction.getTransactionType() == TransactionType.Deposit) {
			if (!CashValidator.validateDeposit(amount)) {
				throw new InvalidAmountException();
			}
			allegedAmount = amount;
		} else if (transaction.getTransactionType() == TransactionType.Withdrawal) {
			if (!CashValidator.validateWithdrawal(amount)) {
				throw new InvalidAmountException();
			}
			transaction.setAmount(amount);
		} else {
			transaction.setAmount(amount);
		}
		
		state.perform(this);
	}
	

	public void getCash(int amount) throws InvalidAmountException {
		if (allegedAmount == amount)
			transaction.setAmount(amount);
		else
			throw new InvalidAmountException();
		
		state.perform(this);
	}
	
	public void performTransaction() {
		result = transaction.perform(card, pin, dispatcher);
	}

	public void newTransaction() {
		transaction = null;
		result = null;
		state = new PinNumberState();
		state.perform(this);	
	}

	public String createResultText() {
		TransactionType transactionType = transaction.getTransactionType();
		StringBuilder resultString = new StringBuilder();
		
		resultString.append("Transaction Receipt\n");
		resultString.append("----------------------------------------------------------\n");
		resultString.append(transactionType.toString() + "\n");
		
		String actionVerb = "";
		String moneyVerb = "";
		if (transactionType == TransactionType.Withdrawal) {
			resultString.append("\tFrom: " + transaction.getFromAccount().toString() + "\n");
			actionVerb = "withdrawn";
			moneyVerb = "Fees";
		} else if (transactionType == TransactionType.Deposit) {
			resultString.append("\tTo: " + transaction.getToAccount().toString() + "\n");
			actionVerb = "deposited";
			moneyVerb = "Interest";
		} else if (transactionType == TransactionType.Transfer) {
			resultString.append("\tFrom: " + transaction.getFromAccount().toString() + "\n");
			resultString.append("\tTo: " + transaction.getToAccount().toString() + "\n");
			actionVerb = "transferred";
			moneyVerb = "Fees";
		}

		resultString.append("----------------------------------------------------------\n");
		resultString.append("\tTransaction Outcome: \n");
		if (result.isSuccessful()) {
			resultString.append("Successful");
			resultString.append("\tAmount "+ actionVerb +": " + transaction.getAmount() + "\n");
			resultString.append("\t"+ moneyVerb + ": " + result.getFees() + "\n");
		} else {
			resultString.append("Unsuccessful\n");
			resultString.append("\t\tReason: " + result.getReason() + "\n");
		}
		
		resultString.append("----------------------------------------------------------\n");
		resultString.append("New Balances:\n");
		if (transactionType == TransactionType.Withdrawal) {
			resultString.append("\t" + transaction.getFromAccount().toString() 
					+ " => " + result.getAccountBalances()[0] + "\n");
		} else if (transactionType == TransactionType.Deposit) {
			resultString.append("\t" + transaction.getToAccount().toString() 
					+ " => " + result.getAccountBalances()[0] + "\n");
		} else if (transactionType == TransactionType.Transfer) {
			resultString.append("\t" + transaction.getFromAccount().toString() 
					+ " => " + result.getAccountBalances()[0] + "\n");
			resultString.append("\t" + transaction.getToAccount().toString() 
					+ " => " + result.getAccountBalances()[1] + "\n");
		}
		
		return resultString.toString();
	}


}

package atm;

import atm.dispatcher.MessageDispatcher;
import atm.exceptions.InvalidAmountException;
import atm.exceptions.InvalidCardNumberException;
import atm.exceptions.InvalidCredentialsException;
import atm.exceptions.InvalidPinFormatException;
import atm.session.Session;
import atm.session.transactions.ATMTransactionFactory;
import atm.ui.panels.MainPanel;
import atm.utils.CredentialsCheck;
import atm.utils.FormatChecker;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionType;

public class ATM {
	private Session session;
	private FormatChecker formatCheck;
	private CredentialsCheck credentialsCheck;
	private MessageDispatcher dispatcher;
	private MainPanel mainPanel;

	public ATM(FormatChecker formatCheck, CredentialsCheck credentialsCheck, MessageDispatcher dispatcher) {
		super();
		this.formatCheck = formatCheck;
		this.credentialsCheck = credentialsCheck;
		this.dispatcher = dispatcher;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}


	public void createSession() {
		session = new Session(mainPanel, dispatcher);
		session.insertCard();
	}
	
	public void checkCardNumber(String card) throws InvalidCardNumberException {
		formatCheck.checkCardFormat(card);
		session.addCard(card);
	}

	public void checkPin(char[] pin) throws InvalidCredentialsException, InvalidPinFormatException {
		formatCheck.checkPinFormat(pin);
		credentialsCheck.perform(session.getCard(), pin);
		session.addPin(pin);
	}

	public void setTransaction(TransactionType type) {
		session.setTransaction(ATMTransactionFactory.createTransaction(type));
	}

	public void setFromAccount(AccountType type) {
		session.setFromAccount(type);
	}
	
	public void setToAccount(AccountType type) {
		session.setToAccount(type);
	}

	public void setAmount(int amount) throws InvalidAmountException {
		session.setAmount(amount);
	}
	
	public void insertMoney(int amount) throws InvalidAmountException {
		session.getCash(amount);
		
	}

	public void anotherTransaction() {
		session.newTransaction();
	}

	public void endSession() {
		session = null;
		mainPanel.changeLayout("InsertCard");
		
	}

	


}

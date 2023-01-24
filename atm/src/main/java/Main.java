import javax.swing.JFrame;

import atm.ATM;
import atm.dispatcher.JavaDispatcher;
import atm.dispatcher.MessageDispatcher;
import atm.dispatcher.RESTDispatcher;
import atm.ui.MainUI;
import atm.ui.panels.MainPanel;
import atm.utils.FormatChecker;
import atm.utils.CredentialsCheck;
import bank.BankFacade;
import bank.BankServer;
import bank.db.DBHandler;
import bank.transactions.BankDeposit;
import bank.transactions.BankTransaction;
import bank.transactions.BankTransfer;
import bank.transactions.BankWithdrawal;
import bank.utils.FeesCalculator;

public class Main {
	public static void start(boolean usesAPI) {
		FeesCalculator feesCalculator = new FeesCalculator();
		DBHandler dbHandler = new DBHandler();
		BankTransaction withdrawal = new BankWithdrawal(feesCalculator, dbHandler);
		BankTransaction deposit = new BankDeposit(feesCalculator, dbHandler);
		BankTransaction transfer = new BankTransfer(feesCalculator, dbHandler);
		BankFacade facade = new BankFacade(dbHandler, withdrawal, deposit, transfer);
		
		MessageDispatcher dispatcher;
		if (usesAPI) {
			dispatcher = new RESTDispatcher();
			BankServer server = new BankServer(facade);
			server.start();
		} else {
			dispatcher = new JavaDispatcher(facade);
		}
		
		FormatChecker cardNumberChecker = new FormatChecker();
		CredentialsCheck credentialsCheck = new CredentialsCheck(dispatcher);
		ATM atm = new ATM(cardNumberChecker, credentialsCheck, dispatcher);
		
		MainPanel mainPanel = new MainPanel(atm);
		atm.setMainPanel(mainPanel);
		
		JFrame mainUI = new MainUI(atm);
		
		mainUI.setSize(900, 600);
		mainUI.pack();
		mainUI.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main.start(false);
	}

}

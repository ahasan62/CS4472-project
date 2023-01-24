package atm.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import atm.ATM;
import atm.dispatcher.JavaDispatcher;
import atm.dispatcher.MessageDispatcher;
import atm.dispatcher.RESTDispatcher;
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

public class MainUI extends JFrame{
	public MainUI(ATM atm) {
		super("ATM");
		
		MainPanel mainPanel = new MainPanel(atm);
		atm.setMainPanel(mainPanel);

		this.setLayout(new GridBagLayout());
		this.add(mainPanel, new GridBagConstraints());
	}
}

package atm.ui.panels;

import java.awt.CardLayout;

import javax.swing.JPanel;

import atm.ATM;

public class MainPanel extends JPanel{
	/** The card layout for this panel
     */
    private CardLayout mainLayout;
    private ResultPanel resultPanel;
    private ATM atm;
    
	public MainPanel(ATM atm) {
		this.atm = atm;
		
		mainLayout = new CardLayout(5,5);
        setLayout(mainLayout);
        
        InsertCardPanel insertCardPanel = new InsertCardPanel(atm);
        this.add(insertCardPanel, "InsertCard");

        CardPanel cardPanel = new CardPanel(atm);
        this.add(cardPanel, "Card");
        
        PinPanel pinPanel = new PinPanel(atm);
        this.add(pinPanel, "Pin");
        
        TransactionPanel transactionPanel = new TransactionPanel(atm);
        this.add(transactionPanel, "Transaction");
        
        FromPanel fromPanel = new FromPanel(atm);
        this.add(fromPanel, "From");
        
        ToPanel toPanel = new ToPanel(atm);
        this.add(toPanel, "To");
        
        AmountPanel amountPanel = new AmountPanel(atm);
        this.add(amountPanel, "Amount");
        
        InsertMoneyPanel moneyPanel = new InsertMoneyPanel(atm);
        this.add(moneyPanel,"InsertMoney");
        
        resultPanel = new ResultPanel(atm);
        this.add(resultPanel, "Result");

        mainLayout.show(this, "InsertCard");
	}



	public void changeLayout(String layout) {
		mainLayout.show(this, layout);
	}

	public void setResult(String resultText) {
		resultPanel.setText(resultText);
	}
}

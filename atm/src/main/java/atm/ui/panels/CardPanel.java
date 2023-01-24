/*
 * ATM Example system - file BillsPanel.java    
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */
 
package atm.ui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import atm.ATM;
import atm.exceptions.InvalidCardNumberException;

/** The GUI panel that simulates the reading of the ATM card's magnetic stripe
 *  by asking the user to enter the number
 */
public class CardPanel extends SubPanel implements ActionListener{
	
	/** The field into which the card number is to be entered
     */
    private TextField cardNumberField;
    
    private Label error;
    
    /** Constructor
     */
    public CardPanel(ATM atm) {
    	super(atm);
        setLayout(new GridLayout(0, 1, 0, 0));
        setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        add(new Label("A real ATM would have a magnetic",
                      Label.CENTER));
        add(new Label("stripe reader to read the card",
                      Label.CENTER));
        add(new Label("For purposes of the simulation,",
                      Label.CENTER));
        add(new Label("please enter the card number manually.",
                      Label.CENTER));
        add(new Label("Then press RETURN",
                      Label.CENTER));
        add(new Label("(An invalid integer or an integer not",
                      Label.CENTER));
        add(new Label("greater than zero will be treated as",
                      Label.CENTER));
        add(new Label("an unreadable card)",
                      Label.CENTER));
        
        error = new Label("Incorrect Card Number. Try again.", Label.CENTER);
        error.setForeground(Color.RED);
        error.setVisible(false);
        
        add(error);
        
        cardNumberField = new TextField(30);
        cardNumberField.addActionListener(this);
        Panel cardNumberPanel = new Panel();
        cardNumberPanel.add(cardNumberField);
        add(cardNumberPanel);
    }


	public void actionPerformed(ActionEvent e) {
		String card = cardNumberField.getText();

        try
        {
            atm.checkCardNumber(card);
        }
        catch(InvalidCardNumberException icne)
        {
            error.setVisible(true);
        }
        cardNumberField.setText("");
	}

    
}
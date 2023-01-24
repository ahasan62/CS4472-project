package atm.ui.panels;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import atm.ATM;
import atm.exceptions.InvalidAmountException;
import atm.exceptions.InvalidCredentialsException;

public class AmountPanel extends SubPanel implements ActionListener {

	private JTextField amountField;

	public AmountPanel(ATM atm) {
		super(atm);
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(2,2,2,2));
		
		JPanel panel = new JPanel(new FlowLayout());
		JLabel message = new JLabel("Please insert amount:");
		amountField = new JTextField(15);
		amountField.addActionListener(this);
		JButton ok = new JButton("OK");
		ok.setActionCommand("ok");
		ok.addActionListener(this);
		JButton cancel = new JButton("Cancel");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);

		panel.add(message);
		panel.add(amountField);
		panel.add(ok);
		panel.add(cancel);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if ("cancel".equals(e.getActionCommand())) {
			amountField.setText("");
			
			atm.endSession();
		} else {
			String input = amountField.getText();

			try {
				int amount = Integer.parseInt(input);
				atm.setAmount(amount);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "Incorrect amount format. Try again.");
			} catch (InvalidAmountException iae) {
				JOptionPane.showMessageDialog(this, "Invalid amount for chosen transaction type. Try again.");
			}

			amountField.setText("");
		}
	}

}

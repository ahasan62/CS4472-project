package atm.ui.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import atm.ATM;
import atm.exceptions.InvalidAmountException;

public class InsertMoneyPanel extends SubPanel implements ActionListener{
	private JTextField input50, input20, input10, input5;
	private Label error;

	public InsertMoneyPanel(ATM atm) {
		super(atm);
		this.setLayout(new GridLayout(0,1));
		this.setBorder(new EmptyBorder(2,2,2,2));
		
		JLabel message1 = new JLabel("A real ATM would allow you to insert money.");
		JLabel message2 = new JLabel("For simulation purposes insert amount of notes.");
		
		JPanel moneyPanel = new JPanel(new GridLayout(0, 2));
		JLabel message50 = new JLabel("# of 50s: ");
		input50 = new JTextField(15);
		JLabel message20 = new JLabel("# of 20s: ");
		input20 = new JTextField(15);
		JLabel message10 = new JLabel("# of 10s: ");
		input10 = new JTextField(15);
		JLabel message5 = new JLabel("# of 5s: ");
		input5 = new JTextField(15);
		moneyPanel.add(message50);
		moneyPanel.add(input50);
		moneyPanel.add(message20);
		moneyPanel.add(input20);
		moneyPanel.add(message10);
		moneyPanel.add(input10);
		moneyPanel.add(message5);
		moneyPanel.add(input5);
		
		JButton ok = new JButton("OK");
		ok.setActionCommand("ok");
		ok.addActionListener(this);
		JButton cancel = new JButton("Cancel");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);
		
		error = new Label("", Label.CENTER);
        error.setForeground(Color.RED);
        error.setVisible(false);

		this.add(message1,JLabel.CENTER);
		this.add(message2,JLabel.CENTER);
		this.add(moneyPanel);
		this.add(ok);
		this.add(cancel);
		this.add(error);
	}

	public void actionPerformed(ActionEvent e) {
		if ("cancel".equals(e.getActionCommand())) {
			input50.setText("");
			input20.setText("");
			input10.setText("");
			input5.setText("");
			
			atm.endSession();
		} else {
		
			try {
				String n50Text = input50.getText();
				int n50 = "".equals(n50Text) ? 0 : Integer.parseInt(n50Text);
				String n20Text = input20.getText();
				int n20 = "".equals(n20Text) ? 0 : Integer.parseInt(n20Text);
				String n10Text = input10.getText();
				int n10 = "".equals(n10Text) ? 0 : Integer.parseInt(n10Text);
				String n5Text = input5.getText();
				int n5 = "".equals(n5Text) ? 0 : Integer.parseInt(n5Text);
				int amount = 50 * n50 + 20 * n20 + 10 * n10 + 5 * n5;
				atm.insertMoney(amount);
			} catch (NumberFormatException nfe) {
				error.setText("Please use numbers in integer format.");
				error.setVisible(true);
			} catch (InvalidAmountException iae) {
				error.setText("Incorrect amount of notes. Try again.");
				error.setVisible(true);
			}

			input50.setText("");
			input20.setText("");
			input10.setText("");
			input5.setText("");
		}
	}
}

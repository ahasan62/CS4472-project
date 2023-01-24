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
import atm.exceptions.InvalidCardNumberException;
import atm.exceptions.InvalidCredentialsException;
import atm.exceptions.InvalidPinFormatException;

public class PinPanel extends SubPanel implements ActionListener{
	private JPasswordField pinField;
	
	public PinPanel(ATM atm) {
		super(atm);
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(2,2,2,2));
		
		JPanel panel = new JPanel(new FlowLayout());
		JLabel message = new JLabel("Please insert pin number: ");
		pinField = new JPasswordField(15);
		pinField.addActionListener(this);
		JButton ok = new JButton("OK");
		ok.setActionCommand("ok");
		ok.addActionListener(this);
		JButton cancel = new JButton("Cancel");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);
		
		panel.add(message);
		panel.add(pinField);
		panel.add(ok);
		panel.add(cancel);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if ("ok".equals(e.getActionCommand())) {
			char[] pin = pinField.getPassword();

			try {
				atm.checkPin(pin);
			} catch (InvalidCredentialsException ipe) {
				JOptionPane.showMessageDialog(this, "PIN is incorrect. Try again.");
			} catch (InvalidPinFormatException ipfe) {
				JOptionPane.showMessageDialog(this, "PIN format is incorrect. Try again.");
			}
			pinField.setText("");
		} else {
			pinField.setText("");
			atm.endSession();
		}
	}
}

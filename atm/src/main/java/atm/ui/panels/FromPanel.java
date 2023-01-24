package atm.ui.panels;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import atm.ATM;
import bank.transactions.utils.AccountType;

public class FromPanel extends SubPanel implements ActionListener {
	JRadioButton chequing, savings, tfsa;
	
	public FromPanel(ATM atm) {
		super(atm);
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(2,2,2,2));
		
		JPanel panel = new JPanel(new FlowLayout());
		JLabel message = new JLabel("Choose from account: ");
		chequing = new JRadioButton("Chequing");
		chequing.addActionListener(this);
		savings = new JRadioButton("Savings");
		savings.addActionListener(this);
		tfsa = new JRadioButton("TFSA");
		tfsa.addActionListener(this);
		
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(chequing);
		accountGroup.add(savings);
		accountGroup.add(tfsa);
		
		JButton cancel = new JButton("Cancel");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);
		
		panel.add(message);
		panel.add(chequing);
		panel.add(savings);
		panel.add(tfsa);
		
		this.add(panel);
		this.add(cancel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if ("cancel".equals(e.getActionCommand())) {
			chequing.setSelected(false);
			savings.setSelected(false);
			tfsa.setSelected(false);
			
			atm.endSession();
		} else {
			AccountType type;
			if (chequing.isSelected()) {
				type = AccountType.Chequing;
			} else if (savings.isSelected()) {
				type = AccountType.Savings;
			} else {
				type = AccountType.TFSA;
			}

			atm.setFromAccount(type);

			chequing.setSelected(false);
			savings.setSelected(false);
			tfsa.setSelected(false);
		}
	}

}

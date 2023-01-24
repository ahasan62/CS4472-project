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
import bank.transactions.utils.TransactionType;

public class TransactionPanel extends SubPanel implements ActionListener {
	JRadioButton withdrawal, deposit, transfer;
	
	public TransactionPanel(ATM atm) {
		super(atm);
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(2,2,2,2));
		
		JPanel panel = new JPanel(new FlowLayout());
		JLabel message = new JLabel("Choose transaction type: ");
		withdrawal = new JRadioButton("Withdrawal");
		withdrawal.addActionListener(this);
		deposit = new JRadioButton("Deposit");
		deposit.addActionListener(this);
		transfer = new JRadioButton("Transfer");
		transfer.addActionListener(this);
		
		ButtonGroup transactionGroup = new ButtonGroup();
		transactionGroup.add(withdrawal);
		transactionGroup.add(deposit);
		transactionGroup.add(transfer);
		
		JButton cancel = new JButton("Cancel");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);
		
		panel.add(message);
		panel.add(withdrawal);
		panel.add(deposit);
		panel.add(transfer);
		
		this.add(panel);
		this.add(cancel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if ("cancel".equals(e.getActionCommand())) {
			withdrawal.setSelected(false);
			deposit.setSelected(false);
			transfer.setSelected(false);
			
			atm.endSession();
		} else {
			TransactionType type;
			if (withdrawal.isSelected()) {
				type = TransactionType.Withdrawal;
			} else if (deposit.isSelected()) {
				type = TransactionType.Deposit;
			} else {
				type = TransactionType.Transfer;
			}

			atm.setTransaction(type);

			withdrawal.setSelected(false);
			deposit.setSelected(false);
			transfer.setSelected(false);
		}
	}

}

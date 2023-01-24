package atm.ui.panels;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atm.ATM;

public class InsertCardPanel extends SubPanel implements ActionListener{

	public InsertCardPanel(ATM atm) {
		super(atm);
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(2,2,2,2));
		
		JPanel panel = new JPanel(new FlowLayout());
		JLabel message = new JLabel("Please insert card.");
		JButton insert = new JButton("Insert card");
		insert.addActionListener(this);
		
		panel.add(message);
		panel.add(insert);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		atm.createSession();
	}
}

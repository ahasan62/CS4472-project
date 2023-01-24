package atm.ui.panels;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import atm.ATM;

public class ResultPanel extends SubPanel implements ActionListener {
	JTextArea resultArea;
	
	public ResultPanel(ATM atm) {
		super(atm);
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(2,2,2,2));
		
		JPanel panel = new JPanel(new FlowLayout());
		resultArea = new JTextArea(15, 40);
		JScrollPane resultPane = new JScrollPane(
												 resultArea, 
												 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
												 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
												);
		
		JLabel otherTransaction = new JLabel("Do you wish to perform another transaction?");
		JButton yes = new JButton("Yes");
		yes.setActionCommand("yes");
		yes.addActionListener(this);
		JButton no = new JButton("No");
		no.setActionCommand("no");
		no.addActionListener(this);
		
		panel.add(resultPane);
		panel.add(otherTransaction);
		panel.add(yes);
		panel.add(no);
		
		this.add(panel);
		
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if ("yes".equals(actionCommand)) {
			atm.anotherTransaction();
		} else {
			atm.endSession();
		}
		
	}

	public void setText(String resultText) {
		resultArea.setText(resultText);
	}

}

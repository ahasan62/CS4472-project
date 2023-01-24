package atm.ui.panels;

import javax.swing.JPanel;

import atm.ATM;

abstract public class SubPanel extends JPanel {
	protected ATM atm;

	public SubPanel(ATM atm) {
		super();
		this.atm = atm;
	}
}

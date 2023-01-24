package atm.session.states;

import atm.session.Session;

public class ToState implements SessionState {

	public void perform(Session session) {
		session.getMainPanel().changeLayout("Amount");
		session.setState(new AmountState());
	}

}

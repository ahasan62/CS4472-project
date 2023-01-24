package atm.session.states;

import atm.session.Session;

public class PendingCardState implements SessionState {

	public void perform(Session session) {
		session.getMainPanel().changeLayout("Card");
		session.setState(new CardNumberState());
	}
	

}

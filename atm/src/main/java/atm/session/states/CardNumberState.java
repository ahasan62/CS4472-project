package atm.session.states;

import atm.session.Session;

public class CardNumberState implements SessionState {

	public void perform(Session session) {
		session.getMainPanel().changeLayout("Pin");
		session.setState(new PinNumberState());
	}

}

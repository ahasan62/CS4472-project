package atm.session.states;

import atm.session.Session;

public class ResultState implements SessionState {

	public void perform(Session session) {
		session.getMainPanel().changeLayout("Transaction");
		session.setState(new TransactionState());
	}

}

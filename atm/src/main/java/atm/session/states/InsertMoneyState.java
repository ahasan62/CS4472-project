package atm.session.states;

import atm.session.Session;

public class InsertMoneyState implements SessionState {

	public void perform(Session session) {
		session.performTransaction();
		session.getMainPanel().setResult(session.createResultText());
		session.getMainPanel().changeLayout("Result");
		session.setState(new ResultState());
	}

}

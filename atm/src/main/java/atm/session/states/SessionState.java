package atm.session.states;

import atm.session.Session;

public interface SessionState {
	public void perform(Session session);

}

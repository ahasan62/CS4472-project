package atm.session.states;

import atm.session.Session;
import bank.transactions.utils.TransactionType;

public class TransactionState implements SessionState {

	public void perform(Session session) {
		if (session.getTransactionType() == TransactionType.Deposit) {
			session.getMainPanel().changeLayout("To");
			session.setState(new ToState());
		} else {
			session.getMainPanel().changeLayout("From");
			session.setState(new FromState());
		}
	}

}

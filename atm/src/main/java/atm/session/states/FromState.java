package atm.session.states;

import atm.session.Session;
import bank.transactions.utils.TransactionType;

public class FromState implements SessionState {

	public void perform(Session session) {
		TransactionType type = session.getTransactionType();
		
		if (type == TransactionType.Transfer) {
			session.getMainPanel().changeLayout("To");
			session.setState(new ToState());
		} else {	
			session.getMainPanel().changeLayout("Amount");
			session.setState(new AmountState());
		}
	}

}

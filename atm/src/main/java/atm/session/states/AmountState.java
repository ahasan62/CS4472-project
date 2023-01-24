package atm.session.states;

import atm.session.Session;
import bank.transactions.utils.TransactionType;

public class AmountState implements SessionState {

	public void perform(Session session) {
		if (session.getTransactionType() == TransactionType.Deposit) {
			session.getMainPanel().changeLayout("InsertMoney");
			session.setState(new InsertMoneyState());
		} else {
			session.performTransaction();
			session.getMainPanel().setResult(session.createResultText());
			session.getMainPanel().changeLayout("Result");
			session.setState(new ResultState());
		}
	}

}

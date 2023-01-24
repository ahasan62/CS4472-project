package atm.utils;

import atm.dispatcher.MessageDispatcher;
import atm.exceptions.InvalidCredentialsException;

public class CredentialsCheck {
	private MessageDispatcher dispatcher;

	public CredentialsCheck(MessageDispatcher dispatcher) {
		super();
		this.dispatcher = dispatcher;
	}

	public void perform(String card, char[] pin) throws InvalidCredentialsException {
		boolean credentialsCorrect = dispatcher.checkCredentials(card, pin);
		
		if (!credentialsCorrect)
			throw new InvalidCredentialsException();
	}

}

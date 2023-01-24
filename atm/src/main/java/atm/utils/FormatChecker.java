package atm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import atm.exceptions.InvalidCardNumberException;
import atm.exceptions.InvalidPinFormatException;

public class FormatChecker {

	public void checkCardFormat(String card) throws InvalidCardNumberException {
		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + 
					   "(?<mastercard>5[1-5][0-9]{14})|" + 
					   "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + 
					   "(?<amex>3[47][0-9]{13})|" + 
					   "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + 
					   "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

		Pattern pattern = Pattern.compile(regex);

		// Strip all hyphens
		card = card.replaceAll("-", "");
		// Strip all spaces
		card = card.replaceAll(" ", "");

		// Match the card
		Matcher matcher = pattern.matcher(card);

		if (!matcher.matches()) {
			throw new InvalidCardNumberException();
		}
	}
	
	public void checkPinFormat(char[] pin) throws InvalidPinFormatException {
		if (pin.length == 5) {
			for (int i = 0; i < 5; i++) {
				if ((pin[i] < '0') || (pin[i] >= '9'))
					throw new InvalidPinFormatException();
			}
		} else {
			throw new InvalidPinFormatException();
		}
	}

}

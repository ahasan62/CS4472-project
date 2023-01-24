package atm.utils;

public class CashValidator {
	public static boolean validateDeposit(int amount){
		boolean result = true;
		int newAmount;
		newAmount = amount % 50;
		if (!(newAmount == 0)) {
			newAmount = newAmount % 20;
			if (!(newAmount == 0)) {
				newAmount = newAmount % 10;
				if (!(newAmount == 0)) {
					result = false;
				}
			}
		}
		return result;
	}

	public static boolean validateWithdrawal(int amount) {
		boolean result = true;
		int newAmount;
		newAmount = amount % 50;
		if (!(newAmount == 0)) {
			newAmount = newAmount % 20;
			if (!(newAmount == 0)) {
				result = false;
			}
		}

		return result;
	}
}

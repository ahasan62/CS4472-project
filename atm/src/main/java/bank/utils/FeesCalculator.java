package bank.utils;

import java.util.Calendar;

public class FeesCalculator {
	public double calculateWithdrawalFee(double amount, double accountBalance, boolean student, int dayOfWeek) {
		// Calculate fee percentage
		double feePercentage;
		// Check if student
		if (student) {
			// Check if it's weekend
			if ((dayOfWeek == Calendar.SATURDAY) || (dayOfWeek == Calendar.SUNDAY)) {
				feePercentage = 0.001;
			} else {
				feePercentage = 0.0;
			}
		} else {
			if (accountBalance < 1000.00) {
				feePercentage = 0.003;
			} else if (accountBalance < 5000.00) {
				feePercentage = 0.001;
			} else {
				feePercentage = 0.0;
			}
		}
		
		// Calculate fee
		double fee = amount * feePercentage;
		
		return fee;
	}
	
	public double calculateDepositInterest(double amount, double accountBalance, boolean student) {
		// Calculate interest percentage
		double interestPercentage;
		// Check if student
		if (student) {
			// Check amount deposited
			if (amount > 50.00) {
				// Check balance
				if (accountBalance > 500.00) {
					interestPercentage = 0.005;
				} else {
					interestPercentage = 0.0025;
				}
			} else {
				if (accountBalance > 5000.00) {
					interestPercentage = 0.005;
				} else {
					interestPercentage = 0.002;
				}
			}
		} else {
			if (amount > 250.00) {
				if (accountBalance > 2500.00) {
					interestPercentage = 0.008;
				} else {
					interestPercentage = 0.004;
				}
			} else {
				if (accountBalance > 10000.00) {
					interestPercentage = 0.005;
				} else {
					interestPercentage = 0.001;
				}
			}
		}
		
		// Calculate interest
		double interest = amount * interestPercentage;
		
		return interest;
	}
	
	public double calculateTransferFee(double amount, double fromAccountBalance, double toAccountBalance, boolean student) {
		// Calculate fee percentage
		double feePercentage;
		// Check if student
		if (student) {
			if (amount < 200.00) {
				if (fromAccountBalance < 2000.00) {
					if (toAccountBalance < 1000.00) {
						feePercentage = 0.001;
					} else {
						feePercentage = 0.0005;
					}
				} else {
					if (toAccountBalance < 1000.00) {
						feePercentage = 0.0005;
					} else {
						feePercentage = 0.00025;
					}
				}
			} else {
				if (fromAccountBalance < 2000.00) {
					if (toAccountBalance < 1000.00) {
						feePercentage = 0.005;
					} else {
						feePercentage = 0.0025;
					}
				} else {
					if (toAccountBalance < 1000.00) {
						feePercentage = 0.025;
					} else {
						feePercentage = 0.0125;
					}
				}
			}
		} else {
			if (amount < 100.00) {
				if (fromAccountBalance < 4000.00) {
					if (toAccountBalance < 2000.00) {
						feePercentage = 0.002;
					} else {
						feePercentage = 0.01;
					}
				} else {
					if (toAccountBalance < 2000.00) {
						feePercentage = 0.1;
					} else {
						feePercentage = 0.03;
					}
				}
			} else {
				if (fromAccountBalance < 2000.00) {
					if (toAccountBalance < 1000.00) {
						feePercentage = 0.02;
					} else {
						feePercentage = 0.01;
					}
				} else {
					if (toAccountBalance < 2000.00) {
						feePercentage = 0.05;
					} else {
						feePercentage = 0.055;
					}
				}
			}
		}
		
		// Calculate fee
		double fee = amount * feePercentage;
		
		return fee;
	}
}

package bank.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Use of Parameterized helps in this case, since multiple runs of same test are required
class FeesCalculatorTest {
	FeesCalculator calculator = new FeesCalculator();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void withdrawalTest() {
//		assertEquals(0.2, calculator.calculateWithdrawalFee(200, 1000, false, 0));		//pass
//		assertEquals(0.01, calculator.calculateWithdrawalFee(200, 1000, false, 0));	//fail
		///
		
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, -5, true, 1));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, -5, false, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, -5, true, 6));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, -5, false, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, -5, true, 4));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, -5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, -5, true, 7));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, -5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 0, true, 1));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 0, false, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 0, true, 6));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 0, false, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 0, true, 4));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 0, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 0, true, 7));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 0, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5, true, 1));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 5, false, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 5, true, 6));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 5, false, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 5, true, 4));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5, true, 7));
		assertEquals(-0.015, calculator.calculateWithdrawalFee(-5, 5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 1000, true, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 1000, false, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 1000, true, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 1000, false, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 1000, true, 4));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 1000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 1000, true, 7));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 1000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 4999, true, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 4999, false, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 4999, true, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 4999, false, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 4999, true, 4));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 4999, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 4999, true, 7));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 4999, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5000, false, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 5000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5000, false, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 5000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5005, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5005, false, 1));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 5005, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5005, false, 6));
		assertEquals(-0.005, calculator.calculateWithdrawalFee(-5, 5005, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5005, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5005, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(-5, 5005, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, false, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, false, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, -5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, false, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, false, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 0, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, false, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, false, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, false, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, false, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 1000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, false, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, false, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 4999, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, false, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, false, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, false, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, false, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(0, 5005, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, -5, true, 1));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, -5, false, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, -5, true, 6));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, -5, false, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, -5, true, 4));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, -5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, -5, true, 7));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, -5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 0, true, 1));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 0, false, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 0, true, 6));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 0, false, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 0, true, 4));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 0, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 0, true, 7));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 0, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5, true, 1));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 5, false, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 5, true, 6));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 5, false, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 5, true, 4));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5, true, 7));
		assertEquals(0.015, calculator.calculateWithdrawalFee(5, 5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 1000, true, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 1000, false, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 1000, true, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 1000, false, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 1000, true, 4));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 1000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 1000, true, 7));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 1000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 4999, true, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 4999, false, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 4999, true, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 4999, false, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 4999, true, 4));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 4999, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 4999, true, 7));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 4999, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5000, false, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 5000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5000, false, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 5000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5005, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5005, false, 1));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 5005, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5005, false, 6));
		assertEquals(0.005, calculator.calculateWithdrawalFee(5, 5005, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5005, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5005, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5, 5005, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, -5, true, 1));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, -5, false, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, -5, true, 6));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, -5, false, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, -5, true, 4));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, -5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, -5, true, 7));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, -5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 0, true, 1));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 0, false, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 0, true, 6));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 0, false, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 0, true, 4));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 0, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 0, true, 7));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 0, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5, true, 1));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 5, false, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 5, true, 6));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 5, false, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 5, true, 4));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5, true, 7));
		assertEquals(3.0, calculator.calculateWithdrawalFee(1000, 5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 1000, true, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 1000, false, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 1000, true, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 1000, false, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 1000, true, 4));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 1000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 1000, true, 7));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 1000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 4999, true, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 4999, false, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 4999, true, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 4999, false, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 4999, true, 4));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 4999, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 4999, true, 7));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 4999, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5000, false, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 5000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5000, false, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 5000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5005, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5005, false, 1));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 5005, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5005, false, 6));
		assertEquals(1.0, calculator.calculateWithdrawalFee(1000, 5005, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5005, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5005, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(1000, 5005, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, -5, true, 1));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, -5, false, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, -5, true, 6));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, -5, false, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, -5, true, 4));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, -5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, -5, true, 7));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, -5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 0, true, 1));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 0, false, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 0, true, 6));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 0, false, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 0, true, 4));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 0, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 0, true, 7));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 0, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5, true, 1));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 5, false, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 5, true, 6));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 5, false, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 5, true, 4));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5, true, 7));
		assertEquals(14.997, calculator.calculateWithdrawalFee(4999, 5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 1000, true, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 1000, false, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 1000, true, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 1000, false, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 1000, true, 4));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 1000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 1000, true, 7));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 1000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 4999, true, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 4999, false, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 4999, true, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 4999, false, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 4999, true, 4));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 4999, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 4999, true, 7));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 4999, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5000, false, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 5000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5000, false, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 5000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5005, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5005, false, 1));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 5005, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5005, false, 6));
		assertEquals(4.999, calculator.calculateWithdrawalFee(4999, 5005, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5005, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5005, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(4999, 5005, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, -5, true, 1));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, -5, false, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, -5, true, 6));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, -5, false, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, -5, true, 4));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, -5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, -5, true, 7));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, -5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 0, true, 1));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 0, false, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 0, true, 6));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 0, false, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 0, true, 4));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 0, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 0, true, 7));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 0, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5, true, 1));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 5, false, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 5, true, 6));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 5, false, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 5, true, 4));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5, true, 7));
		assertEquals(15.0, calculator.calculateWithdrawalFee(5000, 5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 1000, true, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 1000, false, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 1000, true, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 1000, false, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 1000, true, 4));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 1000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 1000, true, 7));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 1000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 4999, true, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 4999, false, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 4999, true, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 4999, false, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 4999, true, 4));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 4999, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 4999, true, 7));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 4999, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5000, false, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 5000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5000, false, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 5000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5005, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5005, false, 1));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 5005, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5005, false, 6));
		assertEquals(5.0, calculator.calculateWithdrawalFee(5000, 5005, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5005, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5005, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5000, 5005, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, -5, true, 1));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, -5, false, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, -5, true, 6));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, -5, false, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, -5, true, 4));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, -5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, -5, true, 7));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, -5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 0, true, 1));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 0, false, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 0, true, 6));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 0, false, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 0, true, 4));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 0, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 0, true, 7));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 0, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5, true, 1));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 5, false, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 5, true, 6));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 5, false, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 5, true, 4));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 5, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5, true, 7));
		assertEquals(15.015, calculator.calculateWithdrawalFee(5005, 5, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 1000, true, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 1000, false, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 1000, true, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 1000, false, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 1000, true, 4));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 1000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 1000, true, 7));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 1000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 4999, true, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 4999, false, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 4999, true, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 4999, false, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 4999, true, 4));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 4999, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 4999, true, 7));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 4999, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5000, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5000, false, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 5000, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5000, false, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 5000, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5000, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5000, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5000, false, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5005, true, 1));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5005, false, 1));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 5005, true, 6));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5005, false, 6));
		assertEquals(5.005, calculator.calculateWithdrawalFee(5005, 5005, true, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5005, false, 4));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5005, true, 7));
		assertEquals(0.0, calculator.calculateWithdrawalFee(5005, 5005, false, 7));

	}
	
	@Test
	void BankDepositTest() {
		assertEquals(0.5750000000000001, calculator.calculateDepositInterest(115, 1750, true));
		assertEquals(0.025, calculator.calculateDepositInterest(25, 250, false));
		assertEquals(3.75, calculator.calculateDepositInterest(750, 3750, true));
		assertEquals(0.225, calculator.calculateDepositInterest(225, 7500, false));
		assertEquals(0.5750000000000001, calculator.calculateDepositInterest(115, 15000, true));
		assertEquals(-0.05, calculator.calculateDepositInterest(-50, 1750, false));
		
		
	}
	@Test
	void BankTransferTest() { 
		//original
		assertEquals(0.1,calculator.calculateTransferFee(100, 1000, 500, true));
		//flip at 4
		assertEquals(0.05,calculator.calculateTransferFee(100, 1000, 1500, true));
		//flip at 3
		assertEquals(0.05,calculator.calculateTransferFee(100, 2500, 500, true));
		// flip at 7 
		assertEquals(0.025,calculator.calculateTransferFee(100, 2500, 1500, true));

		
		//flip at 2
		assertEquals(0.05,calculator.calculateTransferFee(300, 1000, 500, true));
		//flip at 11
		assertEquals(0.025,calculator.calculateTransferFee(100, 1000, 1500, true));
		//flip at 10
		assertEquals(0.25,calculator.calculateTransferFee(100, 2500, 500, true));
		//flip at 14
		assertEquals(0.125,calculator.calculateTransferFee(100, 2500, 1500, true));

		
		//flip at 1
		assertEquals(0.2,calculator.calculateTransferFee(50, 3500, 1500, false));
		//flip at 19
		assertEquals(0.1,calculator.calculateTransferFee(50, 3500, 2500, false));
		//flip at 18 
		assertEquals(1,calculator.calculateTransferFee(50, 4500, 1500, false));
		//flip at 22
		assertEquals(0.5,calculator.calculateTransferFee(50, 4500, 2500, false));

		
		//flip at 17 
		assertEquals(0.2,calculator.calculateTransferFee(150, 1500, 500, false));
		//flip at 26 
		assertEquals(0.1,calculator.calculateTransferFee(150, 1500, 1500, false));
		//flip at 25
		assertEquals(0.5,calculator.calculateTransferFee(150, 2500, 500, false));
		//flip at 29
		assertEquals(0.25,calculator.calculateTransferFee(150, 2500, 1500, false));

		
	}
	
	
}

	



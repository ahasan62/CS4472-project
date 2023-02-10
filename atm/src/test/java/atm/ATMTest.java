package atm;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;

import atm.dispatcher.MessageDispatcher;
import atm.exceptions.InvalidAmountException;
import atm.exceptions.InvalidCredentialsException;
import atm.exceptions.InvalidPinFormatException;
import atm.ui.panels.MainPanel;
import atm.utils.CredentialsCheck;
import atm.utils.FormatChecker;
import bank.transactions.utils.TransactionType;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ATMTest {
	ATM atm;
	MessageDispatcher dispatcher;
	

	@BeforeEach
	public void setUp() throws Exception {
		dispatcher = Mockito.mock(MessageDispatcher.class);
		FormatChecker formatCheck = new FormatChecker();
		CredentialsCheck credentialsCheck = new CredentialsCheck(dispatcher);
		atm = new ATM(formatCheck, credentialsCheck, dispatcher);
		
		MainPanel mainPanel = Mockito.mock(MainPanel.class);
		atm.setMainPanel(mainPanel);
		atm.createSession();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	private static Stream<Arguments> pinData() {
		return Stream.of(
			Arguments.of("Min-", true, new char[]{'/','3','3','3','3'}),
			Arguments.of("Min", false, new char[]{'0','0','0','0','0'}),
			Arguments.of("Min+", false, new char[]{'1','1','1','1','1'}),
			Arguments.of("Nom", false, new char[]{'3','3','3','3','3'}),
			Arguments.of("Max-", false, new char[]{'8','8','8','8','8'}),
			Arguments.of("Max", false, new char[]{'9','9','9','9','9'}),
			Arguments.of("Max+", true, new char[]{':','3','3','3','3'}),
			
			
			Arguments.of("WorstMax1", true, new char[]{':',':','3','3','3'}),
			Arguments.of("WorstMax2", true, new char[]{':',':',':','3','3'}),
			Arguments.of("WorstMax3", true, new char[]{':',':',':',':','3'}),
			Arguments.of("WorstMax4", true, new char[]{':',':',':',':',':'}),
			
			Arguments.of("WorstMin1", true, new char[]{'/','/','3','3','3'}),
			Arguments.of("WorstMin2", true, new char[]{'/','/','/','3','3'}),
			Arguments.of("WorstMin3", true, new char[]{'/','/','/','/','3'}),
			Arguments.of("WorstMin4", true, new char[]{'/','/','/','/','/'})
		);
	}
	
    @ParameterizedTest(name = "[{index}] - {0} | {2}")
	@MethodSource("pinData")
	public void checkPINTest(String name, boolean throwsError, char[] pin) {
		if (throwsError) {
            Assertions.assertThrows(InvalidPinFormatException.class, () -> {
                atm.checkPin(pin);
            });
        } else {
        	Mockito.when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
            Assertions.assertDoesNotThrow(() -> atm.checkPin(pin));
        }
	}
    
    @Test
    public void checkWithdrawAmount_1000() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertDoesNotThrow(() -> atm.setAmount(1000));
    }
    
    @Test
    public void checkWithdrawAmount_999() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertThrows(InvalidAmountException.class, () -> atm.setAmount(999));
    }
    
    @Test
    public void checkWithdrawAmount_1001() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertThrows(InvalidAmountException.class, () -> atm.setAmount(1001));
    }
    
    @Test
    public void checkWithdrawAmount_500() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertDoesNotThrow(() -> atm.setAmount(500));
    }
    
    @Test
    public void checkWithdrawAmount_0() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertDoesNotThrow(() -> atm.setAmount(0));
    }
    
    @Test
    public void checkWithdrawAmount_1() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertThrows(InvalidAmountException.class, () -> atm.setAmount(1));
    }
    
    @Test
    public void checkWithdrawAmount_1100() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertDoesNotThrow(() -> atm.setAmount(1100));
    }
    
    @Test
    public void checkWithdrawAmount_2000() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertDoesNotThrow(() -> atm.setAmount(2000));
    }
    
    @Test
    public void checkWithdrawAmount_5000() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertDoesNotThrow(() -> atm.setAmount(5000));
    }
    
    @Test
    public void checkWithdrawAmount_5001() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertThrows(InvalidAmountException.class, () -> atm.setAmount(5001));
    }
    
    @Test
    public void checkWithdrawAmount__1() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertThrows(InvalidAmountException.class, () -> atm.setAmount(-1));
    }
    
    @Test
    public void checkWithdrawAmount__10() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertThrows(InvalidAmountException.class, () -> atm.setAmount(-10));
    }
    
    @Test
    public void checkWithdrawAmount__100() {
    	atm.setTransaction(TransactionType.Withdrawal);
    	Assertions.assertThrows(InvalidAmountException.class, () -> atm.setAmount(-100));
    }
    
}

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
import atm.exceptions.InvalidCredentialsException;
import atm.exceptions.InvalidPinFormatException;
import atm.ui.panels.MainPanel;
import atm.utils.CredentialsCheck;
import atm.utils.FormatChecker;

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

//	@Test
//	public void checkCorrectPINTest() {
//		Mockito.when(dispatcher.checkCredentials(null, new char[] {'5','5','5','5','5'})).thenReturn(true);
//		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'5','5','5','5','5'}));
//	}
//	
//	@Test
//	public void checkIncorrectPINTest() {
//		Mockito.when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
//		Assertions.assertThrows(InvalidCredentialsException.class, () -> atm.checkPin(new char[] {'5','5','5','4','5'}));
//	}
//	
//	@Test
//	public void checkMinPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
//		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'0','0','0','0','0'}));
//
//	}
//	
//	
//	@Test
//	public void checkMaxPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
//		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'5','5','5','5','5'}));
//	}
//	
//	@Test
//	public void checkJustAboveMinPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
//		Assertions.assertThrows(InvalidPinFormatException.class, () -> atm.checkPin(new char[] {'5','4'}));
//	}
//	
//	@Test
//	public void checkJustAboveMaxPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
//		Assertions.assertThrows(InvalidPinFormatException.class, () -> atm.checkPin(new char[] {'5','4','1','3','2','9'}));
//	}
//	
//	@Test
//	public void checkJustBelowMaxPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
//		Assertions.assertThrows(InvalidPinFormatException.class, () -> atm.checkPin(new char[] {'5','4','1','3'}));
//	}
//	
//	@Test
//	public void checkJustBelowMinPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
//		Assertions.assertThrows(InvalidPinFormatException.class, () -> atm.checkPin(new char[] {}));
//	}
//	
//	@Test
//	public void checkSameValuesPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
//		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'2','2','2','2','2'}));
//	}
//	
//	@Test
//	public void checkAlternateCharsPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
//		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'2','8','2','8','2'}));
//	}
//	
//	@Test
//	public void checkIncreasingCharsPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
//		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'1','2','3','4','5'}));
//	}
//	
//	@Test
//	public void checkDecreasingCharsPinTest() {
//		Mockito.when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
//		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'8','7','5','2','1'}));
//	}
//	
//	@Test
//	public void checkSpecialCharsPinTest() {
//		Mockito.lenient().when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
//		Assertions.assertThrows(InvalidPinFormatException.class, () -> atm.checkPin(new char[] {'!','4','%','3',')'}));
//	}

}

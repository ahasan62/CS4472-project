package atm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;

import atm.dispatcher.MessageDispatcher;
import atm.exceptions.InvalidCredentialsException;
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

	@Test
	public void checkCorrectPINTest() {
		Mockito.when(dispatcher.checkCredentials(null, new char[] {'5','5','5','5'})).thenReturn(true);
		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'5','5','5','5'}));
	}
	
	@Test
	public void checkIncorrectPINTest() {
		Mockito.when(dispatcher.checkCredentials(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
		Assertions.assertThrows(InvalidCredentialsException.class, () -> atm.checkPin(new char[] {'5','5','5','4'}));
	}

}

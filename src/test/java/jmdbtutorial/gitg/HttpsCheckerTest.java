package jmdbtutorial.gitg;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import jmdbtutorial.gitg.logging.ConsoleLogging;

public class HttpsCheckerTest {
	
	@BeforeClass
    public static void setup() {
        ConsoleLogging.initialise();
    }
	
	@Test
	public void shouldReturnValidMessageWhenURLContainsHTTPS() {
		assertEquals("Tag contains a secure URL", HttpsChecker.check());
	}
	

	

}

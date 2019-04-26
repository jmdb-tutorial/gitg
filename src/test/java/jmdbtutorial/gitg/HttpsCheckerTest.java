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
		assertEquals("Tag contains a secure URL", "Tag contains a secure URL");
	}
	
	@Test
	public void should_return_a_secure_message_when_URL_contains_HTTPS() {
		String tag = "https";
		assertEquals("Tag contains a secure URL", HttpsChecker.check(tag));
	}
	
	@Test
	public void should_return_an_unsecure_message_when_URL_does_not_contain_HTTPS() {
		String tag = "bob is foo";
		assertEquals("Tag does not contain a secure URL", HttpsChecker.check(tag));
	}

}

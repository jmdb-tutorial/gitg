package jmdbtutorial.gitg;

import jmdbtutorial.gitg.logging.ConsoleLogging;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IntegrationTest {

    @BeforeClass
    public static void setup() {
        ConsoleLogging.initialise();
    }

    @Test
    public void status_should_be_up() {

        Http.Response response = Http.GET("http://localhost:8080/status");

        assertThat(response.statusCode, is(200));



    }

}

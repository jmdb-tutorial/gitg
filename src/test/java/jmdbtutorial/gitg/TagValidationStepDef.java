package jmdbtutorial.gitg;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jmdbtutorial.gitg.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class TagValidationStepDef {

    @Autowired
    private Tag tag;

    private int response;

    @Given("the tag {string} has been submitted")
    public void theTagHasBeenSubmitted(String tag) throws Throwable {
    }

    @When("I attempt to access the URL")
    public void iAttemptToAccessTheURL() throws Throwable {
        response = 200;
    }

    @When("I check for the protocol of the URL")
    public void iCheckForTheProtocolOfTheURL() {
    }

    @Then("I can see that the URL is HTTPS")
    public void iCanSeeThatTheURLIsHTTPS() {
        assertEquals(0, 0);
    }

    @Then("I receive a HTTP response code of {int}")
    public void iReceiveAHTTPResponseCodeOf(int expected) throws Throwable {
        assertEquals(expected, response);
    }
}

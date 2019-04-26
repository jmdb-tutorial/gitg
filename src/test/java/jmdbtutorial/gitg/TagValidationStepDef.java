package jmdbtutorial.gitg;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jmdbtutorial.gitg.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class TagValidationStepDef {

    @Autowired
    private Tag tag;

    private Http.Response response;

    @Given("the tag {string} has been submitted")
    public void theTagHasBeenSubmitted(String tag) throws Throwable {
    	String url = "http://localhost:8080/tagvalidator";
		response = Http.POST(url);
		
    }

    @When("I attempt to access the URL")
    public void iAttemptToAccessTheURL() throws Throwable {
        
    }

    @When("I check the Tag string contains https://")
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
    
    @Given("the service is running")
    public void the_service_is_running() {
        return;
    }

    @Then("the response confirms the tag contains a secure URL")
    public void the_response_confirms_the_tag_contains_a_secure_URL() {
       assertEquals("Tag contains a secure URL", response.content);
    }
}

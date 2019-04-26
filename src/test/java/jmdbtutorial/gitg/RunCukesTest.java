package jmdbtutorial.gitg;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-html-reports", "junit:/tmp/output", "json:target/cucumber-html-reports/cucumber.json"},
        snippets = SnippetType.CAMELCASE
)
public class RunCukesTest {
    // this is the adapter/bridge code
    // between cucumber jvm and junit
    // you do not need to edit this
}

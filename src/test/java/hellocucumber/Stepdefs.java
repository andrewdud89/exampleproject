package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmail.steps.AboutPageSteps;
import gmail.steps.SigInPageSteps;
import gmail.utills.Base;

import static junit.framework.TestCase.assertEquals;

public class Stepdefs extends Base {
    private AboutPageSteps aboutPageSteps = new AboutPageSteps();
    private SigInPageSteps sigInPageSteps = new SigInPageSteps();
    String url="https://www.google.com/intl/ru/gmail/about/";


    @Given("^Open gmail url$")
    public void openGmailUrl() {
        getDriver().get(url);
    }

    @Given("^Sign in$")
    public void openGmailAboutPage() {
        aboutPageSteps.signIn();
    }

    @When("^Fill email \"([^\"]*)\"$")
    public void fillEmail(String arg) {
        sigInPageSteps.fillPhoneOrEmailAndNext(arg);
    }

    @When("^Fill password \"([^\"]*)\"$")
    public void fillPassword(String arg) {
        sigInPageSteps.fillPasswordAndNext(arg);
    }

    @Then("^the result should be (.+)$")
    public void the_result_should_be(String expectedResult) {
        String result=sigInPageSteps.getErrorMessage();
        assertEquals(expectedResult, result);
    }
    @Then("^Close Brouser$")
    public void closeBrouser() {
        Base.shutDownDriver();
    }



}
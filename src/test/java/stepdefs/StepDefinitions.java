package stepdefs;

import com.igor.business.LogInBO;
import com.igor.business.MessageBO;
import com.igor.utils.provider.DriverProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

import static com.igor.utils.constant.Constants.EXPLICIT_WAIT;
import static com.igor.utils.parser.JsonParser.*;

public class StepDefinitions {
    private LogInBO logInBO;
    private MessageBO messageBO;
    private String title;
    private String message = getMessage();

    public StepDefinitions(){
        logInBO = new LogInBO();
        messageBO = new MessageBO();
        title = UUID.randomUUID().toString();
    }
    @When("^I fill username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iFillUsernameAndPassword(String arg0, String arg1) {
        logInBO.logIn(arg0, arg1);
    }

    @Then("^I am on the \"([^\"]*)\" page$")
    public void iAmOnThePage(String arg0) {
        (new WebDriverWait(DriverProvider.getDriver(), EXPLICIT_WAIT)).until(ExpectedConditions.urlContains(arg0));
        Assert.assertTrue(DriverProvider.getDriver().getCurrentUrl().contains(arg0), "User logged in");
    }

    @And("^I click on Send button$")
    public void iClickOnSendButton() {
        messageBO.sendMessage();
    }

    @Then("^alert dialog appear$")
    public void alertDialogAppear() {
        Assert.assertTrue(messageBO.isAlertWidgetVisible(), "Alert dialog appeared");
    }

    @And("^I correct receiver with \"([^\"]*)\"$")
    public void iCorrectReceiverWith(String arg0) {
        messageBO.correctReceiver(arg0);
    }

    @When("^I send letter with receiver, title, message$")
    public void iSendLetterWithReceiverTitleMessage() {
        messageBO.fillFieldsForMessage(getIncorrectReceiver(), title, message);
    }

    @Then("^letter with title should be in sent$")
    public void letterWithTitleShouldBeInSent() {
        Assert.assertTrue(messageBO.isLetterSent(title), "Letter was sent successfully");
    }
}

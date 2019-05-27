package stepdefs;

import com.igor.business.LogInBO;
import com.igor.business.MessageBO;
import com.igor.model.Letter;
import com.igor.utils.provider.DriverProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

import static com.igor.utils.constant.Constants.EXPLICIT_WAIT;
import static com.igor.utils.parser.JsonParser.getIncorrectReceiver;
import static com.igor.utils.parser.JsonParser.getMessage;

public class StepDefinitions {
    private LogInBO logInBO;
    private MessageBO messageBO;
    private Letter letter;

    private Logger logger = LogManager.getLogger(StepDefinitions.class);

    public StepDefinitions() {
        logInBO = new LogInBO();
        messageBO = new MessageBO();
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

    @When("^I send letter with receiver, topic, message$")
    public void iSendLetterWithReceiverTitleMessage() {
        letter = new Letter(getIncorrectReceiver(), UUID.randomUUID().toString(), getMessage());
        messageBO.fillFieldsForMessage(letter);
    }

    @And("^I correct receiver with \"([^\"]*)\"$")
    public void iCorrectReceiverWith(String arg0) {
        letter.setReceiver(arg0);
        messageBO.correctReceiver(arg0);
    }

    @Then("^letter with title should be in sent$")
    public void letterWithTitleShouldBeInSent() {
        Assert.assertTrue(messageBO.isLetterSent(letter), "Letter was sent successfully");
        logger.info("Test passed");
    }
}

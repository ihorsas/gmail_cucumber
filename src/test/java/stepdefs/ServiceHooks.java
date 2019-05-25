package stepdefs;

import com.igor.utils.property.Property;
import com.igor.utils.provider.DriverProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceHooks {
    private static final Logger LOGGER = LogManager.getLogger(ServiceHooks.class);

    @Before
    public void initializeTest(){
        DriverProvider.getDriver().get(Property.getProperty("initial_page"));
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        DriverProvider.quit();
        if (scenario.isFailed()) {
            try {
                File scrFile = ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
                String currentDate = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date(System.currentTimeMillis()));
                FileUtils.copyFile(scrFile, new File(String.format("screenshots/screenshot-Date %s Thread %s.png", currentDate, Thread.currentThread().getId())));
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
package stepdefs;

import com.igor.utils.property.Property;
import com.igor.utils.provider.DriverProvider;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks {
    @Before
    public void tearUp() {
        DriverProvider.getDriver().get(Property.getProperty("initial_page"));
    }

    @After
    public void tearDown() {
        DriverProvider.quit();
    }
}
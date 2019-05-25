package com.igor.listener;

import com.igor.utils.provider.DriverProvider;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FailureLister implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(FailureLister.class);
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            File scrFile = ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
            String currentDate = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date(System.currentTimeMillis()));
            FileUtils.copyFile(scrFile, new File(String.format("screenshots/screenshot-Date %s Thread %s.png", currentDate, Thread.currentThread().getId())));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

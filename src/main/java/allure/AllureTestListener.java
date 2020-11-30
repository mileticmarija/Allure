package allure;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {
    public static WebDriver driver;

    @Attachment
    public byte[] saveScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(driver);
        saveTextLog(driver.getCurrentUrl());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST EXECUTION SUCCESSFUL");
    }
}

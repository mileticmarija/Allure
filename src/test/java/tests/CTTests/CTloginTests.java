package tests.CTTests;

import allure.AllureTestListener;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom_classes.CTcreateAccount.CTloginPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

@Listeners(allure.AllureTestListener.class)
public class CTloginTests {
    WebDriver driver;
    String URL="https://www.ctshop.rs/customer/account/login";
    DriverManager driverManager;
    CTloginPage ctlp;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser){
        driverManager= DriverManagerFactory.getDriverManager(browser);
        driver=driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AllureTestListener.driver=driver;
    }

    @Test(description = "Login")
    @Parameters({"email","password"})
    @Description("Should login with valid credentials")
    @Epic("EP001")
    @Feature("FE002")
    @Story("ST001")
    @Step("login")
    @Severity(SeverityLevel.BLOCKER)
    public void login(String email, String pass){
        ctlp=new CTloginPage(driver);
        ctlp.login(email,pass);
    }


    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}

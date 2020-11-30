package tests.CTTests;

import allure.AllureTestListener;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom_classes.CTcreateAccount.CTcreateAccPage;
import pom_classes.CTcreateAccount.CTloginPage;
import pom_classes.CTcreateAccount.CTaccPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;
@Listeners(allure.AllureTestListener.class)
public class CTcreateTest {
    WebDriver driver;
    String URL= "https://www.ctshop.rs/customer/account/create";
    DriverManager driverManager;
    CTcreateAccPage ctcp;
    CTaccPage ctrp;
    CTloginPage ctlp;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser){
        driverManager= DriverManagerFactory.getDriverManager(browser);
        driver= driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AllureTestListener.driver=driver;
    }

    @Parameters({"ime","prezime","password","cPass", "cMessage"})
    @Test (description = "Create account")
    @Description("Should create an account with valid parameters")
    @Epic("EP001")
    @Feature("FE001")
    @Story("ST001")
    @Step("Create account")
    @Severity(SeverityLevel.BLOCKER)
    public void createCTaccount(String ime,String prezime, String pass,String cPass, String cMessage){
        ctcp= new CTcreateAccPage(driver);
        ctrp=new CTaccPage(driver);
        Random r=new Random();
        int br=r.nextInt(1000);
        String mail="malac"+br+"@gmail.com";

        ctcp.createAcc(ime,prezime,mail,pass,cPass);
        ctrp.checkMessage(cMessage);
    }

    @Test(description = "Login")
    @Parameters({"email","password"})
    @Description("Should login with valid credentials")
    @Epic("EP001")
    @Feature("FE002")
    @Story("ST001")
    @Step("login")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUser(String email,String pass){
      ctlp=new CTloginPage(driver);
      ctcp= new CTcreateAccPage(driver);

      ctcp.navigateToLoginPage();
      ctlp.login(email, pass);
    }


    @Parameters({"ime","prezime","password","cPass", "cMessage"})
    @Test
    public void wrongCpass(String ime,String prezime, String pass,String cPass, String cMessage){
        ctcp= new CTcreateAccPage(driver);
        ctrp=new CTaccPage(driver);
        Random r=new Random();
        int br=r.nextInt(1000);
        String mail="malac"+br+"@gmail.com";

        ctcp.createAcc(ime,prezime,mail,pass,cPass);
        ctrp.checkAllertMessage(cMessage);

    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}

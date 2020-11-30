package pom_classes.CTcreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CTloginPage {
    WebDriver driver;
    public CTloginPage(WebDriver driver){
        this.driver=driver;
    }

    protected By email= By.cssSelector("#email");
    protected By password= By.cssSelector("#pass");
    protected By loginButton= By.cssSelector("#send2");
    protected By ad=By.cssSelector(".soundest-form-background-image-close");

    public void login(String emailTX, String passwordTX){

        try {
            driver.findElement(ad).click();
            System.out.println("AD Closed");
        }catch (Exception e){
            System.out.println("AD not found");
         }

        driver.findElement(email).sendKeys(emailTX);
        driver.findElement(password).sendKeys(passwordTX);
        driver.findElement(loginButton).click();
    }
}

package pom_classes.CTcreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CTaccPage {
    WebDriver driver;
    WebDriverWait wdWait;
    String result;
    public CTaccPage(WebDriver driver){
        this.driver=driver;
    }

    private By close=By.cssSelector(".soundest-form-background-image-wrapper a ");
    private By cMessageContainer= By.cssSelector(".alert.alert-success>p");
    private By allertMessageContainer=By.cssSelector(".alert.alert-warning");

      //public String getCmessageText(){
      //    wdWait=new WebDriverWait(driver,5000);
      //    wdWait.until(ExpectedConditions.presenceOfElementLocated(cMessageContainer));
      //    result=driver.findElement(cMessageContainer).getText();
      //    return result;
      //}

    public void checkMessage(String cMessage){
        //getCmessageText();
        Assert.assertEquals(driver.findElement(cMessageContainer).getText(),cMessage);
    }

    public void checkAllertMessage(String allertMessage){
        Assert.assertEquals(driver.findElement(allertMessageContainer).getText(),allertMessage);
    }

}

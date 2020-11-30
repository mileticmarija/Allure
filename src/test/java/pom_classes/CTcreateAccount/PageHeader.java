package pom_classes.CTcreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageHeader {
    WebDriver driver;
    public PageHeader(WebDriver driver){
        this.driver=driver;
    }

    protected By allProducts= By.cssSelector(".am-opener.sharkskin-collapse");
    protected By laptopoviTableti= By.cssSelector(".sharkskin-megamenu.megamenu-v.megamenu-am>li:nth-child(1)>a");
    protected By laptopovi= By.cssSelector(".level0.megamenu-dropdown.megamenu-mega3.pos-1>li:nth-child(3)>a:first-child");


    public void navigateToLaptopovi(){
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(allProducts)).moveToElement(driver.findElement(laptopoviTableti)).moveToElement(driver.findElement(laptopovi)).click().build().perform();


    }

 //protected By allProducts= By.cssSelector(".am-opener.sharkskin-collapse");

 //public void navigateToLaptopovi(String brojElementaIzMenija, String brojElementaIzPodMenija){
 //    Actions action=new Actions(driver);
 //    action.moveToElement(driver.findElement(allProducts)).moveToElement(driver.findElement(By.cssSelector(".sharkskin-megamenu.megamenu-v.megamenu-am>li:nth-child("+brojElementaIzMenija+")>a"))).moveToElement(driver.findElement(By.cssSelector(".level0.nav-3.parent.custom_mega.custom_mega_1.megamenu-num-of-col-2:nth-child(1)>ul>li:nth-child(3)>ul>li:nth-child("+brojElementaIzPodMenija+")>a"))).click().build().perform();


 //}
}

package selenium_core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected  abstract void creteWebDriver();
    public void quitDriver (){
        if (null != driver){
            driver.quit();
            driver=null;
        }
    }
    public  WebDriver getWebDriver(){
        if (null == driver){
            creteWebDriver();
        }
        return driver;
    }
}

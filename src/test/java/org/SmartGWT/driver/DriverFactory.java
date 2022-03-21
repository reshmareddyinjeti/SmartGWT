package org.SmartGWT.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;

    //creating constructor to implement page factory.
    public DriverFactory() {
        PageFactory.initElements(driver, this);
    }

    //creating method to access multiple browser by using switch loop
    public void openBrowser(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "microsoft edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
    }

    //creating method to enter the url
    public void setUrl(String url) {
        driver.get(url);
    }

    //creating method to maximize the browser
    public void maximize() {
        driver.manage().window().maximize();
    }

    //creating method to wait/load the page
    public void pageLoadTimeOut() {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    //creating method to wait for element
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    public void scriptTimeOut() {
       // driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
    }

    //creating method to delete any cookies
    public void deleteCookies() {
        driver.findElement(By.cssSelector(".iAgreeButton")).click();
    }

    //creating method to close the browser
    public void closeBrowser() {
        driver.quit();
    }


}

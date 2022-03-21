package org.SmartGWT.pageObject;

import org.SmartGWT.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeaturedDropDownGridCategoryPage extends DriverFactory {
   // private WebDriver driver;
    public static String DROPDOWN = "//table[@class='selectItemLiteControl']//div[@role='presentation']";


   // public FeaturedDropDownGridCategoryPage(WebDriver driver){
     //   this.driver = driver;
       // PageFactory.initElements(driver,this);
    //}

    public void selectRowAsPerCriteria(String expectedItem, String expectedUnits, double expectedUnitCost) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DROPDOWN)));
        driver.findElement(By.xpath(DROPDOWN)).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='pickListMenuBody']//tr[@role='option']"),7));
        int i = 1;
        while (true){
            String item = driver.findElement(By.xpath("//div[@class='pickListMenuBody']//tr[@role='option'][" + i + "]/td[1]/div")).getText().trim();
            String units = driver.findElement(By.xpath("//div[@class='pickListMenuBody']//tr[@role='option'][" + i + "]/td[2]/div")).getText().trim();
            double unitCost = Double.parseDouble(driver.findElement(By.xpath("//div[@class='pickListMenuBody']//tr[@role='option'][" + i + "]/td[3]/div")).getText().trim());
            if(item.contains(expectedItem) && units.contains(expectedUnits) && unitCost > expectedUnitCost ) {
                driver.findElement(By.xpath("//div[@class='pickListMenuBody']//tr[@role='option'][" + i + "]/td[1]/div")).click();
                break;
            }
            else {
                Actions action = new Actions(driver);
                action.moveToElement(driver.findElement(By.xpath("//div[@class='pickListMenuBody']//tr[@role='option'][" + i + "]/td[1]/div"))).sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            i++;
            if(i%11==0)
                i = 1;
        }
    }


}

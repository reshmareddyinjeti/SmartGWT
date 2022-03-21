package org.SmartGWT.pageObject;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.SmartGWT.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropDownGridPageObject extends DriverFactory {
   /* @FindBy (css="#isc_2F")
    private WebElement dorpdown;
    @FindBy(css=".pickListCell")
    private List<WebElement> listofItems;
    ////*[@id="isc_3Vtable"]/tbody/tr[7]
    public void DropDownFromCategorie(){
        driver.get("http://www.smartclient.com/smartgwt/showcase/#featured_dropdown_grid_category");
        //System.out.println(dorpdown.getText());
        dorpdown.click();
        System.out.println(listofItems.size());
        System.out.println(listofItems.contains("Exercise"));
    }
}*/
   //private WebDriver driver;

    @FindBy(name = "commonName")
    WebElement animalSearchInputBox;

  //  public FeaturedTileFilteringPage(WebDriver driver){
    //    this.driver = driver;
      //  PageFactory.initElements(driver,this);
   // }

    public void clickIAgree(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a.iAgreeButton"))));
            driver.findElement(By.cssSelector("a.iAgreeButton")).click();
        } catch (Exception e){
            System.out.println("Agree Button Not Present");
        }
    }

    public void setAnimal(String animalText){
        waitForSearchResults();
        animalSearchInputBox.sendKeys(animalText);
    }

    public void setMaxLifeSpan(int maxLifeSpan) throws Exception{
        waitForSearchResults();
        while(true) {
            WebElement sliderButton = driver.findElement(By.className("hSliderThumb"));
            Actions builder = new Actions(driver);
            builder.dragAndDropBy(sliderButton,-5,0).build().perform();
            driver.findElement(By.tagName("body")).click();
            WebElement element = driver.findElement(By.className("sliderValueText"));
            String value = element.getText();
            int currSize = Integer.parseInt(value);
            if(currSize == maxLifeSpan)
                break;
        }
    }

    public void sortBy(String sortCriteria) throws Exception{
        waitForSearchResults();
        WebElement element = driver.findElements(By.xpath("//table[@class='selectItemLiteControl']//div[@role='presentation']")).get(1);
        scrollElementIntoView(element);
        element.click();
        List<WebElement> sortByDropDownElements = driver.findElements(By.xpath("//tr[@role='option']//td//div[@role='presentation']"));
        for(WebElement dropDownElement : sortByDropDownElements){
            if(dropDownElement.getText().trim().equalsIgnoreCase(sortCriteria)){
                dropDownElement.click();
                break;
            }
        }
    }

    public void checkAscending(){
        waitForSearchResults();
        WebElement checkbox = driver.findElement(By.xpath("//span[@class='checkboxFalse']"));
        scrollElementIntoView(checkbox);
        checkbox.click();
    }

    public int getResultsCount(){
        waitForSearchResults();
        return driver.findElements(By.xpath("//div[@class='simpleTile']")).size();
    }

    public void waitForSearchResults() {
        try {
            Thread.sleep(2000);
        } catch (Exception e){
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='simpleTile']")));
    }

    private void scrollElementIntoView(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
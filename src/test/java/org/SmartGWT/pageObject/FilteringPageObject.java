package org.SmartGWT.pageObject;
import org.SmartGWT.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FilteringPageObject extends DriverFactory {
    @FindBy(css = "#isc_2P")
    private WebElement animalTextbox;
    @FindBy(css = "#isc_2M")
    private WebElement from;
    @FindBy(css = "#isc_2G")
    private WebElement to;
    //@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[1]/div[2]/div/div/div[4]/div[1]/div/div/div/div[1]/div/div/div/div[4]/div/form/table/tbody/tr[2]/td[2]/table/tbody/tr/td[1]/div")
    @FindBy(xpath = "//*[@id=\"isc_3H\"]/span")
    private WebElement sortOrder;
    // @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[1]/div[2]/div/div/div[4]/div[1]/div/div/div/div[1]/div/div/div/div[4]/div/form/table/tbody/tr[2]/td[2]/table/tbody/tr/td[1]/div")
    @FindBy(xpath = "//*[@id=\"isc_6Itable\"]/tbody/tr[2]/td/div")
    // @FindBy(css=".pickListCellSelected")////*[@id="isc_3E"]
    private WebElement sortListOrder;
    @FindBy(xpath = "//*[@id=\"isc_3F\"]")
    private List<WebElement> button;
    @FindBy(css = "#isc_3N")
    private WebElement ascending;


    public void Filtering() throws InterruptedException {
        driver.get("http://www.smartclient.com/smartgwt/showcase/#featured_tile_filtering");
        animalTextbox.sendKeys("a");
        Thread.sleep(3000);
        Actions builder = new Actions(driver);
        builder.dragAndDrop(from, to).click().build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", sortOrder);
        ascending.click();
        //  sortOrder.click();
        //System.out.println(button.size());
        // new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ascending)).click();
    }
    @FindBy (css=".simpleTile")
    private List<WebElement> listOf;
    public List<WebElement> getListOfItems(){
        System.out.println(listOf.size());
        return listOf;
    }


}


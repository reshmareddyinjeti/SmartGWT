package org.SmartGWT.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.SmartGWT.driver.DriverFactory;
import org.SmartGWT.pageObject.FilteringPageObject;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
public class FilteringPageStepDef extends DriverFactory {
    private FilteringPageObject filteringPageObject = new FilteringPageObject();

    @Given("^User is on FilterPage$")
    public void userIsOnFilterPage() {

    }
    @When("^User is able to do filters$")
    public void userIsAbleToDoFilters() throws InterruptedException {
        filteringPageObject.Filtering();
    }

    @Then("^Verify the results$")
    public void verifyTheResults() {
        List<WebElement> countOfList = filteringPageObject.getListOfItems();
        int count = countOfList.size();
        Assert.assertTrue(count >= 20);
        System.out.println("Count is greater than or equal to 1. Count is: " + count);
    }

}

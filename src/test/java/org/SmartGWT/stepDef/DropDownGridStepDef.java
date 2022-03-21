package org.SmartGWT.stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.SmartGWT.driver.DriverFactory;
import org.SmartGWT.pageObject.DropDownGridPageObject;

public class DropDownGridStepDef extends DriverFactory {
    private DropDownGridPageObject dropDownGridPageObject=new DropDownGridPageObject();
    @Given("^User is on dropdown_grid_category page$")
    public void userIsOnDropdown_grid_categoryPage() {
        dropDownGridPageObject.DropDownFromCategorie();
    }

    @When("^User is able to do select From category$")
    public void userIsAbleToDoSelectFromCategory() {
    }

    @Then("^Verify the expected results$")
    public void verifyTheExpectedResults() {
    }
}

package org.SmartGWT;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Description;
import org.SmartGWT.driver.DriverFactory;

public class Hooks {
    //creating object for driverFactory
    private DriverFactory driverFactory = new DriverFactory();
    @Before
    @Description("Before TestMethod")
    //to set up the browser
    public void setUp() {
        //open browser
        driverFactory.openBrowser("chrome");
        //enter url
        driverFactory.setUrl("http://www.smartclient.com/smartgwt/showcase");
        //maximize browser
        driverFactory.maximize();
        //deleting cookies
        driverFactory.deleteCookies();
        //pageload timeout
        driverFactory.pageLoadTimeOut();
        //to wait for the each locator
        driverFactory.implicitWait();
    }

    @After
    @Description("After Test Method")
    //To close the browser
    public void tearDown() {
        //closing the browser
     //   driverFactory.closeBrowser();
    }
}



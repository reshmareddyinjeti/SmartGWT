package org.SmartGWT;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//cucumber options
@CucumberOptions(features = "src/test/resources", dryRun = false, strict = true, tags = "@SmokeTest",
        plugin = {"json:target/cucumber.json-report", "pretty"
                , "html:target/cucumber.html-report"
                , "junit:target/cucumber.xml-report",
                "pretty:target/cucumber.txt-report"})
public class RunnerClass {}

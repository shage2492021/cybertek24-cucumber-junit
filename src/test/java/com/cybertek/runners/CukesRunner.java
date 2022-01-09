package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",       // generates report to provided path
                "rerun:target/rerun.txt",                 // stores failed scenario names into rerun.txt file
                "json:target/cucumber.json"               // generate json execution report to be used for html report
        },
        features = "src/test/resources/features",
        glue = "com/cybertek/step_defs",
        dryRun = false//,
        //tags = "@rerun"
)

public class CukesRunner {

}

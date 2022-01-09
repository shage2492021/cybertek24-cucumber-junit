package com.cybertek.step_defs;


import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static io.cucumber.gherkin.Parser.RuleType.Scenario;

/**
 * similar to TestBase.java in TestNG framework
 * we open/close browser here, etc
 * classes do not need to extend this Class for it to run
 *
 */
public class Hooks {

    @Before      //from io.cucumber.java
    public void setUpScenario(Scenario scenario){
        System.out.println("BEFORE- setUpScenario method is running before scenario: " + scenario.getName());

    }


    @After
    public void tearDownScenario(Scenario scenario) {
        /**
         * - Scenario scenario represents current running cucumber scenario
         * - cast webdriver to TakesScreenshot interface. (TakeScreenshot)Driver.getDriver()
         * - call getScreenShotAs method and output type as OutputType.BYTES
         * - save the result into byte[] array: byte[] image
         * - attach the image into the scenario html report: scenario.attach(image, "image/png", scenario.getName());
         * - if scenario fails for any reason, it will automatically take a screenshot and attach it to the html report
         */
        if (scenario.isFailed()){
            byte[] image=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }

        System.out.println("AFTER - tearDown method is running after scenario: " + scenario.getName());
        Driver.closeDriver();
    }

    /**
     * @AfterStep - runs after each scenario step
     * - takes screenshot and attaches to the report for each step
     * - normally not needed, but who knows. you may need this at some point
     */

    /*
    @AfterStep
    public void screenshotAfterEachStep(Scenario scenario) {
        byte[] image=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", scenario.getName());

    }

     */




}

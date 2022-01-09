package com.cybertek.step_defs;

import com.cybertek.pages.percentage_calculator.PercentageCalculatorHomePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

import static org.junit.Assert.*;


public class PercentageCalculatorStepDefs {
    @Given("User is on percentage calculator page")
    public void user_is_on_percentage_calculator_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("percentageCalculator.url"));
        String expectedTitle = "Percentage Calculator";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals(expectedTitle,actualTitle);

    }
    @Then("User should see following calculations:")
    public void user_should_see_following_calculations(Map<Integer, Integer> valuesMap) {
        PercentageCalculatorHomePage percentPage = new PercentageCalculatorHomePage();

        System.out.println(valuesMap);
        percentPage.percentInput.sendKeys("5");


        // loop through keys in map
        for(Integer input : valuesMap.keySet()){
            percentPage.wholeNumberInput.clear();
            percentPage.wholeNumberInput.sendKeys("" + input);
            percentPage.calculateButton.click();
            BrowserUtils.sleep(2);

            Integer inputValue = input;
            Integer expectedValue = valuesMap.get(input);
            Integer actualValue = Integer.valueOf(percentPage.result.getAttribute("value"));

            System.out.println("inputValue = " + inputValue);
            System.out.println("expectedValue = " + expectedValue);
            System.out.println("actualValue = " + actualValue);
            System.out.println("====================");

            assertEquals(expectedValue, actualValue);
        }


    }
}

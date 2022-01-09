package com.cybertek.step_defs;

import com.cybertek.pages.calculator.CalculatorPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class CalculatorStepDefs {

    CalculatorPage calcPage = new CalculatorPage();


    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {
        System.out.println("User is on calculator page");
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));
    }

    @Given("User clicks on {string} on calculator")
    public void user_clicks_on_on_calculator(String buttonText) {
        calcPage.clickOn(buttonText);
        System.out.println("User clicks on: " + buttonText);

    }

    @Then("expectedResult {string} should be displayed")
    public void result_should_be_displayed(String expectedResult) {
        String actualResult = calcPage.result.getText().trim();
        System.out.println("actualResult = " + actualResult);
        assertEquals(expectedResult, actualResult);
    }


}

package com.cybertek.step_defs;

import com.cybertek.pages.dice.DiceHomepage;
import com.cybertek.pages.dice.DiceResultsPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class DiceJobSearchStepDefinitions {
    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));
    }
    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {
        DiceHomepage homepage = new DiceHomepage();
        homepage.searchBox.sendKeys("java");
        homepage.locationBox.sendKeys("80537" + Keys.ENTER);
    }
    @Then("User should see search results")
    public void user_should_see_search_results() {
        DiceResultsPage results = new DiceResultsPage();
        System.out.println(results.results.getText());

    }

}

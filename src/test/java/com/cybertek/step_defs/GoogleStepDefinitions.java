package com.cybertek.step_defs;

import com.cybertek.pages.google.GoogleResultsPage;
import com.cybertek.pages.google.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @When("User searches for apple")
    public void user_searches_for_apple() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }
    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "apple";
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    @Then("User should be able to search for following:")
    public void userShouldBeAbleToSearchForFollowing(List<String> items) {
        //loop and search for each item
        GoogleSearchPage searchPage = new GoogleSearchPage();

        for (String each: items){
            searchPage.searchBox.clear();
            searchPage.searchBox.sendKeys(each + Keys.ENTER);
        }
    }

    @When("User searches for {string} capital")
    public void userSearchesForCapital(String country) {
        googleSearchPage.searchBox.sendKeys("what is capital city of " + country + Keys.ENTER);
    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String expectedCapital) {
        System.out.println("Expected Capital City name: " + expectedCapital);
        String actualCapital = new GoogleResultsPage().getResult();
        assertEquals(actualCapital, expectedCapital);
    }
}

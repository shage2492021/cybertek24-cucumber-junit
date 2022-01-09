package com.cybertek.step_defs;

import com.cybertek.pages.etsy.EtsyHomePage;
import com.cybertek.pages.etsy.EtsySearchResultsPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EtsySearchStepDefinitions {

    WebDriver driver;

    @Given("User is on Etsy homepage")
    public void User_is_on_etsy_homepage() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("esty.url"));
    }
    @Then("page title should be as expected")
    public void page_title_should_be_as_expected() {
        // junit assertEquals param order -> expected, actual
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }
    @When("User searches for wooden spoon page")
    public void User_searches_for_wooden_spoon_page() {
        EtsyHomePage homepage = new EtsyHomePage();
        homepage.search("wooden spoon");
    }
    @Then("page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
        EtsySearchResultsPage sr = new EtsySearchResultsPage(driver);
        Assert.assertTrue(sr.findTitle().contains("Wooden spoon"));
    }

    @When("User searches for empty value")
    public void userSearchesForEmptyValue() {
        EtsyHomePage homepage = new EtsyHomePage();
        homepage.search("");
    }

    @Then("all search categories should be displayed")
    public void allSearchCategoriesShouldBeDisplayed() {
        EtsySearchResultsPage sr = new EtsySearchResultsPage(driver);
        Assert.assertTrue(sr.categories.isDisplayed());
    }
}

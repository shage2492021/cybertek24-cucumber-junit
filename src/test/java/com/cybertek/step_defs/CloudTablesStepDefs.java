package com.cybertek.step_defs;

import com.cybertek.pages.cloud_table.CloudTableHome;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;

public class CloudTablesStepDefs {

    CloudTableHome cloud = new CloudTableHome();

    @Given("User is on cloudtables homepage")
    public void user_is_on_cloudtables_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cloudtables.url"));
    }

    @When("User clicks on New button")
    public void user_clicks_on_new_button() {
        cloud.newButton.click();
    }

    @When("User enters {string} to first name field")
    public void user_enters_to_first_name_field(String firstName) {
        cloud.firstNameBox.sendKeys(firstName);
    }

    @When("User enters {string} to last name field")
    public void user_enters_to_last_name_field(String lastName) {
        cloud.lastNameBox.sendKeys(lastName);
    }

    @When("User enters {string} to position field")
    public void user_enters_to_position_field(String position) {
        cloud.positionBox.sendKeys(position);
    }

    @When("User enters {string} to salary field")
    public void user_enters_to_salary_field(String salary) {
        cloud.salaryBox.sendKeys(salary);
    }

    @When("User clicks on create button")
    public void user_clicks_on_create_button() {
        cloud.createButton.click();
    }
}

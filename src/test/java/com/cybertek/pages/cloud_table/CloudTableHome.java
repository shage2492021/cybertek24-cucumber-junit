package com.cybertek.pages.cloud_table;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudTableHome {

    public CloudTableHome(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='New']")
    public WebElement newButton;

    @FindBy(id = "DTE_Field_first_name")
    public WebElement firstNameBox;

    @FindBy(id = "DTE_Field_last_name")
    public WebElement lastNameBox;

    @FindBy(id = "DTE_Field_position")
    public WebElement positionBox;

    @FindBy(id = "DTE_Field_salary")
    public WebElement salaryBox;

    @FindBy(xpath = "//button[.='Create']")
    public WebElement createButton;


}

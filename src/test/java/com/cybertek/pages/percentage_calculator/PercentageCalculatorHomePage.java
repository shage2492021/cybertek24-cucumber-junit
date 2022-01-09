package com.cybertek.pages.percentage_calculator;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PercentageCalculatorHomePage {

    public PercentageCalculatorHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@size='3']")
    public WebElement percentInput;

    @FindBy(xpath = "//input[@size='7']")
    public WebElement wholeNumberInput;

    @FindBy(xpath = "//input[@value='Calculate'][1]")
    public WebElement calculateButton;

    @FindBy(xpath = "//input[@readonly='readonly'][1]")
    public WebElement result;
}

package com.cybertek.pages.dice;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiceResultsPage {
    public DiceResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (id = "totalJobCount")
    public WebElement results;
}

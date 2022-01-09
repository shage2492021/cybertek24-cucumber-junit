package com.cybertek.pages.dice;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiceHomepage {
    public DiceHomepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "typeaheadInput")
    public WebElement searchBox;

    @FindBy(id = "google-location-search")
    public WebElement locationBox;

}

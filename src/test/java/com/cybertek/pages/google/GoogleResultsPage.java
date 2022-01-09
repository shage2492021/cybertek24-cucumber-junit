package com.cybertek.pages.google;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultsPage {

    public GoogleResultsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='kp-header']//a[@class='FLP8od']")
    public WebElement result;

    public String getResult(){
        return result.getText();
    }

}

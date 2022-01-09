package com.cybertek.pages.etsy;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyHomePage {

    public EtsyHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@data-id='gnav-search-submit-button']")
    public WebElement searchButton;

    @FindBy (id = "global-enhancements-search-query")
    public WebElement searchBox;

    public void search(String item){
        searchBox.clear();
        searchBox.sendKeys(item);
        searchButton.click();

    }
}

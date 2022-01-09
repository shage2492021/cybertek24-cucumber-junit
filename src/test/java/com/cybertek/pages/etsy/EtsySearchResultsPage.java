package com.cybertek.pages.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearchResultsPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[.='All categories']")
    public WebElement categories;

    public EtsySearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String findTitle(){
        return driver.getTitle();
    }
}

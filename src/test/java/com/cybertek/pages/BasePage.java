package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * Parent class for concrete Page object classes
 * Its constructor initializes elements
 * Abstract to prevent instantiation
 */
public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
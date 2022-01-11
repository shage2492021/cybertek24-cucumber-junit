package com.cybertek.pages.vyTrack;

import com.cybertek.pages.BasePage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VyTrackLoginPage extends BasePage {

    // can also skip @FindBy since "name" in html matches variable names
    // however, was much slower doing it this way

    @FindBy(name = "_username")
    public WebElement _username;

    @FindBy(name = "_password")
    public WebElement _password;

    @FindBy(tagName = "button")
    public WebElement logInBtn;

    public void login(String userName, String password){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(_username));
        _username.sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(_password));
        _password.sendKeys((password));
        logInBtn.click();
    }
}

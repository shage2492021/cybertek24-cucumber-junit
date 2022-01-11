package com.cybertek.pages.vyTrack;

import com.cybertek.pages.BasePage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage {

    @FindBy (xpath = "//li[@id='user-menu']/a")
    public WebElement username;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(xpath = "//i[@class='fa-caret-down']")
    public WebElement triangle;


    public void logout() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(triangle));
        triangle.click();

        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();

    }
}

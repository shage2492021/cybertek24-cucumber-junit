package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BrowserUtils {
    /**
     * this method is used to pause the code for given seconds
     * It is static method so we can call:
     * BrowserUtils.sleep(seconds);
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Overloaded scroll methods, either by pixels or Webelement
     * @param elem
     */
    public static void scroll(WebElement elem){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", elem);
    }

    public static void scroll(int pixels){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollBy(0," + pixels + ")");
    }

}

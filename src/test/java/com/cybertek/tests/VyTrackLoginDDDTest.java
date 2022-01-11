package com.cybertek.tests;

import com.cybertek.pages.vyTrack.DashboardPage;
import com.cybertek.pages.vyTrack.VyTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class VyTrackLoginDDDTest {

    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    DashboardPage dp = new DashboardPage();
    String userName = "";
    String password = "";
    String firstName = "";
    String lastName = "";


    @Before
    public void setUp(){
        //set up browser etc
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown(){
        //close browser
        //Driver.getDriver().close();
    }

    /**
     * TODO: build this out
     */
    @Test
    public void loginDDTTest() throws IOException {
        //open excel file
        //add page object
        //loop and read credentials
        //write the result in excel file

        String filePath = "VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet dataSheet = workbook.getSheetAt(0);

        for (int i = 1; i < dataSheet.getLastRowNum(); i++) {
            userName = dataSheet.getRow(i).getCell(0).toString();
            password = dataSheet.getRow(i).getCell(1).toString();
            firstName = dataSheet.getRow(i).getCell(2).toString();
            lastName = dataSheet.getRow(i).getCell(3).toString();
            System.out.println("userName = " + userName);
            System.out.println("password = " + password);
            System.out.println("firstName = " + firstName);
            System.out.println("lastName = " + lastName);

            loginPage.login(userName, password);


            // verify we are taken to dashboard
            String actualFullName = dp.username.getText();
            //assertTrue(dp.username.getText().contains(expectedUsername));
            System.out.println("actualFullName = " + actualFullName);

            // create object of XSSFCell to dynamically point to cell in Excel sheet as we loop through
            // will store test results there
            XSSFCell resultCell = dataSheet.getRow(i).getCell(4);

            if (actualFullName.contains(firstName) && actualFullName.contains(lastName)) {
                System.out.println("PASS");
                resultCell.setCellValue("PASS");

            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");

            }

            dp.logout();
        }
        //save changes in the excel file
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();







    }

}

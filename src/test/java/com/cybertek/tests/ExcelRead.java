package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelRead {

    @Test
    public void readingFromExcel() throws IOException {

        // open excel workbook class
        // pass filename in the constructor
        // handle the exception by adding throws IOException to method signature
        XSSFWorkbook workbook = new XSSFWorkbook("Employees.xlsx");     // basically double-clicking file to open in Excel

        // Go to worksheet
        XSSFSheet worksheet = workbook.getSheet("data");

        // print data in cell
        System.out.println(worksheet.getRow(1).getCell(0));
        System.out.println(worksheet.getRow(4).getCell(2));
    }
}

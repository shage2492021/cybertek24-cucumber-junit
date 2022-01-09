package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {

    String filePath = "Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
        //open the Emplyees.xlsx using Apache POI
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);

        //go to "data" sheet, or go to first data sheet by index
        //XSSFSheet worksheet = workbook.getSheet("data");
        XSSFSheet dataSheet = workbook.getSheetAt(0);


        System.out.println("-----------------------");
        //loop and print
        for(int i=0; i <= 2; i++){
            System.out.println(dataSheet.getRow(0).getCell(i));
        }

        //print column names. row is 0. cells 0,1,2
        System.out.print("COLUMN NAMES: ");
        System.out.println(dataSheet.getRow(0).getCell(0));
        
        //find out number of rows in the worksheet
        int rowsCount = dataSheet.getPhysicalNumberOfRows();
        System.out.println("rowsCount = " + rowsCount);

        //starts counting at 0, doesn't ignore empty lines
        int usedRowsCount = dataSheet.getLastRowNum();
        System.out.println("usedRowsCount = " + usedRowsCount);

        //print all first names using loop
        for (int i = 0; i <= usedRowsCount; i++){
            System.out.println("First name[" + i + "]: " + dataSheet.getRow(i).getCell(0));
        }

        //loop and find "Fahima" in first name column
        //then, print her last name and jobID
        //exit loop

        for (int i = 0; i <= usedRowsCount; i++){
            if(dataSheet.getRow(i).getCell(0).toString().equals("Fahima")){
                System.out.println("Line " + i + ": ");
                for (int j=0; j <= 2; j++ ){
                    System.out.print(dataSheet.getRow(i).getCell(j) + "|");
                }
                break;
            }
        }


    }
}

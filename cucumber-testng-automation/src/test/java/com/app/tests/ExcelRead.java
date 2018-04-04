package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	public static void main(String[] args) throws Exception {
		String filePath = "/Users/cybertekschool/Desktop/Employees.xlsx";
		//Open file and convert to a stream of data
		FileInputStream inStream = new FileInputStream(filePath);
		//take the stream of data and use it as WorkBook
		Workbook workbook = WorkbookFactory.create(inStream);
		//Get the first worksheet from the workbook
		Sheet worksheet = workbook.getSheetAt(0);
		//goto first row
		Row row = worksheet.getRow(0);
		//goto first cell
		Cell cell = row.getCell(0);
		
		System.out.println(cell.toString());
		
		//Find out how many rows in Excel sheet
		int rowsCount = worksheet.getPhysicalNumberOfRows();
				//worksheet.getLastRowNum();
		
		System.out.println("Number of rows: " + rowsCount);
		//print all firstnames using a loop
		
		for(int rowNum = 1;rowNum < rowsCount;rowNum++) {
			row = worksheet.getRow(rowNum);
			cell = row.getCell(0);
			System.out.println(rowNum + " - " + cell.toString());
			//System.out.println(rowNum + " - " + worksheet.getRow(rowNum).getCell(0));
		}
		
		//Print the Job id of Nancy
		Cell NancyJob= worksheet.getRow(5).getCell(2);
		System.out.println(NancyJob);
		
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			Row myrow = worksheet.getRow(i);
			if(myrow.getCell(0).toString().equals("Nancy")) {
				//print job id from same row
				System.out.println("Nancy works as " + myrow.getCell(2).toString());
				break;
			}
		}
		
		workbook.close();
		inStream.close();
		
		
	}
}













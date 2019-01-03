/*package com.practice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelUtils {

	public int getRowCount(String bookName, String sheetName){
		try{
			System.out.println("bookName="+bookName);
			FileInputStream fis = new FileInputStream(new File(bookName));
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet(sheetName);
			return sheet.getLastRowNum()+1;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return -1;
	}
	
	private XSSFRow row;
	private String[][] datas;

	public int getRowCount(String bookName, String sheetName){
		try{
			FileInputStream fis = new FileInputStream(new File(bookName));
			return new XSSFWorkbook(fis).getSheet(sheetName).getLastRowNum()+1;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getColCount(String bookName, String sheetName){
		try{
			FileInputStream fis = new FileInputStream(new File(bookName));
			return new XSSFWorkbook(fis).getSheet(sheetName).getRow(1).getPhysicalNumberOfCells();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public String[][] getSheetData(String bookName, String sheetName){
		datas = null;
		try{
			FileInputStream fis = new FileInputStream(new File(bookName));
			Workbook book = WorkbookFactory.create(fis);
			Sheet sheet = book.getSheet(sheetName);
			int rowCount = this.getRowCount(bookName, sheetName);
			int colCount = this.getRowCount(bookName, sheetName);
			for(int i=0; i<rowCount; i++) {
				row = null;
				for(int j=0; j<colCount; j++) {
					datas[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datas;
	}
}
*/
package com.naveenautomationlabs.automationFramework.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream fi; // name of file
	public static XSSFWorkbook wb; // from file get the workbook
	public static XSSFSheet ws; // from workbook get the sheet
	public static XSSFRow row; // from sheet get the row
	public static XSSFCell cell; // get the cell

	public static int getRowCount(String file, String sheet) throws IOException {
		int rowCount = 0;

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		rowCount = ws.getLastRowNum();

		fi.close();
		wb.close();
		return rowCount;

	}

	public static int getCellCount(String file, String sheet, int rowCnt) throws IOException {

		int cellCount = 0;

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCnt);
		cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;

	}

	public static String getCelldata(String file, String sheet, int rowCnt, int cellCnt) throws IOException {
		String data;
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCnt);
		cell = row.getCell(cellCnt);
		data = cell.getStringCellValue();
		wb.close();
		fi.close();
		return data;
	}

}

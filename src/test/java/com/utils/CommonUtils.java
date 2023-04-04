package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mainPages.LoginPage;

public class CommonUtils {
	public static WebDriver driver;
	public static String pwd_value, user_name, product_name, detailed_product_name;

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void readExcelData() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\akumar94\\Documents\\TestingData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		int k = 0;
		int column = 0;
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Login Details")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstCell = rows.next();
				Iterator<Cell> cells = firstCell.cellIterator();
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equals("Email")) {
						column = k;
					}
					k++;

					
					break;
				}
				while (rows.hasNext()) {
					Row r = rows.next();
					user_name = r.getCell(column).getStringCellValue();
					pwd_value = r.getCell(1).getStringCellValue();
					
					
				}

			}
		}
		workbook.close();
	}

}

package com.PEP.InputOutcomes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.PEP.InputOutcomes.Controllers.ExcelReader;

public class InputOutcomesApplication {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Workbook workbook = new XSSFWorkbook(new FileInputStream("outcomes.xlsx"));
		ExcelReader toRun = new ExcelReader();
		toRun.Read(workbook);
	}

}
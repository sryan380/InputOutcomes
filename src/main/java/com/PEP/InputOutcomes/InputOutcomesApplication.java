package com.PEP.InputOutcomes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PEP.InputOutcomes.models.Client;

@SpringBootApplication
public class InputOutcomesApplication {
	static XSSFRow row;
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		SpringApplication.run(InputOutcomesApplication.class, args);
		Workbook workbook = new XSSFWorkbook(new FileInputStream("outcomes.xlsx"));
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Client toInput = new Client();
		
		while(rowIterator.hasNext()){
			row = (XSSFRow) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			if(row.getRowNum()==0) {
				continue;
			}
			if(row.getRowNum()> 1) {
				continue;
			}
			toInput.setLast_name(row.getCell(0));
			toInput.setFirst_name(row.getCell(1));
			toInput.setBirthdate(row.getCell(2));
			System.out.println(toInput.getLast_name());
			System.out.println(toInput.getFirst_name());
			System.out.println(toInput.getBirthdate());
//			while(cellIterator.hasNext()) {
//				Cell cell = cellIterator.next();
//				
//				switch(cell.getCellType()) {
//				case NUMERIC:
//					if(DateUtil.isCellDateFormatted(cell)) {
//						SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//						System.out.println(dateFormat.format(cell.getDateCellValue()) + "\t\t");
//					} else {
//						System.out.println(cell.getNumericCellValue() + " \t\t ");
//					}
//					break;
//				case STRING:
//					System.out.println(cell.getStringCellValue() + " \t\t ");
//					break;
//				}
//			}
		}
	}

}
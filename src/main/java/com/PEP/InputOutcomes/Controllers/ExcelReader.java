package com.PEP.InputOutcomes.Controllers;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.PEP.InputOutcomes.models.Client;

public class ExcelReader {
	
	public void Read(Workbook toRead) {
		XSSFRow row;
		
		Sheet sheet = toRead.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Client toInput = new Client();
		
//		SeleniumController selenium = new SeleniumController();
//		selenium.InputWebstie(toInput);
		
		while(rowIterator.hasNext()){
			row = (XSSFRow) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			if(row.getRowNum() == 0) {
				continue;
			}
			if(row.getRowNum() > 1) {
				continue;
			}
			toInput.setLast_name(row.getCell(0));
			toInput.setFirst_name(row.getCell(1));
			toInput.setBirthdate(row.getCell(2));
			toInput.setGender(row.getCell(3));
			toInput.setRace(row.getCell(4));
			toInput.setEthnicity(row.getCell(5));
			toInput.setAct_team(row.getCell(6));
			toInput.setAsoyn(row.getCell(7));
			toInput.setAso_id(row.getCell(8));
			toInput.setServ_year(row.getCell(9));
			toInput.setServ_month(row.getCell(10));
			toInput.setAge(row.getCell(11));
			toInput.setCounty(row.getCell(12));
			toInput.setZipcode(row.getCell(13));
			toInput.setEnrollment_date(row.getCell(14));
			toInput.setDischarge_date(row.getCell(15));
			toInput.setDischarge_reason(row.getCell(16));
			toInput.setOther_discharge_reason(row.getCell(17));
			toInput.setMoved(row.getCell(18));
			toInput.setHomeless(row.getCell(19));
			toInput.setHousing_type(row.getCell(20));
			toInput.setOther_housing_type(row.getCell(21));
			toInput.setPsych_er(row.getCell(22));
			toInput.setPsych_hospitalization(row.getCell(23));
			toInput.setSomatic_er(row.getCell(24));
			toInput.setSomatic_hospitalization(row.getCell(25));
			toInput.setPhysical_exam_date(row.getCell(26));
			toInput.setReason_for_no_exam(row.getCell(27));
			toInput.setArrested(row.getCell(28));
			toInput.setIncarcerated(row.getCell(29));
			toInput.setEducation_participation(row.getCell(30));
			toInput.setIce_any_time(row.getCell(31));
			toInput.setIce_last_day(row.getCell(32));
			toInput.setWeeks_in_ice(row.getCell(33));
			toInput.setHours_week_in_ice(row.getCell(34));
			toInput.setReferrals_to_the_dors(row.getCell(35));
			toInput.setEligibility_determination_with_the_dors(row.getCell(36));
			toInput.setIpe_with_the_dors(row.getCell(37));
			toInput.setDors_case_closure(row.getCell(38));
			toInput.setState_hospital_referral(row.getCell(39));
			toInput.setJail_prison_referral(row.getCell(40));
			toInput.setSubstance_abuse_issue(row.getCell(41));
			toInput.setReceiving_substance_abuse_services(row.getCell(42));
			toInput.setVisits(row.getCell(43));
			toInput.setDuration_of_visits(row.getCell(44));
			toInput.setSa_emergency_room_visits(row.getCell(45));
			toInput.setSa_hospitalizations(row.getCell(46));
			toInput.setConnected_to_pcp(row.getCell(47));
			toInput.setWrap_plan(row.getCell(48));
			toInput.setRecovery_focus_activities(row.getCell(49));
			toInput.setEmployment_type(row.getCell(50));
			toInput.setEmployment_hours(row.getCell(51));
			toInput.setStatus(row.getCell(52));
			
//			System.out.println(toInput.getEnrollment_date().toString());
			
			SeleniumController selenium = new SeleniumController();
			selenium.InputWebstie(toInput);
			
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
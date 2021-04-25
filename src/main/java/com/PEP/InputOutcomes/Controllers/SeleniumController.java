package com.PEP.InputOutcomes.Controllers;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.PEP.InputOutcomes.models.Client;

public class SeleniumController {

	public void InputWebstie(Client toInput) {
		//id paths for selecting
		String loginByIdPath = "MainContent_LoginUser_LoginButton";
		String UsernameIdPath = "MainContent_LoginUser_UserName";
		String PasswordIdPath = "MainContent_LoginUser_Password";
		String YearIdPath = "MainContent_ddlServYear";
		
		//id paths to complete input for
		String monthIdPath = "MainContent_ddlServMonth";
		String Aso_idIdPath = "MainContent_tbAsoId";
		String lastnameIdPath = "MainContent_tbLastName";
		String firstNameIdPath = "MainContent_tbFirstName";
		String BirthDateIdPath = "MainContent_tbBirthDate";
		String GenderIdRadioButtonFemale = "MainContent_rblGender_0";
		String GenderIdRadioButtonMale = "MainContent_rblGender_1";
		String EthnicityIdPath = "MainContent_ddlEthnicity";//Drop Down
		String raceIdPath = "MainContent_ddlrace";//Drop Down
		String countyIdPath = "MainContent_ddlCounty";//Drop Down
		String zipcodeIdPath = "MainContent_tbZipCode5";
		String enrollmentDateIdPath = "MainContent_tbEnrollDate";
		String dischargeDateIdPath = "MainContent_tbDischargeDate";
		String dischargeReasonIdPath = "MainContent_ddlDischargeReason";//Drop Down
		String movedIdPath = "MainContent_ddlMoved";
		String homelessIdPath = "MainContent_ddlHomeless";
		String housingTypeIdPath = "MainContent_ddlHousingType";
		String housingTypeOtherIdPath = "MainContent_tbOtherHousingType";
		String psychERIdPath = "MainContent_tbPsychER";
		String psychHospitalizationIdPath = "MainContent_tbPsychHosp";
		String somaticHospitalizationIdPath = "MainContent_tbSomaticER";
		
		toInput.getSomatic_hospitalization();
		//info to input
		String username = "sryan380@gmail.com";
		String password = "409Coco352";
		String year = "2018";
		
		System.setProperty("webdriver.chrome.driver", "..\\..\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://psychmha.umaryland.edu/ActDataSystem/account/login.aspx");
		driver.findElement(By.id(UsernameIdPath)).sendKeys(username);
		driver.findElement(By.id(PasswordIdPath)).sendKeys(password);
//		String returnedValue = driver.findElement(By.id(UsernameIdPath)).getAttribute("value");
		driver.findElement(By.id(loginByIdPath)).click();
		
		Select drpYear = new Select(driver.findElement(By.id(YearIdPath)));
		drpYear.selectByVisibleText(year);
		WebElement drpYearSelect = drpYear.getFirstSelectedOption();
		System.out.println(drpYearSelect.getText());
		
		WebElement RadioFemale = driver.findElement(By.id(GenderIdRadioButtonFemale));
		WebElement RadioMale = driver.findElement(By.id(GenderIdRadioButtonMale));
		
		RadioMale.click();
		if(RadioFemale.isSelected()) {
			System.out.println("female is selected");
		} else {
			System.out.println("female is not selected");
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String enrollmentDateFormatted = dateFormat.format(toInput.getEnrollment_date().getDateCellValue());
		
//		((JavascriptExecutor)driver).executeScript ("document.getElementById('MainContent_tbEnrollDate').removeAttribute('readonly',0);");
//
//		WebElement BirthDateTest = driver.findElement(By.id(enrollmentDate));
//		BirthDateTest.clear();
//		BirthDateTest.sendKeys(enrollmentDateFormatted); //Enter this date details with valid date format
		
		driver.findElement(By.id(enrollmentDateIdPath)).sendKeys(enrollmentDateFormatted);
		driver.findElement(By.id(dischargeDateIdPath)).click();;
		String returnedValue = driver.findElement(By.id(enrollmentDateIdPath)).getAttribute("value");
		System.out.println(returnedValue);
	}
	
}
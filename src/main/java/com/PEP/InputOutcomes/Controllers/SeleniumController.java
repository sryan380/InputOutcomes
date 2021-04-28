package com.PEP.InputOutcomes.Controllers;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PEP.InputOutcomes.models.Client;

public class SeleniumController {

	public void InputWebstie(Client toInput) {
		// id paths for selecting
		String loginByIdPath = "MainContent_LoginUser_LoginButton";
		String usernameIdPath = "MainContent_LoginUser_UserName";
		String passwordIdPath = "MainContent_LoginUser_Password";
		String yearIdPath = "MainContent_ddlServYear";

		// id paths to complete input for
		String monthIdPath = "MainContent_ddlServMonth";
		String aso_idIdPath = "MainContent_tbAsoId";
		String lastnameIdPath = "MainContent_tbLastName";
		String firstNameIdPath = "MainContent_tbFirstName";
		String birthDateIdPath = "MainContent_tbBirthDate";
		String genderIdRadioButtonFemale = "MainContent_rblGender_0";
		String genderIdRadioButtonMale = "MainContent_rblGender_1";
		String ethnicityIdPath = "MainContent_ddlEthnicity";// Drop Down
		String raceIdPath = "MainContent_ddlrace";// Drop Down
		String countyIdPath = "MainContent_ddlCounty";// Drop Down
		String zipcodeIdPath = "MainContent_tbZipCode5";
		String enrollmentDateIdPath = "MainContent_tbEnrollDate";
		String dischargeDateIdPath = "MainContent_tbDischargeDate";
		String dischargeReasonIdPath = "MainContent_ddlDischargeReason";// Drop Down
		String movedIdPath = "MainContent_ddlMoved";
		String homelessIdPath = "MainContent_ddlHomeless";
		String housingTypeIdPath = "MainContent_ddlHousingType";
		String housingTypeOtherIdPath = "MainContent_tbOtherHousingType";
		String psychERIdPath = "MainContent_tbPsychER";
		String psychHospitalizationIdPath = "MainContent_tbPsychHosp";
		String somaticHospitalizationIdPath = "MainContent_tbSomaticER";

		// info to input
		String username = "sryan380@gmail.com";
		String password = "409Coco352";
		String year = "2021";
		String month = "February";
		String month2 ="March";
		
		//WebDriver Setup
		System.setProperty("webdriver.chrome.driver", "..\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		driver.get("https://psychmha.umaryland.edu/ActDataSystem/account/login.aspx");
		
		//login inputs
		driver.findElement(By.id(usernameIdPath)).sendKeys(username);
		driver.findElement(By.id(passwordIdPath)).sendKeys(password);
		driver.findElement(By.id(loginByIdPath)).click();
		System.out.println("past login");
		
		
		//Form Inputs
		Select drpYear = new Select(driver.findElement(By.id(yearIdPath)));
		drpYear.selectByVisibleText(year);
		System.out.println("past drop down year select");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Select drpMonth = new Select(driver.findElement(By.id(monthIdPath)));
		drpMonth.selectByVisibleText(month);
		System.out.println("past drop down month select");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.id(aso_idIdPath)).sendKeys(String.valueOf((int)toInput.getAso_id().getNumericCellValue()));
		System.out.println("aso_id input complete");
		driver.findElement(By.id(lastnameIdPath)).click();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//check auto complete after ASO id input
		String lastName = driver.findElement(By.id(lastnameIdPath)).getAttribute("value");
		if(!lastName.equals(toInput.getLast_name().toString())) {
			//add last name input
			System.out.println(lastName.equals(toInput.getLast_name().toString()));
			System.out.println("Last name not there");
		}
		System.out.println("Last name check");
		
		String firstName = driver.findElement(By.id(firstNameIdPath)).getAttribute("value");
		if(!firstName.equals(toInput.getFirst_name().toString())) {
			//add first name input
			System.out.println("First name not there");
		}
		System.out.println("first name check complete");
		
		String DOB = driver.findElement(By.id(birthDateIdPath)).getAttribute("value");
		if(DOB.equals(toInput.getBirthdate())) {
			//make DOB input
			System.out.println("DOB not there");
		}
		System.out.println("DOB check complete");
		
		if("Female".equals(toInput.getGender().toString())){
			
			boolean RadioFemaleCheck = driver.findElement(By.id(genderIdRadioButtonFemale)).isSelected();
			if(!RadioFemaleCheck) {
				WebElement RadioFemale = driver.findElement(By.id(genderIdRadioButtonFemale));
				RadioFemale.click();
				System.out.println("Female is not selected");
			}
			
		} else {
			
			boolean RadioMaleCheck = driver.findElement(By.id(genderIdRadioButtonMale)).isSelected();
			if (!RadioMaleCheck) {
				WebElement RadioMale = driver.findElement(By.id(genderIdRadioButtonMale));
				RadioMale.click();
				System.out.println("Male is not selected");
			}
			
		}
		System.out.println("past radio Check");

		Select drpEthnicityCheck = new Select(driver.findElement(By.id(ethnicityIdPath)));
		String drpEthnicityVal = drpEthnicityCheck.getFirstSelectedOption().toString();
		if(!drpEthnicityVal.equals(toInput.getEthnicity().toString())) {
			//make Ehnicity add
			System.out.println("Ethnicity not there");
		}
		System.out.println("Ethnicity check complete");
		
		Select drpRaceCheck = new Select(driver.findElement(By.id(raceIdPath)));
		String drpRaceVal = drpRaceCheck.getFirstSelectedOption().toString();
		if(!drpRaceVal.equals(toInput.getRace().toString())) {
			//make Race add
			System.out.println("Race not there");
		}
		System.out.println("Race check complete");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String enrollmentDateFormatted = dateFormat.format(toInput.getEnrollment_date().getDateCellValue());

		WebElement BirthDateTest = driver.findElement(By.id(enrollmentDateIdPath));
		BirthDateTest.sendKeys(enrollmentDateFormatted); //Enter this date details with valid date format
		
		System.out.println("Past enrollment date input");
		
		//Input Validation
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean RadioMaleCheck = driver.findElement(By.id(genderIdRadioButtonMale)).isSelected();
		if (RadioMaleCheck) {
			System.out.println("Male is selected");
		} else {
			System.out.println("Male is not selected");
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(YearIdPath)));
		Select drpYearCheck = new Select(driver.findElement(By.id(yearIdPath)));
		WebElement drpYearSelect = drpYearCheck.getFirstSelectedOption();
		System.out.println(drpYearSelect.getText());
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String returnedValue = driver.findElement(By.id(enrollmentDateIdPath)).getAttribute("value");
		System.out.println(returnedValue);
		System.out.println("done");
	}

}

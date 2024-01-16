package com.restfulbooker.UI_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.restfulbooker.pages.Loginpage;
import com.framework.testng.api.base.BaseMethods;


public class TC_001Create_Booking_RB extends BaseMethods{
	@BeforeTest
	public void setfileName() {
		excelFileName="CreateBooking";
		testcaseName="CreateBooking";
		testDescription ="Test data with mandatory Field";
		authors="Ashwini";
		category="Funtional";
	
	}	
	@Test//(dataProvider="fetchData")
	public void runCreateIncident() throws IOException, InterruptedException {
		new Loginpage()
		.enterCredentials()
		.clickAll()
		.clickIncident()
		.clickNewOption()
		.getIncidentNum()
		.enterShortDescription()
		.clickSubmitButton()
		.getTheIncident();
		
		}
	

}

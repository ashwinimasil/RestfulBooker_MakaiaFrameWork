package com.restfulbooker.UI_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;
import com.framework.selenium.restfulbooker.pages.Loginpage;
import com.framework.testng.api.base.BaseMethods;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC_002UpdateBooking extends RESTAssuredBase{
	@BeforeTest
	public void setfileName() {
		excelFileName="updateBooking";
		testcaseName="updateBooking";
		testDescription ="Test data with mandatory Field";
		authors="Ashwini";
		category="Regression";
	
	}
	
	@Test//(dataProvider = "fetchData")
	public void runUpdateIncident() throws IOException, InterruptedException {
		// Post the request
		Response response = RESTAssuredBase.post("bookingid",ContentType.JSON);
		RESTAssuredBase.verifyResponseCode(response, 201);
		JsonPath jsonPath = response.jsonPath();
		String incident_number = jsonPath.get("id"); 
		System.out.println(BookingID);
		
		new Loginpage()
		.enterCredentials()
		.clickAll()
		.clickIncident()
		.searchIncident(incident_number)
		.updateUrgency()
		.updateState()
		.enterCaller()
		.enterShortDescription()
		.clickUpdateButton()
		.verifyIncidentNumber();
		
		}
	

}

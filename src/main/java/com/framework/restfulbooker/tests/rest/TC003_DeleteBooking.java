package com.framework.restfulbooker.tests.rest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;

public class TC003_DeleteBooking extends RESTAssuredBase {
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Delete Booking";
		testDescription = "Delete Booking using REST API";
		authors = "Ashwini";
		category = "REST";
//		dataProvider
		dataFileName = "TC003";
	    dataFileType = "JSON";
	}
	@Test(dependsOnMethods="com.framework.restfulbooker.tests.rest.TC002_UpdateBooking.updateBooking")
	public void deleteBooking() {
	
		response = RestAssured.delete("Booking/"+BookingID);
		System.out.println(response.getStatusCode());
		verifyResponseCode(response, 403);
}
}
package com.framework.restfulbooker.tests.rest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC002_UpdateBooking extends RESTAssuredBase{
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Update Booking";
		testDescription = "Update Booking using REST API";
		authors = "Ashwini";
		category = "REST";
//		dataProvider
		dataFileName = "TC002";
	    dataFileType = "JSON";
	}
	@Test(dependsOnMethods ="com.framework.restfulbooker.tests.rest.TC001_CreateBooking.createBooking")			
		public void updateBooking() {			
		response = putWithBodyAndAuth("Basic YWRtaW46cGFzc3dvcmQxMjM=","{\r\n"
				+ "    \"firstname\" : \"Jim -update\",\r\n"
				+ "    \"lastname\" : \"Brown-update\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}","/"+"booking"+"/"+BookingID);		
		
		verifyResponseCode(response, 200);
		System.out.println("update StatusCode:"+response.getStatusCode());

	}

	


}

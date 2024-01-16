package com.framework.restfulbooker.tests.rest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC001_CreateBooking extends RESTAssuredBase {

	@BeforeTest // Reporting
	public void setValues() {
		testcaseName = "Create Booking";
		testDescription = "Create Booking using REST API";
		authors = "Ashwini";
		category = "REST";
		// dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test
	public void createBooking() {
		System.out.println("Running from main test");
//		String URL = ConfigurationManager.configuration().getBaseURI();
//		System.out.println("URL value"+URL);
		/*
		 * Map <String, String> headerVal=new HashMap<String,String>();
		 * headerVal.put("Authorisation", "test"); headerVal.put("Name", "Raja"); String
		 * jsonObject="{\n" + "    \"firstname\": \"Jim\",\n" +
		 * "    \"lastname\": \"Brown\",\n" + "    \"totalprice\": 111,\n" +
		 * "    \"depositpaid\": true,\n" + "    \"bookingdates\": {\n" +
		 * "        \"checkin\": \"2018-01-01\",\n" +
		 * "        \"checkout\": \"2019-01-01\"\n" + "    },\n" +
		 * "    \"additionalneeds\": \"Breakfast\"\n" + "}";
		 * 
		 * 
		 * 
		 * Response response = postWithHeaderAndJsonBody(headerVal,jsonObject,
		 * "/booking");
		 */
		Response response = postWithBodyAsidandurl("bookingid",
				"{\n" + "    \"firstname\": \"Jim\",\n" + "    \"lastname\": \"Brown\",\n"
						+ "    \"totalprice\": 111,\n" + "    \"depositpaid\": true,\n" + "    \"bookingdates\": {\n"
						+ "        \"checkin\": \"2018-01-01\",\n" + "        \"checkout\": \"2019-01-01\"\n"
						+ "    },\n" + "    \"additionalneeds\": \"Breakfast\"\n" + "}",
				"/booking");
		response.prettyPrint();
		
		System.out.println("Response Code" + response.getStatusCode());
		System.out.println("Response Header for Server:"+response.headers().getValue("Server"));
		verifyResponseCode(response, 200);
		verifyContentType(response, "application/json");
//		System.out.println(extractResponseContent(response, "bookingid").toString());
	    BookingID = extractResponseContentforInt(response, "bookingid");
	}
}
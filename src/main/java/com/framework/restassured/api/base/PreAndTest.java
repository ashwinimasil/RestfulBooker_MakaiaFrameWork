package com.framework.restassured.api.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.config.ConfigurationManager;
import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PreAndTest extends SeleniumBase {
	public static String token;
	public static Integer BookingID;
	public static Response response;
	
	@BeforeMethod
	  public void beforeMethod() throws FileNotFoundException, IOException {
	  
	  setNode();
	  String baseURLValue= ConfigurationManager.configuration().getBaseURI();
	  System.out.println("URL from Config:"+ConfigurationManager.configuration().getBaseURI());
	  RestAssured.baseURI ="https://"+baseURLValue ;
	  RequestSpecification inputRequest = RestAssured.given().basePath("auth").contentType("application/json").when().body("{\n" +
	  "    \"username\" : \"admin\",\n" + "    \"password\" : \"password123\"\n" +
	  "}"); 
	  response = inputRequest.post(); 
	  token = response.jsonPath().getString("token");
	  System.out.println("Token Value"+token);
	  
	  }
	 
	@DataProvider(name = "fetchData")
	public Object[][] getData() {
		if (dataFileType.equalsIgnoreCase("Excel"))
			return DataLibrary.getSheet(dataFileName);
		else if (dataFileType.equalsIgnoreCase("JSON")) {
			Object[][] data = new Object[1][1];
			data[0][0] = new File("./data/" + dataFileName + "." + dataFileType);
			System.out.println(data[0][0]);
			return data;
		} else {
			return null;
		}

	}

}

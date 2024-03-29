package com.framework.selenium.restfulbooker.pages;

import com.framework.data.dynamic.FakerDataFactory;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class CreateIncidentPage extends BaseMethods {

	public  CreateIncidentPage getIncidentNum() {

		incidentNumber = getAttribute(locateElement(Locators.XPATH, "//input[@id='incident.number']"), "value");
		System.out.println(incidentNumber);
		return this;	
	}



	public CreateIncidentPage enterShortDescription() {

		clearAndType(locateElement(Locators.ID, "incident.short_description"),
				FakerDataFactory.getShortDesc());
		return this;

	}


	public VerifyIncidentPage clickSubmitButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Submit']"));
		defaultContent();
		return new VerifyIncidentPage();

	}

}

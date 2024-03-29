package com.framework.selenium.restfulbooker.pages;

import org.openqa.selenium.WebElement;

import com.framework.config.ConfigurationManager;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class UpdatePage extends BaseMethods{

	public UpdatePage updateUrgency() {
		switchToFrame(locateShadowElement("//iframe[@id='gsft_main']"));
		WebElement urDD = locateElement("incident.urgency");
		selectDropDownUsingText(urDD, "1 - High");
		return this;

	}

	public UpdatePage updateState() {
		WebElement stDD = locateElement("incident.state");
		selectDropDownUsingText(stDD, "In Progress");
		return this;
	}

	public UpdatePage enterCaller() {
		click(locateElement("lookup.incident.caller_id"));
		typeAndEnter(locateElement("sys_display.incident.caller_id"),"Abraham Lincoln");
		return this;

	}

	public UpdatePage enterShortDescription() {
		click(locateElement("incident.short_description"));
		typeAndEnter(locateElement("incident.short_description"), ConfigurationManager.configuration().getShortDesc());
		return this;
	}

	public VerifyIncidentPage clickUpdateButton() {
		//click(locateElement("sysverb_update"));
		click(locateElement(Locators.XPATH, "(//button[text()='Update'])[1]"));
		return new VerifyIncidentPage();
	}

	public VerifyIncidentPage deleteIncident() {
		defaultContent();
		switchToFrame(locateShadowElement("//iframe[@id='gsft_main']"));
		click(locateElement(Locators.XPATH, "(//button[text()='Delete'])[2]"));
		click(locateElement("ok_button"));
		return new VerifyIncidentPage();

	}


}

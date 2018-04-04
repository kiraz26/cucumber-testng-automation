package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepDefinitions {
	SuiteCRMDashboardPage dashbboard = new SuiteCRMDashboardPage();

	@When("^I hover over the (Collaboration|Sales|Marketing|Support|All) menu$")
	public void i_hover_over_the_Collaboration_menu(String menu) {
		switch (menu) {
		case "Sales":
			BrowserUtils.hover(dashbboard.sales);
			break;
		case "Marketing":
			BrowserUtils.hover(dashbboard.marketing);
			break;
		case "Support":
			BrowserUtils.hover(dashbboard.support);
			break;
		case "Collaboration":
			BrowserUtils.hover(dashbboard.collaboration);
			break;
		case "All":
			BrowserUtils.hover(dashbboard.all);
			break;
		case "Activities":
			BrowserUtils.hover(dashbboard.activities);
			break;
		}

	}

	@Then("^following menu options should be visible for (Collaboration|Sales|Marketing|Support|All):$")
	public void following_menu_options_should_be_visible_for_Collaboration(String menu, List<String> options) {
		// capture list of webelements
		List<WebElement> topMenuOptions = dashbboard.topMenuOptions(menu);
		// get their text in a list
		List<String> topMenuOptionsString = BrowserUtils.getElementsText(topMenuOptions);
		// compare the list with options
		assertEquals(topMenuOptionsString.size(), options.size(), "Number of expected menu options did not match");
		for (int i = 0; i < options.size(); i++) {
			assertEquals(topMenuOptionsString.get(i), options.get(i));
		}

	}

}

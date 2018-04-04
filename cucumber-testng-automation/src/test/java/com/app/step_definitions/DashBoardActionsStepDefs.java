package com.app.step_definitions;

import static org.testng.Assert.fail;

import com.app.pages.SuiteCRMDashboardPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoardActionsStepDefs {
	
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	
	@When("^I post \"([^\"]*)\"$")
	public void i_post(String note) {
		dashboardPage.postNote(note);
	}

	@Then("^Post should be displayed$")
	public void post_should_be_displayed() {
	   
	}
	
	@Then("^I logout from application$")
	public void i_logout_from_application() {
		dashboardPage.logout();
	}

}

package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.app.pages.HRAppDeptEmpPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.DBType;
import com.app.utilities.DBUtility;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HRAppStepDefs {

	private WebDriver driver = Driver.getDriver();
	private HRAppDeptEmpPage deptEmpPage = new HRAppDeptEmpPage();
	private Map<String, String> UIDepartmentData;
	private Map<String, Object> DBDepartmentData;

	@Given("^I am on DeptEmpPage$")
	public void i_am_on_DeptEmpPage() {
		driver.get(ConfigurationReader.getProperty("hrapp.url"));
	}

	@When("^I search for department id (\\d+)$")
	public void i_search_for_department_id(int deptID) {
		UIDepartmentData = new HashMap<>();

		int currentDepId = Integer.parseInt(deptEmpPage.departmentID.getText());

		while (currentDepId != deptID) {

			deptEmpPage.Next.click();
			BrowserUtils.waitFor(2);
			deptEmpPage = new HRAppDeptEmpPage();
			BrowserUtils.waitForVisibility(deptEmpPage.departmentID, 5);
			currentDepId = Integer.parseInt(deptEmpPage.departmentID.getText());
		}
		// add UI data to hashmap
		UIDepartmentData.put("DEPARTMENT_NAME", deptEmpPage.deparmentName.getText());
		UIDepartmentData.put("MANAGER_ID", deptEmpPage.managerID.getText());
		UIDepartmentData.put("LOCATION_ID", deptEmpPage.locationID.getText());
	}

	@When("^I query database with sql \"([^\"]*)\"$")
	public void i_query_database_with_sql(String sql) throws SQLException {
		DBUtility.establishConnection(DBType.ORACLE);
		List<Map<String, Object>> DBDataList = DBUtility.runSQLQuery(sql);
		DBDepartmentData = DBDataList.get(0);
		DBUtility.closeConnections();
	}

	@When("^I search for email \"([^\"]*)\" to see firstname and lastname$")
	public void i_search_for_email_to_see_firstname_and_lastname(String emailID) {
		deptEmpPage.email.clear();
		deptEmpPage.email.sendKeys(emailID);
		deptEmpPage.FindDetails.click();
		BrowserUtils.waitForVisibility(deptEmpPage.firstname, 5);
		UIDepartmentData = new HashMap<>();
		UIDepartmentData.put("FIRST_NAME", deptEmpPage.firstname.getText());
		UIDepartmentData.put("LAST_NAME", deptEmpPage.lastname.getText());
	}

	@When("^I search for department id (\\d+) and get number of employees$")
	public void i_search_for_department_id_and_get_number_of_employees(int deptID) {
		deptEmpPage.searchForDepartment(deptID);
		deptEmpPage.detach.click();
		BrowserUtils.waitFor(2);
		BrowserUtils.scrollDown();
		UIDepartmentData = new HashMap<>();
		UIDepartmentData.put("EMPLOYEES_COUNT", String.valueOf(deptEmpPage.employeesCount.size()));

	}

	@Then("^UI data and Database data must match$")
	public void ui_data_and_Database_data_must_match() {
		for (String key : DBDepartmentData.keySet()) {
			assertEquals(UIDepartmentData.get(key), String.valueOf(DBDepartmentData.get(key)));
		}

		// assertEquals(UIDepartmentData, DBDepartmentData);
		// assertEquals(UIDepartmentData.get("DEPARTMENT_NAME"),
		// DBDepartmentData.get("DEPARTMENT_NAME"));
		// assertEquals(UIDepartmentData.get("MANAGER_ID"),
		// String.valueOf(DBDepartmentData.get("MANAGER_ID")));
		// assertEquals(UIDepartmentData.get("LOCATION_ID"),
		// String.valueOf(DBDepartmentData.get("LOCATION_ID")));
	}
}

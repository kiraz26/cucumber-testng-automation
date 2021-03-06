package com.app.step_definitions.api;

import static io.restassured.RestAssured.*;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.app.pages.HRAppDeptEmpPage;
import com.app.pages.HRappSearchPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class API_PostAnEmployee {

	RequestSpecification request;
	int employeeId;
	Response response;
	Map requestMap = new HashMap<>();
	HRappSearchPage searchPage = new HRappSearchPage();;
	HRAppDeptEmpPage deptEmpPage = new HRAppDeptEmpPage();
	Map uiEmployeeDataMap;

	@Given("^Content Type and Accept type is JSON$")
	public void content_Type_and_Accept_type_is_JSON() {
		request = given().log().all().and().accept(ContentType.JSON).and().contentType(ContentType.JSON);
	}

	@When("^I post a new Employee with \"([^\"]*)\" id$")
	public void i_post_a_new_Employee_with_id(String id) {

		if (id.equals("random")) {
			employeeId = new Random().nextInt(99999);
		} else {
			employeeId = Integer.parseInt(id);
		}

		requestMap.put("employee_id", employeeId);
		requestMap.put("first_name", "Hsdle");
		requestMap.put("last_name", "Jsdgq");
		requestMap.put("email", "EM" + employeeId);
		requestMap.put("phone_number", "193.532.3492");
		requestMap.put("hire_date", "2010-04-23T08:00:00Z");
		requestMap.put("job_id", "IT_PROG");
		requestMap.put("salary", 25000);
		requestMap.put("commission_pct", null);
		requestMap.put("department_id", 90);
		requestMap.put("manager_id", null);

		response = request.body(requestMap).when()
				.post(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/");
	}

	@Then("^Status code is (\\d+)$")
	public void status_code_is(int statusCode) {
		assertEquals(response.statusCode(), statusCode);
	}

	@When("^I send a GET request with \"([^\"]*)\" id$")
	public void i_send_a_GET_request_with_id(String id) {
		if (!id.equals("random")) {
			employeeId = Integer.parseInt(id);
		}
		response = request.when()
				.get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/" + employeeId);

	}

	@Then("^Employee JSON Response data should match the posted JSON data$")
	public void employee_JSON_Response_data_should_match_the_posted_JSON_data() {
		Map responseMap = response.body().as(Map.class);
		for (Object key : requestMap.keySet()) {
			System.out.println(key + ": " + responseMap.get(key) + "<=>" + requestMap.get(key));
			assertEquals(responseMap.get(key), requestMap.get(key));
		}
	}

	@Then("^I search for Employee with \"([^\"]*)\" id$")
	public void i_search_for_Employee_with_id(String id) {
		if (!id.equals("random")) {
			employeeId = Integer.parseInt(id);
		}

		deptEmpPage.query.click();
		searchPage.empIdSearchField.clear();
		searchPage.empIdSearchField.sendKeys(String.valueOf(employeeId));
		searchPage.search.click();

	}

	@Then("^UI search results must match API post employee data$")
	public void ui_search_results_must_match_API_post_employee_data() {
		BrowserUtils.waitFor(3);

		uiEmployeeDataMap = new HashMap<>();
		uiEmployeeDataMap.put("employee_id", Integer.valueOf(searchPage.employeeId.getAttribute("value")));
		uiEmployeeDataMap.put("first_name", searchPage.firstName.getAttribute("value"));
		uiEmployeeDataMap.put("last_name", searchPage.lastName.getAttribute("value"));
		uiEmployeeDataMap.put("email", searchPage.email.getAttribute("value"));
		// uiEmployeeDataMap.put("hire_date",searchPage.hireDate.getAttribute("value"));
		uiEmployeeDataMap.put("job_id", searchPage.jobId.getAttribute("value"));
		uiEmployeeDataMap.put("salary", Integer.valueOf(searchPage.salary.getAttribute("value")));
		uiEmployeeDataMap.put("department_id", Integer.valueOf(searchPage.departmentId.getText()));

		// compare the data againist Json data used in POST api / MAP
		for (Object key : uiEmployeeDataMap.keySet()) {
			System.out.println(key + ": " + uiEmployeeDataMap.get(key) + "<=>" + requestMap.get(key));
			assertEquals(uiEmployeeDataMap.get(key), requestMap.get(key));
		}
	}

}

package com.app.tests;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

import com.app.utilities.ConfigurationReader;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIDay5_POSTThenGET {
	// POST and GET Scenario:
	// Given Content Type and Accept type is JSON
	// When I post a new Employee with "4532" id
	// Then status code is 201
	// And Response Json should contain Employee info
	// When I send a GET request with "4532" id
	// Then status code is 200
	// And Employee JSON Response data should match the posted JSON data

	@Test
	public void PostEmployeeThenGetEmployee() {
		int randomID = new Random().nextInt(99999);
		Map requestMap = new HashMap<>();
		requestMap.put("employee_id", randomID);
		requestMap.put("first_name", "Hsdle");
		requestMap.put("last_name", "Jsdgq");
		requestMap.put("email", "EM" + randomID);
		requestMap.put("phone_number", "193.532.3492");
		requestMap.put("hire_date", "2010-04-23T08:00:00Z");
		requestMap.put("job_id", "IT_PROG");
		requestMap.put("salary", 25000);
		requestMap.put("commission_pct", null);
		requestMap.put("department_id", 90);
		requestMap.put("manager_id", null);

		Response response = given().log().all().and().accept(ContentType.JSON).and().contentType(ContentType.JSON).and()
				.body(requestMap).when().post(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/");
		assertEquals(response.statusCode(), 201);

		response = given().and().accept(ContentType.JSON).and().contentType(ContentType.JSON).when()
				.get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/" + randomID);
		assertEquals(response.statusCode(), 200);
		Map responseMap = response.body().as(Map.class);
		// And Response JSON should contain Employee info
		for (Object key : requestMap.keySet()) {
			System.out.println(key+": "+responseMap.get(key)+"<=>" + requestMap.get(key));
			assertEquals(responseMap.get(key), requestMap.get(key));
		}

	}
}

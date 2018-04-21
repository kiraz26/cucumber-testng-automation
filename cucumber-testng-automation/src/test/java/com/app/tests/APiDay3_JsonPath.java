package com.app.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.app.utilities.ConfigurationReader;

import io.restassured.http.ContentType;

public class APiDay3_JsonPath {

	/*
	 * Given Accept type is JSON When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/regions Then response status should be 200
	 * And response content should be json And 4 regions should be returned And
	 * Americas is one of the region names
	 * 
	 */

	@Test
	public void testItemsCountResponseBody() {
		given().accept(ContentType.JSON).when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions")
				.then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON).and().assertThat()
				.body("items.region_id", hasSize(4)).and().assertThat().body("items.region_name", hasItem("Americas"))
				.and().assertThat()
				.body("items.region_name", hasItems("Americas", "Asia", "Europe", "Middle East and Africa"));

	}

	/*
	 * Given Accept type is JSON And Params are limit 100 When I send a GET request
	 * Rest Url http://34.223.219.142:1212/ords/hr/employee Then response status
	 * should be 200 And response content should be json And 100 employees data
	 * should be in JSON response body
	 * 
	 */
	@Test
	public void testWithQueryParameterAndList() {
		given().accept(ContentType.JSON).and().params("limit", 100).when()
				.get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees").then().statusCode(200).and()
				.contentType(ContentType.JSON).and().assertThat().body("items.employee_id", hasSize(100));

	}
	///////
	// 2 Types of Parameters in Rest Services:
	// 1)Query Parameters:
	// -> is not part of url and passed in key+value format those parameters must be
	// definaed by API developer
	// 2)Path Parameters:
	// -> is a part of URl and followed by the end of full resource url
	///////

	/*
	 * Given Accept type is JSON And Params are limit = 100 And path param is 110
	 * When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/employee Then response status should be
	 * 200 And response content should be json And following data should be
	 * "employee_id": 110, "first_name": "John", "last_name": "Chen", "email":
	 * "JCHEN",
	 * 
	 */
	@Test
	public void testWithPathParameter() {
		given().accept(ContentType.JSON).and().params("limit", 100).and().pathParams("employee_id", 110).when()
				.get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/{employee_id}").then()
				.assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON).and().assertThat()
				.body("employee_id", equalTo(110), "first_name", equalTo("John"), "last_name", equalTo("Chen"), "email",
						equalTo("JCHEN"));
	}

}
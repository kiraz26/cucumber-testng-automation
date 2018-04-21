package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;


import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HRRestAPIGetRequests {
	/*
	 * When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/employees then response status should be
	 * 200
	 */

	@Test
	public void simpleGet() {
		when().get("http://34.223.219.142:1212/ords/hr/employees").then().statusCode(200);

	}

	/*
	 * When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/countries Then I should see JSON response
	 */

	@Test
	public void printResponse() {
		when().get("http://34.223.219.142:1212/ords/hr/countries").andReturn().body().prettyPrint();

	}

	/*
	 * When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/countries/US And Accept type is
	 * "application/json" Then response status code should be 200
	 */

	@Test
	public void getWithHeaders() {
		with().accept(ContentType.JSON).when().get("http://34.223.219.142:1212/ords/hr/countries/US").then()
				.statusCode(200);

	}

	/*
	 * When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/employees/1234 Then status code is 404 and
	 * Response body error message is "Not Found"
	 * 
	 */

	@Test
	public void negativeGet() {

		Response response = when().get("http://34.223.219.142:1212/ords/hr/employees/1234");
		assertEquals(response.statusCode(), 404);
		assertTrue(response.asString().contains("Not Found"));
		response.prettyPrint();

	}

	/*
	 * When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/employees/100 And Accept type is JSON Then
	 * status code is 200 And Response content should ne JSON
	 * 
	 * WITH, WHEN, GET, ASSERTTHAT, ACCEPT, CONTENTTYPE
	 * 
	 */

	@Test
	public void verifyContentTypeWithAssertThat() {
		String url = "http://34.223.219.142:1212/ords/hr/employees/100";
		given().accept(ContentType.JSON).when().get(url).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON);
	}

	/*
	 * Given Accept type is JSON When I send a GET request Rest Url
	 * http://34.223.219.142:1212/ords/hr/employees/100 Then status code is 200 And
	 * Response content should be JSON And first name should be "Steven"
	 * 
	 */

	@Test
	public void verifyFirstName() throws URISyntaxException {
		URI uri = new URI("http://34.223.219.142:1212/ords/hr/employees/100");

		given().accept(ContentType.JSON).when().get(uri).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().assertThat().body("first_name", Matchers.equalTo("Steven"));

	}

}

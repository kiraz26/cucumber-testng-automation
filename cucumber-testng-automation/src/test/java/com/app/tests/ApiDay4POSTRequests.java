package com.app.tests;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.app.beans.Region;
import com.app.beans.RegionResponse;
import com.app.utilities.ConfigurationReader;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiDay4POSTRequests {
	/*
	 * POST SCENARIO: Given content type is JSON And accept type is JSON When send
	 * POST request to http://34.223.219.142:1212/ords/hr/regions with request body
	 * { "region_id":4564, "region_name":"sdsd" } Then status code is 201
	 * 
	 */
	@Test
	public void postNewRegion() {
		// String requestJson = "{\"region_id\":4564,\"region_name\":\"sdsd\"}";
		Map requestMap = new HashMap<>();
		requestMap.put("region_id", 116741);
		requestMap.put("region_name", "QW ERT");
		Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).and().body(requestMap)
				.when().post(ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions/");
		System.out.println(response.statusLine());
		response.prettyPrint();

		assertEquals(response.statusCode(), 201);

		Map responseMap = response.body().as(Map.class);
		// assertEquals(responseMap, requestMap); did not work
		assertEquals(responseMap.get("region_id"), requestMap.get("region_id"));
		assertEquals(responseMap.get("region_name"), requestMap.get("region_name"));
		// Custom Java Classes to Match
	}

	@Test
	public void postUsingPOJO() {
		Region region = new Region();
		region.setRegion_id(3452);
		;
		region.setRegion_name("Trebasd");

		Response response = given().log().all().accept(ContentType.JSON).and().contentType(ContentType.JSON).and()
				.body(region).when().post(ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions/");
		assertEquals(response.statusCode(), 201);

		RegionResponse responseRegion = response.body().as(RegionResponse.class);

	}

}

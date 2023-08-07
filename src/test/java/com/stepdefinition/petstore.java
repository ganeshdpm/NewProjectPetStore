package com.stepdefinition;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.Assert;

import com.Utilities.User;
import com.Utilities.Utilities;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class petstore {
	static RequestSpecification spec;
	public static Response response;
	static Utilities ut = new Utilities();
	static Faker faker;
	static User userpayload;
	
	static Map<String, String> map = new java.util.HashMap<String, String>();


	@Given("Enpoint Base URL {string}")
	public void baseURLEndPoint(String url) {
		map.put("$url", url);
		
	}
	
	@Given("Endpoint Base Path Url {string} for {string} request")
	public static void basePathEndPoint(String endpointurl, String requestMethod) {
		userpayload = new User();
		String BaseURL = map.get("$url");
		if (BaseURL != null && !requestMethod.equalsIgnoreCase("post")) {
			String url = BaseURL + endpointurl + map.get("$username");
			ut.setPath(url);
			
		}else {
			String url = BaseURL + endpointurl;
			ut.setPath(url);
		}
	}
	
	@When("I set Headers {string} as {string}")
	public static void headerSetup(String type, String Value) {
		spec = ut.getReq().header(type, Value);
		ut.setReq(spec);
	}
	
	@Then("I send {string} request body")
	public static void requestbody (String requestMethod) throws Exception {
		faker = new Faker();
		userpayload = new User();
		if(requestMethod.equalsIgnoreCase("post")) {
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(6, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
			map.put("$username", userpayload.getUsername());
			map.put("$firstName", userpayload.getFirstName());
			map.put("$lastName", userpayload.getLastName());
			map.put("$email", userpayload.getEmail());
		}else if (requestMethod.equalsIgnoreCase("put")) {
			userpayload.setFirstName(faker.name().firstName());
			userpayload.setLastName(faker.name().lastName());
			userpayload.setEmail(faker.internet().safeEmailAddress());
		}
		spec = ut.getReq().body(userpayload);
		ut.setReq(spec);
}
			
	@When("I send {string} Request")
	public static void requestMethod (String MethodName) {
		String path = ut.getPath();
		System.out.println(path);
		RequestSpecification spec = ut.getReq().log().all();
		System.out.println(spec);
		if(MethodName.equalsIgnoreCase("GET")) {
			response= ut.getRequestMethod(path, spec);
		}else if(MethodName.equalsIgnoreCase("Post")) {
			response = ut.postRequestMethod(path, spec);
	}else if(MethodName.equalsIgnoreCase("Put")) {
		response = ut.PutRequestMethod(path, spec);
	}else if (MethodName.equalsIgnoreCase("Delete")){
		response = ut.deleteRequestMethod(path, spec);
	}
		ut.setRes(response);
		ut.setReq(given().when());
	}
	
	@Then("I verify status Code {int}")
	public static void statuscode(int Expectedcode) {
		int Actual = ut.getRes().andReturn().statusCode();
		Assert.assertEquals(Expectedcode, Actual);
	}
	@Then("I print the response")
	public static void printresponse() {
		System.out.println("Response:" + ut.getRes().getBody().prettyPrint());
	}
	@Then("I validate {string} value present in field {string}")
	public void validateTheField(String Expected, String path) throws Exception {
		String expectedtext = map.get("$" + Expected);
		System.out.println("ExpectedText: " + expectedtext);
		if (Expected.length() > 0) {
			String keyValue = ut.getRes().getBody().jsonPath().get(path).toString();
			System.out.println("ActualText: " + keyValue);
			Assert.assertEquals(expectedtext, keyValue.toString());
		}
	}
	@Given("Endpoint Base Path Url {string} for {string} request for invalid UserName")
	public static void EndpointInvalidUserName(String endpointurl, String requestMethod) {
		String BaseURL = map.get("$url");
			String url = BaseURL + endpointurl;
			ut.setPath(url);
	}
}

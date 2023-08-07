package com.Utilities;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilities{
	
	static Response response = null;
	private RequestSpecification req = given().when();
	
	private Response res;
	private String Path;
	
	public  RequestSpecification getReq() {
		return req;
	}

	public void setReq(RequestSpecification req) {
		this.req = req;
	}
	
	public Response getRes() {
		return res;
	}

	public void setRes(Response res) {
		this.res = res;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}
	
	public Response getRequestMethod(String path, RequestSpecification spec) {
			response = spec.get(path);
			return response;
		}
	public Response postRequestMethod(String path, RequestSpecification spec) {
		response = spec.post(path);
		return response;
		}
	public Response PutRequestMethod(String path, RequestSpecification spec) {
		response = spec.put(path);
		return response;
	}
	public Response deleteRequestMethod(String path, RequestSpecification spec) {
		
		response = spec.delete(path);
		return response;
	}
}

package com.myProject.Cricket.client.template;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

public final class RolesSimpleApiClient {
	
	private final static String JSON = MediaType.APPLICATION_JSON_VALUE.toString();
	
	
	private final RequestSpecification givenAuthenticated() {
		
		
		return RestAssured.given().auth().preemptive().basic(getDefaultCredentials().get("userName"), getDefaultCredentials().get("password"));
	}
	
	
	private final Map<String,String> getDefaultCredentials(){
		
		Map<String,String> credentialMap = new HashMap();
		credentialMap.put("userName", "mayuran");
		credentialMap.put("password", "mayuran");
		
		return credentialMap;
		
	}

}

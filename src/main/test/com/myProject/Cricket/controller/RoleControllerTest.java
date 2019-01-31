package com.myProject.Cricket.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.myProject.Cricket.CricketMainApplication;
import com.myProject.Cricket.model.Role;


@ActiveProfiles("mysql")
@RunWith(SpringRunner.class)
@SpringBootTest
@Import({ CricketMainApplication.class })
// @ContextConfiguration(classes=
// {CricketContextConfig.class,CricketJavaSecurityConfig.class,CricketPersistenceJpaConfig.class,CricketServiceConfig.class})
public class RoleControllerTest {
	public static String getRoleUri;
	private static String createRoleUri;

	@BeforeClass
	public static void setUp() {

		getRoleUri = Messages.getString("RoleControllerTest.getALlRoles");
		createRoleUri = Messages.getString("RoleControllerTest.createRole");
	}

	@Test
	public void whenAllRolesAreRetrieved_then200k() {

		final RequestSpecification basicAuth = RestAssured.given().auth().preemptive().basic("mayuran", "mayuran"); //$NON-NLS-1$ //$NON-NLS-2$
		final Response response = basicAuth.accept(ContentType.JSON).get(getRoleUri);

		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode == 200);

		// todo
		// Assert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
	}

	@Test
	public void whenAllRolesRetrieved_thneAtleastOneRoleExists() {

		final RequestSpecification requestSpec = RestAssured.given().auth().preemptive().basic("mayuran", "mayuran");
		final Response response = requestSpec.accept(ContentType.JSON).get(getRoleUri);
		
		final List<Role> roles = response.as(List.class);
		
		assertTrue(roles!=null);

	}
	
	@Test
	public void whenCreatingANewRole_thneRoleCanBeRetrieved() {
		
		final Role newRole = new Role("Admin");
		final RequestSpecification writeRequestSpec = RestAssured.given().auth().preemptive().basic("mayuran", "mayuran");
		final Response response = writeRequestSpec.contentType(ContentType.JSON).body(newRole).post(createRoleUri);
		
		final String locationHeader = response.getHeader("Location");
		final RequestSpecification readRequestSpec = RestAssured.given().auth().preemptive().basic("mayuran", "mayuran");
		final Role retrievedRole = readRequestSpec.accept(ContentType.JSON).get(locationHeader).as(Role.class);
		
		assertTrue(newRole==retrievedRole);
		
	}

}

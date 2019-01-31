package com.myProject.Cricket.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myProject.Cricket.model.Login;


@Controller
public class LoginController {
	@PostMapping("/api/login")
	public ResponseEntity<?> login(@RequestBody Login login) {

		// validate login here

		return new ResponseEntity("Successfully login", new HttpHeaders(), HttpStatus.OK);

	}

}

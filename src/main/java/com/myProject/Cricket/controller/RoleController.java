package com.myProject.Cricket.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.myProject.Cricket.model.Role;
import com.myProject.Cricket.repository.RoleRepository;


@RestController
@RequestMapping(value = "roles")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public final List<Role> findAllRoles(final HttpServletRequest httpServletRequest) {

		return (List<Role>) roleRepository.findAll();

	}

	@RequestMapping(value="/create",method = RequestMethod.POST)
   // @Secured("CAN_USER_WRITE")	
	public ResponseEntity<Role> create(@RequestBody @Valid Role role, UriComponentsBuilder ucBuilder) {
		roleRepository.save(role);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(role.getId()).toUri());
		return new ResponseEntity<Role>(headers,HttpStatus.CREATED);
	}
	
	
/*	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException(id));
	}*/
	


	
}

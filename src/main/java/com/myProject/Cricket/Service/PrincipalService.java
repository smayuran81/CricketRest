package com.myProject.Cricket.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.Cricket.model.Principal;
import com.myProject.Cricket.repository.PrincipalRepository;

@Service
@Transactional
public class PrincipalService {

	@Autowired
	PrincipalRepository pricipalRepository;

	@Transactional
	public Principal findByName(final String name) {
		return pricipalRepository.findByName(name);
	}
	
	

}

package com.myProject.Cricket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.Cricket.model.Role;
import com.myProject.Cricket.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	
	public List<Role> findAll() {
		
		return (List<Role>) roleRepository.findAll();
		
		
	}

}

package com.myProject.Cricket.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myProject.Cricket.model.Role;
import com.myProject.Cricket.repository.RoleRepository;

public class RoleControllerAsync {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Async
	@RequestMapping(value = "/findAllAsync", method = RequestMethod.GET)
	public CompletableFuture<Role> getRolesAysncy() throws InterruptedException {
		
		Role r=null;
		CompletableFuture<Iterable<Role>> completableFuture=CompletableFuture.supplyAsync(()->roleRepository.findAll());
		
		System.out.println(Thread.currentThread());
		
		System.out.println("First Find All method kicked off");
		
		CompletableFuture<Iterable<Role>> completableFuture2 =CompletableFuture.supplyAsync(()->roleRepository.findAll());
		
		System.out.println("Second Find All method kicked off");
		
		try {
			List<Role> roles = (List<Role>)completableFuture.get();
			
			r=roles.stream().findFirst().get();
			
			
		} catch (ExecutionException e) {
		
			e.printStackTrace();
		}
																	
		 //CompletableFuture.completedFuture("Return Completable Future Trial");
		
		return CompletableFuture.completedFuture(r);
		
	}

}

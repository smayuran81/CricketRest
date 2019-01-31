package com.myProject.Cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.Cricket.model.Principal;

@Repository
public interface PrincipalRepository extends JpaRepository<Principal, Long> {
	
	Principal findByName(final String name);

}

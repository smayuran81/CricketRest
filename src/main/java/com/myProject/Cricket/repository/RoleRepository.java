package com.myProject.Cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.Cricket.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}

package com.soham.ms.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> 
{

	//Users findbyPassword(String password);
	
	

}

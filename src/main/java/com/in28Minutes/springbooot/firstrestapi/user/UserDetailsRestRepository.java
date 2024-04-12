package com.in28Minutes.springbooot.firstrestapi.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long>{
	
	List<UserDetails> findByRole(String role);

}

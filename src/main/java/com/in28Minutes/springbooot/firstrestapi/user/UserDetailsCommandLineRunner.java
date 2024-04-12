package com.in28Minutes.springbooot.firstrestapi.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner{

	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private UserDetailsRepository repository;
	
	
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info(args.toString());
		
		repository.save(new UserDetails("Ranga", "Admin"));
		repository.save(new UserDetails("Ravi", "Admin"));
		repository.save(new UserDetails("John", "Admin"));
		
		List<UserDetails> users = repository.findAll();
		users.forEach(user -> logger.info(user.toString()));
		
		List<UserDetails> users2 = repository.findByRole("Admin");
		users2.forEach(user -> logger.info(user.toString()));
	}

	
}

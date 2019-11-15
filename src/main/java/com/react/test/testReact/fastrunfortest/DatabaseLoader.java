package com.react.test.testReact.fastrunfortest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.react.test.testReact.model.Company;
import com.react.test.testReact.repository.CompanyRepository;

public class DatabaseLoader implements CommandLineRunner{

	private final CompanyRepository companyRepository;
	
	@Autowired
	public DatabaseLoader(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.companyRepository.save(new Company("Frodo", "Baggins", 20));
	}

}

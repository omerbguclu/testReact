package com.react.test.testReact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.test.testReact.model.Company;
import com.react.test.testReact.repository.CompanyRepository;

@RestController
public class HomeRestController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@RequestMapping("/api")
	public List<Company> restHome() {
		List<Company> company = (List<Company>) companyRepository.findAll();
		return company;
	}
	

}

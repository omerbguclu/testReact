package com.react.test.testReact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.react.test.testReact.model.Company;
import com.react.test.testReact.repository.CompanyRepository;

@Controller
public class MainController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping("/create/{name}+{surname}+{age}")
	public String createNewCompany(@PathVariable(name = "name") String name,@PathVariable(name = "surname") String surname,@PathVariable(name = "age") int age) {
		companyRepository.save(new Company(name, surname, age));
		return "redirect:/";
	}
}

package com.react.test.testReact.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.test.testReact.model.Company;
import com.react.test.testReact.repository.CompanyRepository;

@RestController
@RequestMapping("/api")
public class CompanyController {
    private final Logger log = LoggerFactory.getLogger(CompanyController.class);
    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/companies")
    Collection<Company> companies() {
        return (Collection<Company>) companyRepository.findAll();
    }

    @GetMapping("/company/{id}")
    ResponseEntity<?> getCompany(@PathVariable Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/company")
    ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) throws URISyntaxException {
        log.info("Request to create company: {}", company);
        Company result = companyRepository.save(company);
        return ResponseEntity.created(new URI("/api/company/" + result.getId()))
                .body(result);
    }

    @PutMapping("/company/{id}")
    ResponseEntity<Company> updateCompany(@Valid @RequestBody Company company) {
        log.info("Request to update company: {}", company);
        Company result = companyRepository.save(company);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
        log.info("Request to delete company: {}", id);
        companyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

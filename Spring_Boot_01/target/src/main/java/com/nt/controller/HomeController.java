package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
public class HomeController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@PostMapping("/emp")
	public Employee addEmp(@RequestBody Employee e) {

		return employeeRepo.save(e);

	}

	@PutMapping("/emp")
	public Employee updateEmp(@RequestBody Employee e) {

		return employeeRepo.save(e);

	}

	@DeleteMapping("/emp/{id}")
	public String deleteById(@PathVariable int id) {
		employeeRepo.deleteById(id);
		return "deleted Success";
	}
	
	@GetMapping("/emp")
	public Employee getMethodName(@RequestParam int id) {
		Optional<Employee>  opt =  employeeRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
		
	}
		
	
	@GetMapping("/empall")
	public List<Employee> getAllEmp() {
		
	  Iterable<Employee> it =	employeeRepo.findAll();
	  
	  List<Employee> list = new ArrayList<>();
	  for( Employee e : it) {
		  list.add(e);
	  }
	  
	  
		return list;
		
	}
	
	
	
	
	
	

}

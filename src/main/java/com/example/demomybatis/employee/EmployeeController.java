package com.example.demomybatis.employee;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;
	
	@GetMapping("/employees")
	public Collection<Employee> allEmployee(){
		return employeeServices.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getRokokById(@PathVariable int id){
		return employeeServices.getById(id);
	}
	
	@PostMapping("/employees")
	public String insert(@RequestBody Employee employee){
		return employeeServices.insert(employee);
	}
	
	@PostMapping("/employees/{id}")
	public String update(@PathVariable int id, @RequestBody Employee employee){
		employee.setId(id);
		return employeeServices.update(employee);
	}
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable int id){
		return employeeServices.delete(id);
	}
}

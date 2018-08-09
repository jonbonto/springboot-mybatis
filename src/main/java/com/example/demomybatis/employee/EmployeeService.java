package com.example.demomybatis.employee;

import org.springframework.stereotype.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

@Service
class EmployeeServices{
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	public Collection<Employee> findAll(){
		return employeeMapper.findAll();
	}
	
	public String delete(int id) {
		employeeMapper.delete(id);
		return "delete successfully";
	}

	public String update(Employee employee) {
		employeeMapper.update(employee);
		return "update successfully";
	}

	public Employee getById(int id){
		return employeeMapper.selectById(id);
	}
	public String insert(Employee employee){
		employeeMapper.insert(employee);
		return "insert successfully";
	}
}

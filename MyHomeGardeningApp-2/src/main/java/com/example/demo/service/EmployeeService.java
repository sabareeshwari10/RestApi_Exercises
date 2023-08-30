package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo er;
	public Employee saveinfo(Employee e) {
		return er.save(e);
	}
	public List<Employee> savedetails(List<Employee> e){
		return (List<Employee>)er.saveAll(e);
	}
	public List<Employee> showinfo(){
		return er.findAll();
	}
	public void deleteid(int id) {
		er.deleteById(id);
	}
	
	public Employee saveemployeedetails(Employee e) {
		return er.save(e);
	}
	public List<Employee> showemployeeinfo(){
		return er.findAll();
	}
	public List<Employee>getemp(int i,String s){
		return er.getEmployeeInfo(i,s);
	}
	public int delemp(int id) {
		return er.deleteEmployeeinfo(id);
		
	}
	public int updateemp(int id,int id1) {
		return er.updateEmployeeInfo(id, id1);
	}
	
	

}
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService ser;
	@PostMapping("addemployee")
	public Employee add(@RequestBody Employee e) {
		return ser.saveinfo(e);
	}
	@PostMapping("addnemployee")
	public List<Employee> addndetails(@RequestBody List<Employee> e){
		return ser.savedetails(e);
	}
	
	@GetMapping("showemployeedetails")
	public List<Employee> show(){
		return ser.showinfo();
		
	}
	@DeleteMapping("delempid/{id}")
	public void deletemyid(@PathVariable int id) {
		ser.deleteid(id);
	}
	@PostMapping("addemployeeinfo")
	public Employee addcustomer(@RequestBody Employee e) {
		return ser.saveemployeedetails(e);
		
	}
	@GetMapping("showemployeeinfo")
	public List<Employee> getDetails(){
		return ser.showemployeeinfo();
	}
	@GetMapping ("showquery/{empid}/{empname}")
	public List<Employee> showdetails(@PathVariable int empid,@PathVariable String empname){
		return ser.getemp(empid, empname);
	}
	@DeleteMapping("deletequery/{empid}")
	public String delstudetails(@PathVariable int empid) {
		return ser.delemp(empid)+" data deleted";
	}
	@PutMapping("updatequery/{newid}/{oldid}")
	public String updatestudetails(@PathVariable int newid,@PathVariable int oldid) {
		return ser.updateemp(newid, oldid)+" data updated";
	}
	
	
}
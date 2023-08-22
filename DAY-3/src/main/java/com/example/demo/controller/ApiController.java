package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService ser;
	@PostMapping("addemployee")
	public Employee add(@RequestBody Employee e) {
		return ser.saveinfo(e);
	}
	@GetMapping("showdetails")
	public List<Employee> show(){
		return ser.showinfo();
	}
}

package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllerEx1 {
	@GetMapping("ex1")
	public String display() {
		return "WELCOME";
		
	}

}

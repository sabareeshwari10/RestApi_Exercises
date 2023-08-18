package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllerDay2Ex1 {
	@Value("${name}")
	private String name;
	@GetMapping("d2ex1")
	public String function() {
		return name;
	}

}

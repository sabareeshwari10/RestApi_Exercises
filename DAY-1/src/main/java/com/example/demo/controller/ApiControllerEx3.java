package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllerEx3 {
	@Value("${color}")
	private String color;
	@GetMapping("ex3")
	public String getMyFav() {
		return "My favourite color is "+color;
	}

}

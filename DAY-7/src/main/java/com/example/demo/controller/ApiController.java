package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService aser;
	
	@GetMapping ("showquery/{id}/{name}")
	public List<Car> showdetails(@PathVariable int id,@PathVariable String name){
		return aser.getcar(id, name);
	}
	@DeleteMapping("deletequery/{id}")
	public String delstudetails(@PathVariable int id) {
		return aser.delcar(id)+" data deleted";
	}
	@PutMapping("updatequery/{newid}/{oldid}")
	public String updatestudetails(@PathVariable int newid,@PathVariable int oldid) {
		return aser.updatecar(newid, oldid)+" data updated";
	}

}

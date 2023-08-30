package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.Apiservice;

@RestController
public class Apicontroller {
	@Autowired
	Apiservice aps;
	
	@PostMapping("addchilddetails")
	public Child add(@RequestBody Child ss) {
		return aps.saveinfo(ss);
	}
	@GetMapping("sort/{name}")
	public List<Child> getsortinfo(@PathVariable String name){
		return aps.sortinfo(name);
	}
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize){
		return aps.getbypage(pageno,pagesize);
	}
	@GetMapping("pagingandsorting/{pageno}/{pagesize}/{name}")
	public List<Child>showpageinfosorted(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name){
		return aps.getbypagesorted(pageno, pagesize, name);
	}

}

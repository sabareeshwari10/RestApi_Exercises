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

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
CustomerService cs;
	@PostMapping("addcustomer")
	public Customer add(@RequestBody Customer ss) {
		return cs.saveinfo(ss);
	}
	@PostMapping("addncustomer")
	public List<Customer> addndetails(@RequestBody List<Customer> c){
		return cs.savedetails(c);
	}
	
	@GetMapping("showcustomerdetails")
	public List<Customer> show(){
		return cs.showinfo();
		
	}
	@PutMapping("update")
	public Customer modify(@RequestBody Customer c) {
		return cs.changeinfo(c);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody Customer c){
		return cs.updateinfobyid(id,c);
	}
	@DeleteMapping("delcustid/{id}")
	public void deletemyid(@PathVariable int id) {
		cs.deleteid(id);
	}
	
	@PostMapping("addcustomerinfo")
	public Customer addcustomer(@RequestBody Customer c) {
		return cs.savecustomerdetails(c);
		
	}
	@GetMapping("showcustomerinfo")
	public List<Customer> getDetails(){
		return cs.showcustomerinfo();
	}
	
	@GetMapping("sort/{name}")
	public List<Customer> getsortinfo(@PathVariable String name){
		return cs.sortinfo(name);
	}
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<Customer> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize){
		return cs.getbypage(pageno,pagesize);
	}
	@GetMapping("pagingandsorting/{pageno}/{pagesize}/{name}")
	public List<Customer>showpageinfosorted(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name){
		return cs.getbypagesorted(pageno, pagesize, name);
	}
	
}

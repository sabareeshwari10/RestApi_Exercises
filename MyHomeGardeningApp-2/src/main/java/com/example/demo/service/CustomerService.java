package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;


@Service
public class CustomerService {
	@Autowired
	CustomerRepo cr;
	public Customer saveinfo(Customer c) {
		return cr.save(c);
	}
	public List<Customer> savedetails(List<Customer> c){
		return (List<Customer>)cr.saveAll(c);
	}
	public List<Customer> showinfo(){
		return cr.findAll();
	}
	public void deleteid(int id) {
		cr.deleteById(id);
	}
	public Customer changeinfo(Customer c) {
		return cr.saveAndFlush(c);
	}
	
	public String updateinfobyid(int id,Customer c) {
		cr.saveAndFlush(c);
		if(cr.existsById(id)) {
			return "UPDATED";
		}
		else {
			return "Enter valid id";
		}
	}
	public Customer savecustomerdetails(Customer c) {
		return cr.save(c);
	}
	public List<Customer> showcustomerinfo(){
		return cr.findAll();
	}
	public List<Customer> sortinfo(String s){
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	public List<Customer> getbypage(int pgno,int pgsize){
		Page<Customer> p = cr.findAll(PageRequest.of(pgno, pgsize));
			return p.getContent();
		
	}
	public List<Customer> getbypagesorted(int pgno,int pgsize,String s){
		Page<Customer> p = cr.findAll(PageRequest.of(pgno, pgsize,Sort.by(Sort.DEFAULT_DIRECTION,s)));
			return p.getContent();
		
	}

}

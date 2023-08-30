package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class Apiservice {
	@Autowired
	ChildRepo cr;
	
	public Child saveinfo(Child ss) {
		return cr.save(ss);
	}
	public List<Child> sortinfo(String s){
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	public List<Child> getbypage(int pgno,int pgsize){
		Page<Child> p = cr.findAll(PageRequest.of(pgno, pgsize));
			return p.getContent();		
	}
	public List<Child> getbypagesorted(int pgno,int pgsize,String s){
		Page<Child> p = cr.findAll(PageRequest.of(pgno, pgsize,Sort.by(Sort.DEFAULT_DIRECTION,s)));
			return p.getContent();
		
	}
}

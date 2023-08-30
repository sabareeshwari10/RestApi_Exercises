package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepo;


public class ApiService {
	
	@Autowired
	CarRepo cr;
	public List<Car>getcar(int i,String s){
		return cr.getCarInfo(i,s);
	}
	public int delcar(int id) {
		return cr.deleteCarinfo(id);
		
	}
	public int updatecar(int id,int id1) {
		return cr.updateCarInfo(id, id1);
	}

}

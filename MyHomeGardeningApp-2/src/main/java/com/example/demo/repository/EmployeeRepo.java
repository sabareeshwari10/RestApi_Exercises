package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

import jakarta.transaction.Transactional;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	@Query(value="select * from employeetable where empid=:s OR empname=:sn",nativeQuery=true)
	public List<Employee>getEmployeeInfo(@Param("s") int empid,@Param("sn") String empname);
	
	@Modifying
	@Transactional
	@Query(value="delete from employeetable where empid=:s", nativeQuery=true)
	public int deleteEmployeeinfo(@Param("s")int empid);
	
	@Modifying
	@Transactional
	@Query(value="update employeetable set empid=?1 where empid=?2",nativeQuery=true)
	public int updateEmployeeInfo(int newid,int oldid);
	

}
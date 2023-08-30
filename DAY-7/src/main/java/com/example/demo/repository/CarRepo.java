package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Car;

import jakarta.transaction.Transactional;

public interface CarRepo extends JpaRepository<Car, Integer>{
	@Query(value="select *from cartable where id=:s or name=:sn",nativeQuery=true)
	public List<Car>getCarInfo(@Param("s") int id,@Param("sn") String carName);
	
	@Modifying
	@Transactional
	@Query(value="delete from cartable where id=:s", nativeQuery=true)
	public int deleteCarinfo(@Param("s")int id);
	
	@Modifying
	@Transactional
	@Query(value="update cartable set id=?1 where id=?2",nativeQuery=true)
	public int updateCarInfo(int newid,int oldid);
	


}

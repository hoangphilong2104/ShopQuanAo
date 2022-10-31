package com.hcmue.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.shop.entity.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer>{
	
	@Query("SELECT b FROM HoaDon b ORDER BY b.MaHD DESC")
	List<HoaDon> findByIdDesc();
}

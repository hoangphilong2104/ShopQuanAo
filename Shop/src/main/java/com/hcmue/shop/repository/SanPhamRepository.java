package com.hcmue.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.shop.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{
	
}

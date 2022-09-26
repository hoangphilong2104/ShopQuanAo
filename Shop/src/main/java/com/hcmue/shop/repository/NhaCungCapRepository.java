package com.hcmue.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcmue.shop.entity.NhaCungCap;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer>{
	
}

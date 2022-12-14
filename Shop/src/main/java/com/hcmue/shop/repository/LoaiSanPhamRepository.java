package com.hcmue.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.shop.entity.LoaiSanPham;


@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Integer>{
	@Query("SELECT p FROM LoaiSanPham p WHERE p.Slug = ?1")
	LoaiSanPham getBySlug(String slug);
	
}

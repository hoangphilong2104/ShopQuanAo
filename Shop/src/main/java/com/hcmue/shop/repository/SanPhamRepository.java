package com.hcmue.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.shop.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{

	@Query("SELECT p FROM SanPham p WHERE p.TrangThai = true")
	public Page<SanPham> findAllSanPham(Pageable pageable);
	
}

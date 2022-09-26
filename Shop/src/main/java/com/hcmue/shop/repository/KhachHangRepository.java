package com.hcmue.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.shop.entity.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>{
	@Query("SELECT a FROM KhachHang a WHERE a.TaiKhoan = ?1")
	KhachHang findByTaiKhoan(String TaiKhoan);
}

package com.hcmue.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcmue.shop.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{

	@Query("SELECT p FROM SanPham p WHERE p.TrangThai = true")
	public Page<SanPham> findAllSanPham(Pageable pageable);

	@Query("SELECT p FROM SanPham p WHERE p.TrangThai = true and p.MaLoaiSP = :id")
	public Page<SanPham> findAllSanPham(PageRequest pageable,@Param("id") int id);
	
	@Query("SELECT p FROM SanPham p WHERE p.TrangThai = true and p.GioiTinh = :GioiTinh")
	public Page<SanPham> findAllSanPhamGT(PageRequest pageable,@Param("GioiTinh") String gioiTinh);
	
	//@Query("SELECT p FROM SanPham p WHERE p.slug LIKE %:s%")
	@Query(value ="SELECT * FROM sanpham WHERE slug LIKE %:s% ",nativeQuery = true)
	public Page<SanPham> searchSanPham(PageRequest pageable,@Param("s") String s);
	
}

package com.hcmue.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.shop.model.LoaiSanPhamModel;

@Entity
@Table(name = "loaisanpham")
public class LoaiSanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaLoaiSP;
	
	@Column(name = "TenLoaiSP")
	private String TenLoaiSP;
	
	@Column(name = "Slug")
	private String Slug;
	
	@Column(name = "TrangThai")
	private Boolean TrangThai;
	
	public int getMaLoaiSP() {
		return MaLoaiSP;
	}

	public String getTenLoaiSP() {
		return TenLoaiSP;
	}

	public String getSlug() {
		return Slug;
	}
	
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public LoaiSanPham(LoaiSanPhamModel l) {
		MaLoaiSP = l.getMaLoaiSP();
		TenLoaiSP = l.getTenLoaiSP();
		Slug = l.getSlug();
		TrangThai = l.getTrangThai();
	}

	public LoaiSanPham() {
		this.TrangThai = true;
	}
	
}

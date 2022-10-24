package com.hcmue.shop.model;

import com.hcmue.shop.entity.LoaiSanPham;

public class LoaiSanPhamModel {
	
	private int MaLoaiSP;
	
	private String TenLoaiSP;
	
	private String Slug;
	
	private Boolean TrangThai;
	
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}

	public int getMaLoaiSP() {
		return MaLoaiSP;
	}

	public void setMaLoaiSP(int maLoaiSP) {
		MaLoaiSP = maLoaiSP;
	}

	public String getTenLoaiSP() {
		return TenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		TenLoaiSP = tenLoaiSP;
	}

	public String getSlug() {
		return Slug;
	}

	public void setSlug(String slug) {
		Slug = slug;
	}

	public LoaiSanPhamModel(LoaiSanPham l) {
		MaLoaiSP = l.getMaLoaiSP();
		TenLoaiSP = l.getTenLoaiSP();
		Slug = l.getSlug();
		TrangThai = l.getTrangThai();
	}
	
	public LoaiSanPhamModel() {
		this.TrangThai = true;
	}


}

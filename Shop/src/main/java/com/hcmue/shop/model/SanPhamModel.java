package com.hcmue.shop.model;

import com.hcmue.shop.entity.SanPham;

public class SanPhamModel {
	
	private int MaSP;
	
	private String TenSP;
	
	private String MoTa;
	
	private String GioiTinh;
	
	private double GiaBan;
	
	private double GiaNhap;
	
	private String Anh;
	
	private String Slug;
	
	private int MaLoaiSP;
	
	private int MaNCC;
	
	private int SoLuongTon;

	private Boolean TrangThai;
	
	public int getMaSP() {
		return MaSP;
	}
	
	public void setMaSP(int maSP) {
		MaSP = maSP;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public double getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}

	public double getGiaNhap() {
		return GiaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		GiaNhap = giaNhap;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
	}

	public String getSlug() {
		return Slug;
	}

	public void setSlug(String slug) {
		Slug = slug;
	}

	public int getMaLoaiSP() {
		return MaLoaiSP;
	}

	public void setMaLoaiSP(int maLoaiSP) {
		MaLoaiSP = maLoaiSP;
	}

	public int getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}

	public int getSoLuongTon() {
		return SoLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		SoLuongTon = soLuongTon;
	}
	
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}

	public SanPhamModel(SanPham s) {
		MaSP = s.getMaSP();
		TenSP = s.getTenSP();
		MoTa = s.getMoTa();
		GioiTinh = s.getGioiTinh();
		GiaBan = s.getGiaBan();
		GiaNhap = s.getGiaNhap();
		Anh = s.getAnh();
		Slug = s.getSlug();
		MaLoaiSP = s.getMaLoaiSP();
		MaNCC = s.getMaNCC();
		SoLuongTon = s.getSoLuongTon();
		TrangThai = s.getTrangThai();
	}
	
	public SanPhamModel() {
		this.TrangThai = true;
	}
}

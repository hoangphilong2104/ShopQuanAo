package com.hcmue.shop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.shop.model.SanPhamModel;


@Entity
@Table(name = "sanpham")
public class SanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaSP;
	
	@Column(name = "TenSP")
	private String TenSP;
	
	@Column(name = "MoTa")
	private String MoTa;
	
	@Column(name = "GioiTinh")
	private String GioiTinh;
	
	@Column(name = "GiaBan")
	private double GiaBan;
	
	@Column(name = "GiaNhap")
	private double GiaNhap;
	
	@Column(name = "Anh")
	private String Anh;
	
	@Column(name = "Slug")
	private String Slug;
	
	@Column(name = "MaLoaiSP")
	private int MaLoaiSP;
	
	@Column(name = "MaNCC")
	private int MaNCC;
	
	@Column(name = "SoLuongTon")
	private int SoLuongTon;
	
	@Column(name = "TrangThai")
	private Boolean TrangThai;
	
	public int getMaSP() {
		return MaSP;
	}

	public String getTenSP() {
		return TenSP;
	}

	public String getMoTa() {
		return MoTa;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public double getGiaBan() {
		return GiaBan;
	}

	public double getGiaNhap() {
		return GiaNhap;
	}

	public String getAnh() {
		return Anh;
	}

	public String getSlug() {
		return Slug;
	}

	public int getMaLoaiSP() {
		return MaLoaiSP;
	}

	public int getMaNCC() {
		return MaNCC;
	}

	public int getSoLuongTon() {
		return SoLuongTon;
	}

	public Boolean getTrangThai() {
		return TrangThai;
	}

	public SanPham(SanPhamModel s) {
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

	public SanPham() {
	}

	@Override
	public String toString() {
		return "SanPham [MaSP=" + MaSP + ", TenSP=" + TenSP + ", MoTa=" + MoTa + ", GioiTinh=" + GioiTinh + ", GiaBan="
				+ GiaBan + ", GiaNhap=" + GiaNhap + ", Anh=" + Anh + ", Slug=" + Slug + ", MaLoaiSP=" + MaLoaiSP
				+ ", MaNCC=" + MaNCC + ", SoLuongTon=" + SoLuongTon + ", TrangThai=" + TrangThai + "]";
	}
	
	
}

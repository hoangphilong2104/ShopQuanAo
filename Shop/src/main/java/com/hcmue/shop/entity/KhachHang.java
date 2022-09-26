package com.hcmue.shop.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.hcmue.shop.model.KhachHangModel;

@Entity
@Table(name = "khachhang")
public class KhachHang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaKH;

	@Column(name = "TenKH")
	private String TenKH;

	@Column(name = "GioiTinh")
	private String GioiTinh;
	
	@Column(name = "TaiKhoan")
	private String TaiKhoan;
	
	@Column(name = "MatKhau", unique = true)
	private String MatKhau;
	
	@Column(name = "DiaChi")
	private String DiaChi;
	
	@Column(name = "Email", unique = true)
	private String Email;
	
	@Column(name = "SDT")
	private String SDT;
	
	@CreationTimestamp
	@Column(name = "NgaySinh")
	private Timestamp NgaySinh;
	
	@Column(name = "TrangThai")
	private Boolean TrangThai;
	
	public int getMaKH() {
		return MaKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public String getEmail() {
		return Email;
	}

	public Timestamp getNgaySinh() {
		return NgaySinh;
	}

	public Boolean getTrangThai() {
		return TrangThai;
	}

	public String getSDT() {
		return SDT;
	}

	public KhachHang(KhachHangModel k) {
		MaKH = k.getMaKH();
		TenKH = k.getTenKH();
		GioiTinh = k.getGioiTinh();
		TaiKhoan = k.getTaiKhoan();
		MatKhau = k.getMatKhau();
		DiaChi = k.getDiaChi();
		Email = k.getEmail();
		NgaySinh = k.getNgaySinh();
		SDT = k.getSDT();
		TrangThai = k.getTrangThai();
	}
	
	public KhachHang() {
	}

	@Override
	public String toString() {
		return "KhachHang [MaKH=" + MaKH + ", TenKH=" + TenKH + ", GioiTinh=" + GioiTinh + ", TaiKhoan=" + TaiKhoan
				+ ", MatKhau=" + MatKhau + ", DiaChi=" + DiaChi + ", Email=" + Email + ", NgaySinh=" + NgaySinh
				+ ", TrangThai=" + TrangThai + "]";
	}
	
	
}

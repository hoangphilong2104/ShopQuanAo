package com.hcmue.shop.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import com.hcmue.shop.entity.KhachHang;

public class KhachHangModel {
	
	private int MaKH;

	private String TenKH;

	private String GioiTinh;
	
	private String TaiKhoan;
	
	private String MatKhau;
	
	private String DiaChi;
	
	private String Email;
	
	private Timestamp NgaySinh;
	
	private String SDT;
	
	private Boolean TrangThai;
	
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}

	public int getMaKH() {
		return MaKH;
	}

	public void setMaKH(int maKH) {
		MaKH = maKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Timestamp getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Timestamp ngaySinh) {
		NgaySinh = ngaySinh;
	}
	
	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public KhachHangModel() {
		this.TrangThai = true;
		Date date = new Date();
		this.NgaySinh = new Timestamp(date.getTime());
	}
	
	public KhachHangModel(KhachHang k) {
		MaKH = k.getMaKH();
		TenKH = k.getTenKH();
		GioiTinh = k.getGioiTinh();
		TaiKhoan = k.getTaiKhoan();
		MatKhau = k.getMatKhau();
		DiaChi = k.getDiaChi();
		Email = k.getEmail();
		NgaySinh = k.getNgaySinh();
		TrangThai = k.getTrangThai();
		SDT = k.getSDT();
	}
}

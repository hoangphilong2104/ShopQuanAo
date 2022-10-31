package com.hcmue.shop.model;

import com.hcmue.shop.entity.ChiTietHoaDon;

public class ChiTietHoaDonModel {
	
	private int MaCTHD;
	
	private int MaHD;
	
	private int MaSP;
	
	private double DonGia;
	
	private int SoLuong;

	public int getMaHD() {
		return MaHD;
	}

	public void setMaHD(int maHD) {
		MaHD = maHD;
	}

	public int getMaSP() {
		return MaSP;
	}

	public void setMaSP(int maSP) {
		MaSP = maSP;
	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		DonGia = donGia;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	
	public ChiTietHoaDonModel(ChiTietHoaDon c) {
		MaCTHD = c.getMaCTHD();
		MaHD = c.getMaHD();
		MaSP = c.getMaSP();
		DonGia = c.getDonGia();
		SoLuong = c.getSoLuong();
	}
	
	public ChiTietHoaDonModel(HoaDonModel c) {
		MaHD = c.getMaHD();
	}
	
	public ChiTietHoaDonModel() {
	}

	public int getMaCTHD() {
		return MaCTHD;
	}

	public void setMaCTHD(int maCTHD) {
		MaCTHD = maCTHD;
	}
	
	
}

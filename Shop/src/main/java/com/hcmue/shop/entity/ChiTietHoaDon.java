package com.hcmue.shop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.shop.model.ChiTietHoaDonModel;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
	
	@Id
	private int MaHD;
	
	@Column(name = "MaSP")
	private int MaSP;
	
	@Column(name = "DonGia")
	private double DonGia;
	
	@Column(name = "SoLuong")
	private int SoLuong;

	public int getMaHD() {
		return MaHD;
	}

	public int getMaSP() {
		return MaSP;
	}

	public double getDonGia() {
		return DonGia;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public ChiTietHoaDon(ChiTietHoaDonModel c) {
		MaHD = c.getMaHD();
		MaSP = c.getMaSP();
		DonGia = c.getDonGia();
		SoLuong = c.getSoLuong();
	}

	public ChiTietHoaDon() {
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [MaHD=" + MaHD + ", MaSP=" + MaSP + ", DonGia=" + DonGia + ", SoLuong=" + SoLuong + "]";
	}
	
	
}

package com.hcmue.shop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.shop.model.ChiTietHoaDonModel;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaCTHD;
	
	@Column(name = "MaHD")
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
	
	public int getMaCTHD() {
		return MaCTHD;
	}

	public ChiTietHoaDon(ChiTietHoaDonModel c) {
		MaCTHD = c.getMaCTHD();
		MaHD = c.getMaHD();
		MaSP = c.getMaSP();
		DonGia = c.getDonGia();
		SoLuong = c.getSoLuong();
	}

	public ChiTietHoaDon() {
	}
	
	
}

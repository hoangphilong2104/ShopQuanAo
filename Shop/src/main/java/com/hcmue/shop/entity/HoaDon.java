package com.hcmue.shop.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.shop.model.HoaDonModel;

@Entity
@Table(name = "hoadon")
public class HoaDon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaHD;
	
	@Column(name = "NgayDat")
	private Timestamp NgayDat;
	
	@Column(name = "NgayGiao")
	private Timestamp NgayGiao;
	
	@Column(name = "TinhTrang")
	private String TinhTrang;
	
	@Column(name = "MaKH")
	private int MaKH;
	
	@Column(name = "DonGia")
	private double DonGia; 
	
	public int getMaHD() {
		return MaHD;
	}

	public Timestamp getNgayDat() {
		return NgayDat;
	}

	public Timestamp getNgayGiao() {
		return NgayGiao;
	}

	public String getTinhTrang() {
		return TinhTrang;
	}

	public int getMaKH() {
		return MaKH;
	}

	public HoaDon(HoaDonModel h) {
		MaHD = h.getMaHD();
		NgayDat = h.getNgayDat();
		NgayGiao = h.getNgayGiao();
		TinhTrang = h.getTinhTrang();
		MaKH = h.getMaKH();
		DonGia = h.getDonGia();
	}

	public HoaDon() {
	}

	public double getDonGia() {
		return DonGia;
	}
	
}

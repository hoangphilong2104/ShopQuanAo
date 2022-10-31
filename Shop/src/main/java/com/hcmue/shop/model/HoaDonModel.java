package com.hcmue.shop.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;

import com.hcmue.shop.entity.HoaDon;

public class HoaDonModel {
	
	private int MaHD;
	
	private Timestamp NgayDat;
	
	private Timestamp NgayGiao;
	
	private String TinhTrang;
	
	private int MaKH;
	
	private double DonGia;
	
	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		DonGia = donGia;
	}

	public int getMaHD() {
		return MaHD;
	}

	public void setMaHD(int maHD) {
		MaHD = maHD;
	}

	public Timestamp getNgayDat() {
		return NgayDat;
	}

	public void setNgayDat(Timestamp ngayDat) {
		NgayDat = ngayDat;
	}

	public Timestamp getNgayGiao() {
		return NgayGiao;
	}

	public void setNgayGiao(Timestamp ngayGiao) {
		NgayGiao = ngayGiao;
	}

	public String getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public int getMaKH() {
		return MaKH;
	}

	public void setMaKH(int maKH) {
		MaKH = maKH;
	}

	public HoaDonModel(HoaDon h) {
		MaHD = h.getMaHD();
		NgayDat = h.getNgayDat();
		NgayGiao = h.getNgayGiao();
		TinhTrang = h.getTinhTrang();
		MaKH = h.getMaKH();
		DonGia = h.getDonGia();
	}
	
	public HoaDonModel() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +7);
		this.NgayDat = new Timestamp(date.getTime());
		this.NgayGiao = new Timestamp(cal.getTime().getTime());
	}
}
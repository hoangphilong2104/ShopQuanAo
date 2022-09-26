package com.hcmue.shop.model;

import java.sql.Timestamp;

import com.hcmue.shop.entity.HoaDon;

public class HoaDonModel {
	
	private int MaHD;
	
	private Timestamp NgayDat;
	
	private Timestamp NgayGiao;
	
	private String TinhTrang;
	
	private int MaKH;

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
	}
}
package com.hcmue.shop.model;

import com.hcmue.shop.entity.NhaCungCap;

public class NhaCungCapModel {
	
	private int MaNCC;
	
	private String TenNCC;
	
	private String DiaChi;
	
	private String SDT;

	private Boolean TrangThai;
	
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}

	public int getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}

	public String getTenNCC() {
		return TenNCC;
	}

	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	public NhaCungCapModel(NhaCungCap n) {
		MaNCC = n.getMaNCC();
		TenNCC = n.getTenNCC();
		DiaChi = n.getDiaChi();
		SDT = n.getSDT();
		TrangThai = n.getTrangThai();
	}
	
	public NhaCungCapModel() {
		this.TrangThai = true;
	}
	
}

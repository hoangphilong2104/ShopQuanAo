package com.hcmue.shop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.shop.model.NhaCungCapModel;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaNCC;
	
	@Column(name = "TenNCC")
	private String TenNCC;
	
	@Column(name = "DiaChi")
	private String DiaChi;
	
	@Column(name = "SDT")
	private String SDT;
	
	@Column(name = "TrangThai")
	private Boolean TrangThai;
	
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public int getMaNCC() {
		return MaNCC;
	}

	public String getTenNCC() {
		return TenNCC;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public NhaCungCap(NhaCungCapModel n) {
		MaNCC = n.getMaNCC();
		TenNCC = n.getTenNCC();
		DiaChi = n.getDiaChi();
		SDT = n.getSDT();
		TrangThai = n.getTrangThai();
	}

	public NhaCungCap() {
	}

	@Override
	public String toString() {
		return "NhaCungCap [MaNCC=" + MaNCC + ", TenNCC=" + TenNCC + ", DiaChi=" + DiaChi + ", SDT=" + SDT
				+ ", TrangThai=" + TrangThai + "]";
	}
	
	
}

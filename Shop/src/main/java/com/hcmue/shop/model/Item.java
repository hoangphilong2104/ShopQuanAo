package com.hcmue.shop.model;

public class Item {
	private SanPhamModel sanPham;
	
	private int quantity;

	public SanPhamModel getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPhamModel sanPham) {
		this.sanPham = sanPham;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item(SanPhamModel sanPham, int quantity) {
		super();
		this.sanPham = sanPham;
		this.quantity = quantity;
	}
	
	
}

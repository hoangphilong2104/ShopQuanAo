package com.hcmue.shop.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hcmue.shop.entity.KhachHang;

public class TaiKhoanDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KhachHang khachHang;
	
	public TaiKhoanDetails(KhachHang khachHang) {
		this.khachHang=khachHang;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return khachHang.getMatKhau();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return khachHang.getTaiKhoan();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getFullName() {
		return khachHang.getTenKH();
	}
	
	
}

package com.hcmue.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hcmue.shop.entity.KhachHang;
import com.hcmue.shop.repository.KhachHangRepository;

public class TaiKhoanServices implements UserDetailsService{
	
	@Autowired
    private KhachHangRepository repo;
     
    @Override
    public UserDetails loadUserByUsername(String TaiKhoan) throws UsernameNotFoundException {
        KhachHang khachHang = repo.findByTaiKhoan(TaiKhoan);
        System.err.println(">>>>>>>>>>>>>>>> "+ khachHang +" <<<<<<<<<<<<<<");
        if (khachHang == null) {
            throw new UsernameNotFoundException("Tai Khoan Khong Tim Thay");
        }
        return new TaiKhoanDetails(khachHang);
    }
 
}
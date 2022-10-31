package com.hcmue.shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcmue.shop.entity.KhachHang;
import com.hcmue.shop.model.KhachHangModel;
import com.hcmue.shop.repository.KhachHangRepository;

@Service
public class KhachHangServices implements Services<KhachHangModel>{
	
	@Autowired
	private KhachHangRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<KhachHangModel> listAll() {
		List<KhachHang> listAll = repo.findAll();
		List<KhachHangModel> list = listAll.stream()
				.map(KhachHang -> new KhachHangModel(KhachHang))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<KhachHangModel> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KhachHangModel> listByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHangModel findOne(int id) {
		KhachHang s = repo.getById(id);
		if(s!=null) {
			KhachHangModel khachHangModel = new KhachHangModel(s);
			return khachHangModel;
		}
		return null;
	}
	
	public KhachHangModel findOne(String username) {
		KhachHang s = repo.findByTaiKhoan(username);
		if(s!=null) {
			KhachHangModel khachHangModel = new KhachHangModel(s);
			return khachHangModel;
		}
		return null;
	}
	
	@Override
	public void save(KhachHangModel t) {
		if(t!= null) {
			KhachHang s= new KhachHang(t);
			repo.save(s);
		}
	}

	@Override
	public void delete(int id) {
		KhachHangModel s = findOne(id);
		s.setTrangThai(false);
		save(s);
		
	}

	public boolean register(KhachHangModel t, String MatKhauXN) {
		if(!t.getMatKhau().equals(MatKhauXN)) {
			return false;
		}
		
		if(t.getTaiKhoan().equals("admin")) {
			return false;
		}
		KhachHangModel k = findOne(t.getTaiKhoan());
		if(k != null) {
			return false;
		}
		try {
			if(t != null) {
				passwordEncoder = new BCryptPasswordEncoder();
				t.setMatKhau(passwordEncoder.encode(t.getMatKhau()));
				save(t);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
 
}
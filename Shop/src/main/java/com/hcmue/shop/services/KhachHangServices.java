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

	public void register(KhachHangModel t) {
		if(t != null) {
			passwordEncoder = new BCryptPasswordEncoder();
			t.setMatKhau(passwordEncoder.encode(t.getMatKhau()));
			save(t);
		}
	}
 
}
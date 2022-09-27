package com.hcmue.shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.shop.entity.SanPham;
import com.hcmue.shop.model.SanPhamModel;
import com.hcmue.shop.repository.SanPhamRepository;

@Service
public class SanPhamServices implements Services<SanPhamModel>{
	
	@Autowired
	private SanPhamRepository repo;
	
	@Override
	public List<SanPhamModel> listAll() {
		List<SanPham> listAll = repo.findAll();
		List<SanPhamModel> list = listAll.stream()
				.map(SanPham -> new SanPhamModel(SanPham))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<SanPhamModel> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPhamModel> listByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPhamModel findOne(int id) {
		SanPham s = repo.getById(id);
		if(s != null) {
			SanPhamModel sanPhamModel = new SanPhamModel(s);
			return sanPhamModel;
		}
		return null;
	}

	@Override
	public void save(SanPhamModel t) {
		if(t != null) {
			SanPham s = new SanPham(t);
			repo.save(s);
		}
	}

	@Override
	public void delete(int id) {
		SanPhamModel s = findOne(id);
		s.setTrangThai(false);
		save(s);
	}
 
}
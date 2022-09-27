package com.hcmue.shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.shop.entity.LoaiSanPham;
import com.hcmue.shop.model.LoaiSanPhamModel;
import com.hcmue.shop.repository.LoaiSanPhamRepository;

@Service
public class LoaiSanPhamServices implements Services<LoaiSanPhamModel>{
	
	@Autowired
	private LoaiSanPhamRepository repo;
	
	@Override
	public List<LoaiSanPhamModel> listAll() {
		List<LoaiSanPham> listAll = repo.findAll();
		List<LoaiSanPhamModel> list = listAll.stream()
				.map(LoaiSanPham -> new LoaiSanPhamModel(LoaiSanPham))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<LoaiSanPhamModel> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoaiSanPhamModel> listByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoaiSanPhamModel findOne(int id) {
		LoaiSanPham s = repo.getById(id);
		if(s != null) {
			LoaiSanPhamModel loaiSanPhamModel = new LoaiSanPhamModel(s);
			return loaiSanPhamModel;
		}
		return null;
	}

	@Override
	public void save(LoaiSanPhamModel t) {
		if(t != null) {
			LoaiSanPham s = new LoaiSanPham(t);
			repo.save(s);
		}
	}

	@Override
	public void delete(int id) {
		LoaiSanPhamModel s = findOne(id);
		s.setTrangThai(false);
		save(s);
	}
 
}
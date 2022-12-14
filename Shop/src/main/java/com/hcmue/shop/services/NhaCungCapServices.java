package com.hcmue.shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.shop.entity.NhaCungCap;
import com.hcmue.shop.model.NhaCungCapModel;
import com.hcmue.shop.repository.NhaCungCapRepository;

@Service
public class NhaCungCapServices implements Services<NhaCungCapModel>{
	
	@Autowired
	private NhaCungCapRepository repo;
	
	@Override
	public List<NhaCungCapModel> listAll() {
		List<NhaCungCap> listAll = repo.findAll();
		List<NhaCungCapModel> list = listAll.stream()
				.map(NhaCungCap -> new NhaCungCapModel(NhaCungCap))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<NhaCungCapModel> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhaCungCapModel> listByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhaCungCapModel findOne(int id) {
		NhaCungCap s = repo.getById(id);
		if(s != null) {
			NhaCungCapModel nhaCungCapModel = new NhaCungCapModel(s);
			return nhaCungCapModel;
		}
		return null;
	}

	@Override
	public void save(NhaCungCapModel t) {
		if(t != null) {
			NhaCungCap s = new NhaCungCap(t);
			repo.save(s);
		}
	}

	@Override
	public void delete(int id) {
		NhaCungCapModel s = findOne(id);
		s.setTrangThai(false);
		save(s);
		
	}
 
}
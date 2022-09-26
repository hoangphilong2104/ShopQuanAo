package com.hcmue.shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.shop.entity.HoaDon;
import com.hcmue.shop.model.HoaDonModel;
import com.hcmue.shop.repository.HoaDonRepository;

@Service
public class HoaDonServices implements Services<HoaDonModel>{
	
	@Autowired
	private HoaDonRepository repo;
	
	@Override
	public List<HoaDonModel> listAll() {
		List<HoaDon> listAll = repo.findAll();
		List<HoaDonModel> list = listAll.stream()
				.map(HoaDon -> new HoaDonModel(HoaDon))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<HoaDonModel> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoaDonModel> listByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDonModel findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(HoaDonModel t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
 
}
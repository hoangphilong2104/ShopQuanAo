package com.hcmue.shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.shop.entity.ChiTietHoaDon;
import com.hcmue.shop.model.ChiTietHoaDonModel;
import com.hcmue.shop.repository.ChiTietHoaDonRepository;

@Service
public class ChiTietHoaDonServices implements Services<ChiTietHoaDonModel>{
	
	@Autowired
	private ChiTietHoaDonRepository repo;
	
	@Override
	public List<ChiTietHoaDonModel> listAll() {
		List<ChiTietHoaDon> listAll = repo.findAll();
		List<ChiTietHoaDonModel> list = listAll.stream()
				.map(ChiTietHoaDon -> new ChiTietHoaDonModel(ChiTietHoaDon))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<ChiTietHoaDonModel> listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietHoaDonModel> listByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietHoaDonModel findOne(int id) {
		ChiTietHoaDon s = repo.getById(id);
		if(s != null) {
			ChiTietHoaDonModel chiTietHoaDonModel = new ChiTietHoaDonModel(s);
			return chiTietHoaDonModel;
		}
		return null;
	}

	@Override
	public void save(ChiTietHoaDonModel t) {
		if(t != null) {
			ChiTietHoaDon s = new ChiTietHoaDon(t);
			repo.save(s);
		}
	}

	@Override
	public void delete(int id) {
		//Not have delete
	}
 
}
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
		HoaDon s = repo.getById(id);
		if(s != null) {
			HoaDonModel hoaDonModel = new HoaDonModel(s);
			return hoaDonModel;
		}
		return null;
	}

	@Override
	public void save(HoaDonModel t) {
		if(t != null) {
			HoaDon s = new HoaDon(t);
			repo.save(s);
		}
	}

	@Override
	public void delete(int id) {
		//Not have delete
	}
	
	public HoaDonModel findByIdDesc(){
		List<HoaDon> hoadon = repo.findByIdDesc();
		HoaDonModel hoaDonModel = new HoaDonModel(hoadon.get(0));
		return hoaDonModel;
	}
}
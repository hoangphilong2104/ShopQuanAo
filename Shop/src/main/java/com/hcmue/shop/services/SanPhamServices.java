package com.hcmue.shop.services;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Page<SanPham> getPaginated(PageRequest pageable) {
		Page<SanPham> list = repo.findAllSanPham(pageable);
		return list;
	}
	
	public Page<SanPham> getPaginated(PageRequest pageable,int id) {
		Page<SanPham> list = repo.findAllSanPham(pageable,id);
		return list;
	}
	
	public Page<SanPham> getPaginatedGT(PageRequest pageable,String GioiTinh) {
		Page<SanPham> list = repo.findAllSanPhamGT(pageable,GioiTinh);
		return list;
	}
	
	public Page<SanPham> search(PageRequest pageable, String s){
		s = unAccent(s.toLowerCase());
		s = s.replace(" ", "-");
		Page<SanPham> list = repo.searchSanPham(pageable,s);
		return list;
	}
	
	public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
	}
	
	public List<String> mota(String mota){
		List<String> motas = new ArrayList<String>();
		boolean status = true;
		while(status) {
			int i = mota.indexOf("<br>");
			if(i == -1) {
				status = false;
				motas.add(mota);
			}else {
				String temp = mota.substring(0,i);
				motas.add(temp);
				mota = mota.substring(i+4);
			}
		}
		return motas;
	}
}
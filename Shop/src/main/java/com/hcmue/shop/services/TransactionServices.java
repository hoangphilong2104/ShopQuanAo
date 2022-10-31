package com.hcmue.shop.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.shop.model.ChiTietHoaDonModel;
import com.hcmue.shop.model.TransactionModel;

@Service
public class TransactionServices{
	
	@Autowired
	private ChiTietHoaDonServices chiTietHoaDonServices;
	
	@Autowired
	private SanPhamServices sanPhamServices;
	
	public List<TransactionModel> listAll(){
		List<ChiTietHoaDonModel> listCTHD = chiTietHoaDonServices.listAll();
		List<TransactionModel> listTransaction= new ArrayList<TransactionModel>();
		int id = 1;
		for(int i=0;i<listCTHD.size();i++) {
			if(i == 0) {
				TransactionModel t = new TransactionModel();
				t.setAmount(listCTHD.get(i).getSoLuong());
				t.setId(id);
				id++;
				t.setPurpose(sanPhamServices.findOne(listCTHD.get(i).getMaSP()).getTenSP());
				listTransaction.add(t);
			}else{
				for(int j=0;j<listTransaction.size();j++) {
					if(listTransaction.get(j).getPurpose().equals(sanPhamServices.findOne(listCTHD.get(i).getMaSP()).getTenSP())){
						listTransaction.get(j).setAmount(listTransaction.get(j).getAmount()+listCTHD.get(i).getSoLuong());
						break;
					}else {
						if(listTransaction.size() == (j+1)) {
							TransactionModel t = new TransactionModel();
							t.setAmount(listCTHD.get(i).getSoLuong());
							t.setId(id);
							id++;
							t.setPurpose(sanPhamServices.findOne(listCTHD.get(i).getMaSP()).getTenSP());
							listTransaction.add(t);
							break;
						}
					}
				}
			}
		}
		
		for(int i=0;i<listTransaction.size();i++) {
			System.err.println(listTransaction.get(i));
		}
		
		return listTransaction;
	}
}

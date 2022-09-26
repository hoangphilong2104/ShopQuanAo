package com.hcmue.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.model.KhachHangModel;
import com.hcmue.shop.model.SanPhamModel;
import com.hcmue.shop.services.SanPhamServices;

@RestController
@RequestMapping(value = "/product")
public class SanPhamController {
	
	@Autowired
	private SanPhamServices ser;
	
	@RequestMapping(value = "")
	public ModelAndView SanPhamPage(Model model) {
		List<SanPhamModel> listItems = ser.listAll();
		model.addAttribute("listItems", listItems);
		return new ModelAndView("views/SanPham/show");
	}
	
}
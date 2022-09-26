package com.hcmue.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.entity.SanPham;
import com.hcmue.shop.model.SanPhamModel;
import com.hcmue.shop.services.ChiTietHoaDonServices;
import com.hcmue.shop.services.HoaDonServices;
import com.hcmue.shop.services.KhachHangServices;
import com.hcmue.shop.services.LoaiSanPhamServices;
import com.hcmue.shop.services.NhaCungCapServices;
import com.hcmue.shop.services.SanPhamServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ChiTietHoaDonServices chiTietHoaDonServices;
	
	@Autowired
	private HoaDonServices hoaDonServices;
	
	@Autowired
	private KhachHangServices khachHangServices;
	
	@Autowired
	private LoaiSanPhamServices loaiSanPhamServices;
	
	@Autowired
	private NhaCungCapServices nhaCungCapServices;
	
	@Autowired
	private SanPhamServices sanPhamServices;
	
	//Dash board
	@GetMapping("")
	public ModelAndView admin() {
		return new ModelAndView("admin/DashBoard");
	}
	
	/*
	 * No: 			1
	 * Class: 		ChiTietHoaDon
	 * Comment:		
	 * 
	 */
	
	
	/*
	 * No: 			2
	 * Class: 		HoaDon
	 * Comment:		
	 * 
	 */
	
	
	/*
	 * No: 			3
	 * Class: 		KhachHang
	 * Comment:		
	 * 
	 */
	
	
	/*
	 * No: 			4
	 * Class: 		LoaiSanPham
	 * Comment:		
	 * 
	 */
	
	
	/*
	 * No: 			5
	 * Class: 		NhaCungCap
	 * Comment:		
	 * 
	 */
	
	
	/*
	 * No: 			6
	 * Class: 		SanPham
	 * Comment:		
	 * 
	 */
	
	//show
	@GetMapping("/sanpham")
	public ModelAndView showSanPham(Model model) {
		List<SanPhamModel> list = sanPhamServices.listAll();
		model.addAttribute("listItems", list);
		return new ModelAndView("admin/SanPham/show");
	}
	
	//add
	@GetMapping("/sanpham/add")
	public ModelAndView addSanPham(Model model, @PathVariable("id") int id) {
		SanPhamModel sanPhamModel = new SanPhamModel();
		model.addAttribute("item",sanPhamModel);
		return new ModelAndView("admin/SanPham/add");
	}
	
	@PostMapping("/sanpham/add")
	public ModelAndView saveSanPham(Model model, @ModelAttribute("item") SanPhamModel sanPhamModel) {
		sanPhamServices.save(sanPhamModel);
		return new ModelAndView("redirect:/admin/sanpham");
	}
	
	//edit
	@GetMapping("/sanpham/edit/{id}")
	public ModelAndView editSanPham(Model model, @PathVariable("id") int id) {
		SanPhamModel sanPhamModel = sanPhamServices.findOne(id);
		model.addAttribute("item",sanPhamModel);
		return new ModelAndView("admin/SanPham/edit");
	}
	
	//delete
	@GetMapping("/sanpham/delete/{id}")
	public ModelAndView deleteSanPham(@PathVariable("id") int id) {
		sanPhamServices.delete(id);
	return new ModelAndView("redirect:/admin/sanpham");
}
	
	
}

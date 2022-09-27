package com.hcmue.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.model.ChiTietHoaDonModel;
import com.hcmue.shop.model.HoaDonModel;
import com.hcmue.shop.model.KhachHangModel;
import com.hcmue.shop.model.LoaiSanPhamModel;
import com.hcmue.shop.model.NhaCungCapModel;
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
	
	//show
	@GetMapping("/chitiethoadon")
	public ModelAndView showChiTietHoaDon(Model model) {
		List<ChiTietHoaDonModel> list = chiTietHoaDonServices.listAll();
		model.addAttribute("listItems", list);
		return new ModelAndView("admin/chitiethoadon/show");
	}
	
	//add
	@GetMapping("/chitiethoadon/add")
	public ModelAndView addChiTietHoaDon(Model model) {
		ChiTietHoaDonModel chiTietHoaDonModel = new ChiTietHoaDonModel();
		model.addAttribute("item",chiTietHoaDonModel);
		return new ModelAndView("admin/ChiTietHoaDon/add");
	}
	
	@PostMapping("/chitiethoadon/add")
	public ModelAndView saveChiTietHoaDon(Model model, @ModelAttribute("item") ChiTietHoaDonModel chiTietHoaDonModel) {
		chiTietHoaDonServices.save(chiTietHoaDonModel);
		return new ModelAndView("redirect:/admin/chitiethoadon");
	}
	
	//edit
	@GetMapping("/chitiethoadon/edit/{id}")
	public ModelAndView editChiTietHoaDon(Model model, @PathVariable("id") int id) {
		ChiTietHoaDonModel chiTietHoaDonModel = chiTietHoaDonServices.findOne(id);
		model.addAttribute("item",chiTietHoaDonModel);
		return new ModelAndView("admin/ChiTietHoaDon/edit");
	}
	
	//delete
	@GetMapping("/chitiethoadon/delete/{id}")
	public ModelAndView deleteChiTietHoaDon(@PathVariable("id") int id) {
		chiTietHoaDonServices.delete(id);
	return new ModelAndView("redirect:/admin/chitiethoadon");
	}
	
	/*
	 * No: 			2
	 * Class: 		HoaDon
	 * Comment:		
	 * 
	 */
	
	//show
	@GetMapping("/hoadon")
	public ModelAndView showHoaDon(Model model) {
		List<HoaDonModel> list = hoaDonServices.listAll();
		model.addAttribute("listItems", list);
		return new ModelAndView("admin/hoadon/show");
	}
	
	//add
	@GetMapping("/hoadon/add")
	public ModelAndView addHoaDon(Model model) {
		HoaDonModel hoaDonModel = new HoaDonModel();
		model.addAttribute("item",hoaDonModel);
		return new ModelAndView("admin/HoaDon/add");
	}
	
	@PostMapping("/hoadon/add")
	public ModelAndView saveHoaDon(Model model, @ModelAttribute("item") HoaDonModel hoaDonModel) {
		hoaDonServices.save(hoaDonModel);
		return new ModelAndView("redirect:/admin/hoadon");
	}
	
	//edit
	@GetMapping("/hoadon/edit/{id}")
	public ModelAndView editHoaDon(Model model, @PathVariable("id") int id) {
		HoaDonModel hoaDonModel = hoaDonServices.findOne(id);
		model.addAttribute("item",hoaDonModel);
		return new ModelAndView("admin/HoaDon/edit");
	}
	
	//delete
	@GetMapping("/hoadon/delete/{id}")
	public ModelAndView deleteHoaDon(@PathVariable("id") int id) {
		hoaDonServices.delete(id);
	return new ModelAndView("redirect:/admin/hoadon");
	}
	
	/*
	 * No: 			3
	 * Class: 		KhachHang
	 * Comment:		
	 * 
	 */
	
	//show
	@GetMapping("/khachhang")
	public ModelAndView showKhachHang(Model model) {
		List<KhachHangModel> list = khachHangServices.listAll();
		model.addAttribute("listItems", list);
		return new ModelAndView("admin/khachhang/show");
	}
	
	//add
	@GetMapping("/khachhang/add")
	public ModelAndView addKhachHang(Model model) {
		KhachHangModel khachHangModel = new KhachHangModel();
		model.addAttribute("item",khachHangModel);
		return new ModelAndView("admin/KhachHang/add");
	}
	
	@PostMapping("/khachhang/add")
	public ModelAndView saveKhachHang(Model model, @ModelAttribute("item") KhachHangModel khachHangModel) {
		khachHangServices.save(khachHangModel);
		return new ModelAndView("redirect:/admin/khachhang");
	}
	
	//edit
	@GetMapping("/khachhang/edit/{id}")
	public ModelAndView editKhachHang(Model model, @PathVariable("id") int id) {
		KhachHangModel khachHangModel = khachHangServices.findOne(id);
		model.addAttribute("item",khachHangModel);
		return new ModelAndView("admin/KhachHang/edit");
	}
	
	//delete
	@GetMapping("/khachhang/delete/{id}")
	public ModelAndView deleteKhachHang(@PathVariable("id") int id) {
		khachHangServices.delete(id);
	return new ModelAndView("redirect:/admin/khachhang");
	}
	
	/*
	 * No: 			4
	 * Class: 		LoaiSanPham
	 * Comment:		
	 * 
	 */
	
	//show
	@GetMapping("/loaisanpham")
	public ModelAndView showLoaiSanPham(Model model) {
		List<LoaiSanPhamModel> list = loaiSanPhamServices.listAll();
		model.addAttribute("listItems", list);
		return new ModelAndView("admin/LoaiSanPham/show");
	}
	
	//add
	@GetMapping("/loaisanpham/add")
	public ModelAndView addLoaiSanPham(Model model) {
		LoaiSanPhamModel loaiSanPhamModel = new LoaiSanPhamModel();
		model.addAttribute("item",loaiSanPhamModel);
		return new ModelAndView("admin/LoaiSanPham/add");
	}
	
	@PostMapping("/loaisanpham/add")
	public ModelAndView saveLoaiSanPham(Model model, @ModelAttribute("item") LoaiSanPhamModel loaiSanPhamModel) {
		loaiSanPhamServices.save(loaiSanPhamModel);
		return new ModelAndView("redirect:/admin/loaisanpham");
	}
	
	//edit
	@GetMapping("/loaisanpham/edit/{id}")
	public ModelAndView editLoaiSanPham(Model model, @PathVariable("id") int id) {
		LoaiSanPhamModel loaiSanPhamModel = loaiSanPhamServices.findOne(id);
		model.addAttribute("item",loaiSanPhamModel);
		return new ModelAndView("admin/LoaiSanPham/edit");
	}
	
	//delete
	@GetMapping("/loaisanpham/delete/{id}")
	public ModelAndView deleteLoaiSanPham(@PathVariable("id") int id) {
		loaiSanPhamServices.delete(id);
	return new ModelAndView("redirect:/admin/loaisanpham");
	}
	
	/*
	 * No: 			5
	 * Class: 		NhaCungCap
	 * Comment:		
	 * 
	 */
	
	//show
	@GetMapping("/nhacungcap")
	public ModelAndView showNhaCungCap(Model model) {
		List<NhaCungCapModel> list = nhaCungCapServices.listAll();
		model.addAttribute("listItems", list);
		return new ModelAndView("admin/NhaCungCap/show");
	}
	
	//add
	@GetMapping("/nhacungcap/add")
	public ModelAndView addNhaCungCap(Model model) {
		NhaCungCapModel nhaCungCapModel = new NhaCungCapModel();
		model.addAttribute("item",nhaCungCapModel);
		return new ModelAndView("admin/NhaCungCap/add");
	}
	
	@PostMapping("/nhacungcap/add")
	public ModelAndView saveNhaCungCap(Model model, @ModelAttribute("item") NhaCungCapModel nhaCungCapModel) {
		nhaCungCapServices.save(nhaCungCapModel);
		return new ModelAndView("redirect:/admin/nhacungcap");
	}
	
	//edit
	@GetMapping("/nhacungcap/edit/{id}")
	public ModelAndView editNhaCungCap(Model model, @PathVariable("id") int id) {
		NhaCungCapModel nhaCungCapModel = nhaCungCapServices.findOne(id);
		model.addAttribute("item",nhaCungCapModel);
		return new ModelAndView("admin/NhaCungCap/edit");
	}
	
	//delete
	@GetMapping("/nhacungcap/delete/{id}")
	public ModelAndView deleteNhaCungCap(@PathVariable("id") int id) {
		nhaCungCapServices.delete(id);
	return new ModelAndView("redirect:/admin/nhacungcap");
	}
	
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
	public ModelAndView addSanPham(Model model) {
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

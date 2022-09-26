package com.hcmue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.model.KhachHangModel;
import com.hcmue.shop.services.KhachHangServices;

@RestController
public class HomeController {
	
	@Autowired
	private KhachHangServices khachHangServices;
	
	//Home Page
	@RequestMapping(value = "")
	public ModelAndView userHomePage() {
		return new ModelAndView("views/TrangChu");
	}
	
	//Login
	@GetMapping(value = "/login")
	public ModelAndView loginPage(Model model) {
		model.addAttribute("khachHang", new KhachHangModel());
		return new ModelAndView("views/Login");
	}
	
	//Register
	@GetMapping(value = "/register")
	public ModelAndView registerPage(Model model) {
		model.addAttribute("khachHang", new KhachHangModel());
		return new ModelAndView("views/Register");
	}
	
	//Register
	@PostMapping(value = "/register")
	public ModelAndView registerProcessPage(Model model, @ModelAttribute("khachHang") KhachHangModel khachHang) {
		System.err.println("<<<<<<<<<<>>>>>>>>>>>> Register");
		khachHangServices.save(khachHang);
		return new ModelAndView("redirect:/login");
	}
}
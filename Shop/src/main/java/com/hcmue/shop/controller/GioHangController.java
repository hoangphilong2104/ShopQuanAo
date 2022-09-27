package com.hcmue.shop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/cart")
public class GioHangController {
	
	@RequestMapping(value = "")
	public ModelAndView SanPhamPage(Model model) {
		return new ModelAndView("");
	}
	
}
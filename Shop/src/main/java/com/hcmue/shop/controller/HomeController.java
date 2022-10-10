package com.hcmue.shop.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		khachHangServices.register(khachHang);
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value = "static/css/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getCss(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/css/",files);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						//.contentType(MediaType.parseMediaType(""))
						.body(byteArrayResource);
			} catch (Exception e) {
				// TODO: handle exception
			}
		return ResponseEntity.badRequest().build();
	}
	
	@RequestMapping(value = "static/js/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getJs(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/js/",files);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						//.contentType(MediaType.parseMediaType(""))
						.body(byteArrayResource);
			} catch (Exception e) {
				// TODO: handle exception
			}
		return ResponseEntity.badRequest().build();
	}
	
	@RequestMapping(value = "static/images/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImages(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/images/",files);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						//.contentType(MediaType.parseMediaType(""))
						.body(byteArrayResource);
			} catch (Exception e) {
				// TODO: handle exception
			}
		return ResponseEntity.badRequest().build();
	}
}
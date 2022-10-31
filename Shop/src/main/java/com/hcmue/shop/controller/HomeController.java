package com.hcmue.shop.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.model.Item;
import com.hcmue.shop.model.KhachHangModel;
import com.hcmue.shop.services.KhachHangServices;

@RestController
public class HomeController {
	
	@Autowired
	private KhachHangServices khachHangServices;
	
	
	@RequestMapping(value = "/processHome")
	public ModelAndView userProcessHome(Principal principal) {
		String username = principal.getName();
		if(username.equals("admin")) {
			return new ModelAndView("redirect:/admin");
		}
		return new ModelAndView("redirect:/");
	}
	
	//Home Page
	@RequestMapping(value = "")
	public ModelAndView userHomePage(Principal principal, HttpSession session, ModelMap model) {
		int size_cart = 0;
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart != null) {
			size_cart = cart.size();
			
		}
		model.addAttribute("size_cart",size_cart);
		if(principal == null) {
			return new ModelAndView("views/TrangChu");
		}else {
			String username = principal.getName();
			return new ModelAndView("views/TrangChu", "username", username);
		}
	}
	
	//contact
	@GetMapping("/contact")
	public ModelAndView contact(Principal principal, HttpSession session, ModelMap model) {
		int size_cart = 0;
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart != null) {
			size_cart = cart.size();
		}
		model.addAttribute("size_cart",size_cart);
		if(principal != null) {
			String username = principal.getName();
			model.addAttribute("username",username);
		}
		model.addAttribute("size_cart",size_cart);
		return new ModelAndView("views/contact");
	}
	
	//Login
	@GetMapping(value = "/login")
	public ModelAndView loginPage(Model model,Principal principal) {
		if(principal != null) {
			return new ModelAndView("redirect:/logout");
		}
		model.addAttribute("items", new KhachHangModel());
		return new ModelAndView("views/Login");
	}
	
	//error login
	@GetMapping(value = "/login_error")
	public ModelAndView loginError(Model model) {
		model.addAttribute("stringError","faild");
		model.addAttribute("items", new KhachHangModel());
		return new ModelAndView("views/Login");
	}
	
	//Register
	@GetMapping(value = "/register")
	public ModelAndView registerPage(Model model) {
		model.addAttribute("khachHang", new KhachHangModel());
		return new ModelAndView("views/Register");
	}
	
	//Register
		@GetMapping(value = "/register_error")
		public ModelAndView registerPageError(Model model) {
			model.addAttribute("khachHang", new KhachHangModel());
			model.addAttribute("stringError", "An error occurred while registering, you need to check again");
			return new ModelAndView("views/Register");
		}
		
	//Register
	@PostMapping(value = "/register")
	public ModelAndView registerProcessPage(Model model, @ModelAttribute("khachHang") KhachHangModel khachHang, @RequestParam("MatKhauXN") String MatKhauXN) {
		Boolean register = khachHangServices.register(khachHang,MatKhauXN);
		if(register == true) {
			return new ModelAndView("redirect:/login_s");
		}else {
			return new ModelAndView("redirect:/register_error");
		}
		
	}
	
	@GetMapping(value = "/login_s")
	public ModelAndView loginS(Model model) {
		model.addAttribute("stringS","Register Successful");
		model.addAttribute("items", new KhachHangModel());
		return new ModelAndView("views/Login");
	}
	
	// Logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
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
	
	@RequestMapping(value = "static/ajs/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getAJs(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/ajs/",files);
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
	
	@RequestMapping(value = "static/mail/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getMail(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/mail/",files);
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
	
	@RequestMapping(value = "static/scss/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getSCSS(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/scss/",files);
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
	
	@RequestMapping(value = "static/icon/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getIcon(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/icon/",files);
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
	
	@RequestMapping(value = "static/lib/owlcarousel/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getOwlcarousel(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/lib/owlcarousel/",files);
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
	
	@RequestMapping(value = "static/lib/owlcarousel/assets/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getOwlcarouselAssest(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/lib/owlcarousel/assets/",files);
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
	
	@RequestMapping(value = "static/lib/easing/{files}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getOwlcarouselEasing(@PathVariable("files") String files){
			try {
				Path filename = Paths.get("src/main/resources/static/lib/easing/",files);
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
package com.hcmue.shop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.model.Item;
import com.hcmue.shop.services.SanPhamServices;

@RestController
@RequestMapping(value = "/cart")
public class GioHangController {
	
	@Autowired
	private SanPhamServices ser;
	
	@RequestMapping(value = "")
	public ModelAndView SanPhamPage(Model model, HttpSession session,Principal principal) {
		int total = 0;
		int size_cart = 0;
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart != null) {
			for(int i = 0; i<cart.size();i++) {
				total+=cart.get(i).getQuantity()*cart.get(i).getSanPham().getGiaBan();
			}
			size_cart = cart.size();
		}
		model.addAttribute("total",total);
		model.addAttribute("size_cart",size_cart);
		if(principal != null) {
			String username = principal.getName();
			model.addAttribute("username",username);
		}
		return new ModelAndView("views/Cart");
	}
	
	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public ModelAndView buy(@PathVariable("id") int id, HttpSession session,@RequestParam("url") String url) {
		if(url == null) {
			return new ModelAndView("redirect:/cart");
		}
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(ser.findOne(id), 1));
			session.setAttribute("cart", cart);
			return new ModelAndView("redirect:/"+url);
		} else {
			@SuppressWarnings("unchecked")
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExists(id, cart);
			if (index == -1) {
				cart.add(new Item(ser.findOne(id), 1));
				return new ModelAndView("redirect:/"+url);
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
				return new ModelAndView("redirect:/cart");
			}
		}
		
	}
	
	@RequestMapping(value = "add/{id}", method = RequestMethod.GET)
	public ModelAndView add(@PathVariable("id") int id, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(ser.findOne(id), 1));
			session.setAttribute("cart", cart);
			return new ModelAndView("redirect:/cart");
		} else {
			@SuppressWarnings("unchecked")
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExists(id, cart);
			if (index == -1) {
				cart.add(new Item(ser.findOne(id), 1));
				return new ModelAndView("redirect:/cart");
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
				return new ModelAndView("redirect:/cart");
			}
		}
		
	}
	
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public ModelAndView remove(@PathVariable("id") int id, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExists(id, cart);
		
		if(cart.get(index).getQuantity() == 1) {
			cart.remove(index);
		}else {
			int quantity = cart.get(index).getQuantity() - 1;
			cart.get(index).setQuantity(quantity);
		}
		session.setAttribute("cart", cart);
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping(value = "removeAll/{id}", method = RequestMethod.GET)
	public ModelAndView removeAll(@PathVariable("id") int id, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExists(id, cart);
			cart.remove(index);
		session.setAttribute("cart", cart);
		return new ModelAndView("redirect:/cart");
	}
	
	private int isExists(int id, List<Item> cart) {
		for(int i =0; i < cart.size(); i++) {
			if(cart.get(i).getSanPham().getMaSP() == id) {
				return i;
			}
		}
		return -1;
	}
	
	
	
}
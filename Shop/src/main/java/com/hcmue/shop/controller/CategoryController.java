package com.hcmue.shop.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;


import com.hcmue.shop.entity.SanPham;
import com.hcmue.shop.model.Item;
import com.hcmue.shop.model.LoaiSanPhamModel;
import com.hcmue.shop.services.LoaiSanPhamServices;
import com.hcmue.shop.services.SanPhamServices;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	private LoaiSanPhamServices loaiSanPhamServices;
	
	@Autowired
	private SanPhamServices sanPhamServices;
	
	@RequestMapping(value = "")
	public ModelAndView SanPhamPage() {
		return new ModelAndView("redirect:/categories/page/1");
	}
	
	@RequestMapping(value = "/{slug}")
	public ModelAndView SanPhamPageSlug(@PathVariable("slug") String slug) {
		return new ModelAndView("redirect:/categories/"+slug+"/page/1");
	}
	
	@RequestMapping(value = "/page/{page}")
    public ModelAndView listArticlesPageByPage(@PathVariable("page") int page, ModelMap model, HttpSession session, Principal principal) {
//		if(page < 1) {
//			return new ModelAndView("redirect:/categories/page/1");
//		}else if(page > 6) {
//			return new ModelAndView("redirect:/categories/page/6");
//		}
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
		
		ModelAndView modelAndView = new ModelAndView("views/SanPham");
		PageRequest pageable = PageRequest.of(page - 1, 6);
        Page<SanPham> productPage = sanPhamServices.getPaginated(pageable);
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        String urlpage =String.valueOf(page);
        modelAndView.addObject("page", page);
        modelAndView.addObject("urlpage", urlpage);
        modelAndView.addObject("activeArticleList", true);
        modelAndView.addObject("articleList", productPage.getContent());
        model.addAttribute("url","categories/page/");
        return modelAndView;
    }
        
	@RequestMapping(value = "/{slug}/page/{page}")
    public ModelAndView listArticlesPageByPage(@PathVariable("page") int page,@PathVariable("slug") String slug,
    									ModelMap model, HttpSession session, Principal principal) {
//		if(page < 1) {
//			return new ModelAndView("redirect:/categories/"+slug+"page/1");
//		}else if(page > 6) {
//			return new ModelAndView("redirect:/categories/"+slug+"page/6");
//		}
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
		
		
		
		ModelAndView modelAndView = new ModelAndView("views/SanPham");
		PageRequest pageable = PageRequest.of(page - 1, 6);
		Page<SanPham> productPage = null;
		
		if(slug.equals("nam")) {
			productPage = sanPhamServices.getPaginatedGT(pageable,"Nam");
		}else if(slug.equals("nu")) {
			productPage = sanPhamServices.getPaginatedGT(pageable,"Nữ");
		}else {
			LoaiSanPhamModel loaiSanPhamModel = loaiSanPhamServices.findOne(slug);
			productPage = sanPhamServices.getPaginated(pageable,loaiSanPhamModel.getMaLoaiSP());
		}
        
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        
        String urlpage =String.valueOf(page);
        modelAndView.addObject("page", page);
        modelAndView.addObject("urlpage", urlpage);
        modelAndView.addObject("activeArticleList", true);
        modelAndView.addObject("articleList", productPage.getContent());
        model.addAttribute("url","categories/"+slug+"/page/");
        System.err.println("categories/"+slug+"/page/");
        return modelAndView;
    }
	
}

package com.hcmue.shop.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.entity.SanPham;
import com.hcmue.shop.model.Item;
import com.hcmue.shop.model.SanPhamModel;
import com.hcmue.shop.services.SanPhamServices;

@RestController
@RequestMapping(value = "/sanpham")
public class SanPhamController {
	
	@Autowired
	private SanPhamServices ser;
	
	@RequestMapping(value = "")
	public ModelAndView SanPhamPage() {
		return new ModelAndView("redirect:/sanpham/page/1");
	}
	
	@RequestMapping(value = "/page/{page}")
    public ModelAndView listArticlesPageByPage(@PathVariable("page") int page, ModelMap model, HttpSession session, Principal principal) {
		if(page < 1) {
			return new ModelAndView("redirect:/sanpham/page/1");
		}else if(page > 6) {
			return new ModelAndView("redirect:/sanpham/page/6");
		}
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
		
		ModelAndView modelAndView = new ModelAndView("views/SanPham/show");
		PageRequest pageable = PageRequest.of(page - 1, 6);
        Page<SanPham> productPage = ser.getPaginated(pageable);
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
//            for(int i = 0; i < pageNumbers.size(); i++) {
//            	if(pageNumbers.get(i) == page) {
//            		pageNumbers.remove(i);
//            		break;
//            	}
//            }
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        String urlpage =String.valueOf(page);
        modelAndView.addObject("page", page);
        modelAndView.addObject("urlpage", urlpage);
        modelAndView.addObject("activeArticleList", true);
        modelAndView.addObject("articleList", productPage.getContent());
        return modelAndView;
    }
	
	//Show Image
	@RequestMapping(value = "getimage/{Anh}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("Anh") String Anh){
		if(!Anh.equals("") || Anh != null) {
			try {
				Path filename = Paths.get("src/main/resources/static/images/",Anh);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png"))
						.body(byteArrayResource);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ResponseEntity.badRequest().build();
	}
}
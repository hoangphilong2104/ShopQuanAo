package com.hcmue.shop.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.model.Item;

@RestController
public class HandleErrorController implements ErrorController{
	
	@RequestMapping("/error")
	  public ModelAndView handleError(HttpServletRequest request, ModelMap model, HttpSession session,Principal principal) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    if (status != null) {
	      Integer statusCode = Integer.valueOf(status.toString());
	      String error;
	      if (statusCode == HttpStatus.NOT_FOUND.value()) {
	    	  error = "404.png";
	      } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	    	  error = "500.png";
	      }else {
	    	  error = "error.png";
	      }
	      model.addAttribute("error",error);
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
	    return new ModelAndView("views/404");
	  }
	
}

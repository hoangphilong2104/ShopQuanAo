package com.hcmue.shop.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.hcmue.shop.model.Item;
import com.hcmue.shop.model.KhachHangModel;
import com.hcmue.shop.model.Order;
import com.hcmue.shop.services.KhachHangServices;
import com.hcmue.shop.services.PaypalServices;
import com.hcmue.shop.services.TaiKhoanServices;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutController {
	@Autowired
	private PaypalServices service;
	
	@Autowired
	private KhachHangServices khachHangServices;
	
	public static final String SUCCESS_URL = "checkout/pay/success";
	public static final String CANCEL_URL = "checkout/pay/cancel";
	
	@GetMapping("")
	public ModelAndView checkout(Principal principal, HttpSession session, ModelMap model) {
		if(principal == null) {
			return new ModelAndView("redirect:/login");
		}
		int size_cart = 0;
		int total = 0;
		int USD = 0;
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart != null) {
			for(int i = 0; i<cart.size();i++) {
				total+=cart.get(i).getQuantity()*cart.get(i).getSanPham().getGiaBan();
			}
			size_cart = cart.size();
		}
		USD = (total+20000)*4/100000;
		model.addAttribute("size_cart",size_cart);

		String username = principal.getName();
		model.addAttribute("username",username);
		KhachHangModel account = khachHangServices.findOne(username);
		
		model.addAttribute("account",account);
		model.addAttribute("size_cart",size_cart);
		model.addAttribute("total",total);
		return new ModelAndView("views/checkout");
	}
	
	@PostMapping("/pay")
	public ModelAndView payment(HttpSession session) {
		int total = 0;
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart != null) {
			for(int i = 0; i<cart.size();i++) {
				total+=cart.get(i).getQuantity()*cart.get(i).getSanPham().getGiaBan();
			}
		}
		if(total == 0) {
			return new ModelAndView("redirect:/cart");
		}
		total = (total+20000)*4/100000;
		try {
			Order order = new Order();
			
			order.setPrice(total);
			order.setCurrency("USD");
			order.setMethod("paypal");
			order.setIntent("sale");
			order.setDescription("na");
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
//					return new ModelAndView("redirect:"+link.getHref());
					return new ModelAndView("redirect:"+link.getHref());
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/checkout");
	}
	
	 @GetMapping(value = "/pay/cancel")
    public ModelAndView cancelPay() {
        return new ModelAndView("views/cancel");
    }

    @GetMapping(value = "/pay/success")
    public ModelAndView successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = service.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return new ModelAndView("views/success");
            }
        } catch (PayPalRESTException e) {
         System.out.println(e.getMessage());
        }
        return new ModelAndView("redirect:/checkout");
    }
}

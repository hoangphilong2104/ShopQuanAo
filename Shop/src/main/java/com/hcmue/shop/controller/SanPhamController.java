package com.hcmue.shop.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.shop.model.KhachHangModel;
import com.hcmue.shop.model.SanPhamModel;
import com.hcmue.shop.services.SanPhamServices;

@RestController
@RequestMapping(value = "/sanpham")
public class SanPhamController {
	
	@Autowired
	private SanPhamServices ser;
	
	@RequestMapping(value = "")
	public ModelAndView SanPhamPage(Model model) {
		List<SanPhamModel> listItems = ser.listAll();
		model.addAttribute("listItems", listItems);
		return new ModelAndView("views/SanPham/show");
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
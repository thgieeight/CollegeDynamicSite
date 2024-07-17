package com.own.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.own.springproject.service.ContactService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	public ContactService contactser;
	
	
	@GetMapping("/")
	public String getlogin() {
		return "admin/login";
	}
	
	@PostMapping("/login")
	public String postlogin(@RequestParam("username") String a, @RequestParam("password") String b, Model model) {
		
		
		if("admin".equals(a) && "admin".equals(b)) {
			return "admin/home";
		}else {
			model.addAttribute("m","your enter username and passwords doesnot match");
			return "admin/login";
		}				
	}
	
	
	@GetMapping("/contact")
	public String getcontact(Model model) {
		model.addAttribute("contactlist",contactser.getallcontact());
		return "admin/contact";
	}
	

}

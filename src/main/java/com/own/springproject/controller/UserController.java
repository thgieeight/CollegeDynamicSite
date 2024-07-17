package com.own.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.own.springproject.model.Contact_tb;
import com.own.springproject.service.ContactService;
import com.own.springproject.service.NoticeService;

@Controller
public class UserController {

	@Autowired
	public ContactService contactser;
	
	@Autowired
	public NoticeService noticeser;
	
	@GetMapping("/")
	public String gethome() {
		return "home";
	}
	
	@GetMapping("/about")
	public String getabout() {
		return "about";
	}
	
	@GetMapping("/notice")
	public String getnotice(Model model) {
		model.addAttribute("noticelist", noticeser.getallnotice());
		return "notice";
	}

	
	@GetMapping("/contact")
	public String getcontact() {
		return "contact";
	}
	
	@PostMapping("/contactsave")
	public String postContact(@ModelAttribute Contact_tb contact) {
		contactser.addContact(contact);
		return "contact";
	}
}

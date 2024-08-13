package com.own.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.own.springproject.model.Contact_tb;
import com.own.springproject.service.AboutService;
import com.own.springproject.service.ContactService;
import com.own.springproject.service.HomeService;
import com.own.springproject.service.NoticeService;
import com.own.springproject.service.SliderService;
import com.own.springproject.service.TeamService;

@Controller
public class UserController {

	@Autowired
	public ContactService contactser;
	
	@Autowired
	public NoticeService noticeser;
	
	@Autowired
	public TeamService teamser;
	
	@Autowired
	public AboutService aboutser;
	
	@Autowired
	public HomeService homeser;
	
	@Autowired
	public SliderService sliderser;
	
	@GetMapping("/")
	public String gethome(Model model) {
		model.addAttribute("homelist",homeser.getallhome());
		model.addAttribute("sliderlist",sliderser.getallslider());
		model.addAttribute("teamlist",teamser.getallteam());
		return "home";
	}
	
	@GetMapping("/about")
	public String getabout(Model model) {
		model.addAttribute("aboutlist", aboutser.getallabout());
		model.addAttribute("teamlist",teamser.getallteam());
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

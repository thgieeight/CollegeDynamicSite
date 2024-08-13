package com.own.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.own.springproject.model.Home_tb;
import com.own.springproject.service.HomeService;
import com.own.springproject.util.FileUtil;

@Controller
@RequestMapping("/admin")
public class HomeController {
	
	
	@Autowired
	public HomeService homeser;
	
	@Autowired
	public FileUtil fileutil;
	
	
	@GetMapping("/home/add")
	public String gethomeadd() {
		return "admin/homeadd";
	}
	


	@PostMapping("/home/add")
	public String posthomeadd(@RequestParam("homename") String homename,@RequestParam(value = "status", required = false) String status,@RequestParam("homeimg") MultipartFile image,Model model) {
		        Home_tb home = new Home_tb();
		        home.setHometext(homename);
		        home.setStatus(status != null && status.equals("1") ? 1 : 0); 
		        if (!image.isEmpty()) {
		        	fileutil.fileUpload(image);
		            home.setHomeimage(image.getOriginalFilename());
		            homeser.addHome(home);
		            model.addAttribute("message", "Upload success");
		        } else {
		            model.addAttribute("message", "Upload fail");
		        }
		        return "admin/homeadd";
		    }

	
	@GetMapping("/home/edit")
	public String getedit(@RequestParam int id, Model model) {	
	model.addAttribute("HomeObject", homeser.getHomeById(id));		
	return "admin/homeedit";
	}
	
	
	@PostMapping("/home/update")
	public String update(@ModelAttribute Home_tb home, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "image", required = false) MultipartFile image, Model model) {
			    Home_tb existingNotice = homeser. getHomeById(home.getId());
			    if (image.isEmpty()) {
			        home.setHomeimage(existingNotice.getHomeimage());
			    } else {
			    	fileutil.fileUpload(image);
			        home.setHomeimage(image.getOriginalFilename());
			    }
			    home.setStatus(status != null && status.equals("1") ? 1 : 0);
			    homeser.updateHome(home);
			    return "redirect:/admin/home";
			}


	@GetMapping("/home/delete")
	public String delete(@RequestParam int id) {
	homeser.deleteHome(id);
	return "redirect:/admin/home";
	}



}

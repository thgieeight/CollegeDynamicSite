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

import com.own.springproject.model.About_tb;
import com.own.springproject.service.AboutService;
import com.own.springproject.util.FileUtil;

@Controller
@RequestMapping("/admin")
public class AboutController {
	
	@Autowired
	public AboutService aboutser;
	
	@Autowired
	public FileUtil fileutil;
	
	@GetMapping("/about")
	public String getabout(Model model) {
		model.addAttribute("aboutlist", aboutser.getallabout());
		return "admin/about";
	}
	@GetMapping("/about/add")
	public String getaboutadd() {
		return "admin/aboutadd";
	}
	


	@PostMapping("/about/add")
	public String postaboutadd(@RequestParam("aboutname") String aboutname,@RequestParam(value = "status", required = false) String status,@RequestParam("aboutimg") MultipartFile image,Model model) {
		        About_tb about = new About_tb();
		        about.setAbouttext(aboutname);
		        about.setStatus(status != null && status.equals("1") ? 1 : 0); 
		        if (!image.isEmpty()) {
		        	fileutil.fileUpload(image);
		            about.setAboutimage(image.getOriginalFilename());
		            aboutser.addAbout(about);
		            model.addAttribute("message", "Upload success");
		        } else {
		            model.addAttribute("message", "Upload fail");
		        }
		        return "admin/aboutadd";
		    }

	
	@GetMapping("/about/edit")
	public String getedit(@RequestParam int id, Model model) {	
	model.addAttribute("AboutObject",aboutser.getAboutById(id));		
	return "admin/aboutedit";
	}
	
	
	@PostMapping("/about/update")
	public String update(@ModelAttribute About_tb about, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "image", required = false) MultipartFile image, Model model) {
			    About_tb existingNotice = aboutser. getAboutById(about.getId());
			    if (image.isEmpty()) {
			        about.setAboutimage(existingNotice.getAboutimage());
			    } else {
			    	fileutil.fileUpload(image);
			        about.setAboutimage(image.getOriginalFilename());
			    }
			    about.setStatus(status != null && status.equals("1") ? 1 : 0);
			    aboutser.updateAbout(about);
			    return "redirect:/admin/about";
			}


	@GetMapping("/about/delete")
	public String delete(@RequestParam int id) {
	aboutser.deleteAbout(id);
	return "redirect:/admin/about";
	}


}

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

import com.own.springproject.model.Slider_tb;
import com.own.springproject.service.SliderService;
import com.own.springproject.util.FileUtil;

@Controller
@RequestMapping("/admin")
public class SliderController {
	
	@Autowired
	public SliderService sliderser;
	
	@Autowired
	public FileUtil fileutil;
	
	@GetMapping("/slider")
	public String getslider(Model model) {
		model.addAttribute("sliderlist", sliderser.getallslider());
		return "admin/slider";
	}
	@GetMapping("/slider/add")
	public String getslideradd() {
		return "admin/slideradd";
	}
	


	@PostMapping("/slider/add")
	public String postslideradd(@RequestParam("slidertext1") String slidername1,@RequestParam("slidertext2") String slidername2,@RequestParam(value = "status", required = false) String status,@RequestParam("sliderimg") MultipartFile image,Model model) {
		        Slider_tb slider = new Slider_tb();
		        slider.setSlidertext1(slidername1);
		        slider.setSlidertext2(slidername2);
		        slider.setStatus(status != null && status.equals("1") ? 1 : 0); 
		        if (!image.isEmpty()) {
		        	fileutil.fileUpload(image);
		            slider.setSliderimage(image.getOriginalFilename());
		            sliderser.addSlider(slider);
		            model.addAttribute("message", "Upload success");
		        } else {
		            model.addAttribute("message", "Upload fail");
		        }
		        return "admin/slideradd";
		    }

	
	@GetMapping("/slider/edit")
	public String getedit(@RequestParam int id, Model model) {	
	model.addAttribute("SliderObject",sliderser.getSliderById(id));		
	return "admin/slideredit";
	}
	
	
	@PostMapping("/slider/update")
	public String update(@ModelAttribute Slider_tb slider, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "image", required = false) MultipartFile image, Model model) {
			    Slider_tb existingNotice = sliderser. getSliderById(slider.getId());
			    if (image.isEmpty()) {
			        slider.setSliderimage(existingNotice.getSliderimage());
			    } else {
			    	fileutil.fileUpload(image);
			        slider.setSliderimage(image.getOriginalFilename());
			    }
			    slider.setStatus(status != null && status.equals("1") ? 1 : 0);
			    sliderser.updateSlider(slider);
			    return "redirect:/admin/slider";
			}


	@GetMapping("/slider/delete")
	public String delete(@RequestParam int id) {
	sliderser.deleteSlider(id);
	return "redirect:/admin/slider";
	}



}

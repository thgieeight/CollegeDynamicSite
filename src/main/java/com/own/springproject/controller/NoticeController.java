package com.own.springproject.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.own.springproject.model.Notice;
import com.own.springproject.service.NoticeService;

import com.own.springproject.util.FileUtil;


@Controller
@RequestMapping("/admin")
public class NoticeController {
	
	
	@Autowired
	public NoticeService noticeser;
	
	@Autowired
	public FileUtil fileutil;
	
	@GetMapping("/notice")
	public String getnotice(Model model) {
		model.addAttribute("noticelist", noticeser.getallnotice());
		return "admin/notice";
	}
	@GetMapping("/notice/add")
	public String getnoticeadd() {
		return "admin/noticeadd";
	}
	


	@PostMapping("/notice/add")
	public String postnoticeadd(@RequestParam("noticename") String noticename,@RequestParam(value = "status", required = false) String status,@RequestParam("noticeimg") MultipartFile image,Model model) {
		        Notice notice = new Notice();
		        notice.setNoticename(noticename);
		        notice.setStatus(status != null && status.equals("1") ? 1 : 0); 
		        notice.setAdddate(LocalDate.now()); // Setting the current date
		        if (!image.isEmpty()) {
		        	fileutil.fileUpload(image);
		            notice.setNoticeimg(image.getOriginalFilename());
		            noticeser.addNotice(notice);
		            model.addAttribute("message", "Upload success");
		        } else {
		            model.addAttribute("message", "Upload fail");
		        }
		        return "admin/noticeadd";
		    }

	
	@GetMapping("/notice/edit")
	public String getedit(@RequestParam long id, Model model) {	
	model.addAttribute("NoticeObject",noticeser.getNoticeById(id));		
	return "admin/noticeedit";
	}
	
	
	@PostMapping("/notice/update")
	public String update(@ModelAttribute Notice notice, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "image", required = false) MultipartFile image, Model model) {
			    Notice existingNotice = noticeser. getNoticeById(notice.getId());
			    if (image.isEmpty()) {
			        notice.setNoticeimg(existingNotice.getNoticeimg());
			    } else {
			    	fileutil.fileUpload(image);
			        notice.setNoticeimg(image.getOriginalFilename());
			    }
			    notice.setAdddate(existingNotice.getAdddate());
			    notice.setStatus(status != null && status.equals("1") ? 1 : 0);
			    noticeser.updateNotice(notice);
			    return "redirect:/admin/notice";
			}


	@GetMapping("/notice/delete")
	public String delete(@RequestParam long id) {
	noticeser.deleteNotice(id);
	return "redirect:/admin/notice";
	}


}


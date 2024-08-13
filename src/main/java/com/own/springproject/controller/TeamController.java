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

import com.own.springproject.model.Team_tb;
import com.own.springproject.service.TeamService;
import com.own.springproject.util.FileUtil;

@Controller
@RequestMapping("/admin")
public class TeamController {
	

	@Autowired
	public TeamService teamser;
	
	@Autowired
	public FileUtil fileutil;
	
	@GetMapping("/team")
	public String getteam(Model model) {
		model.addAttribute("teamlist", teamser.getallteam());
		return "admin/team";
	}
	@GetMapping("/team/add")
	public String getteamadd() {
		return "admin/teamadd";
	}
	


	@PostMapping("/team/add")
	public String postteamadd(@RequestParam("teamname") String teamname,@RequestParam(value = "status", required = false) String status,@RequestParam("teamimg") MultipartFile image,Model model) {
		        Team_tb team = new Team_tb();
		        team.setTeamtext(teamname);
		        team.setStatus(status != null && status.equals("1") ? 1 : 0); 
		        if (!image.isEmpty()) {
		        	fileutil.fileUpload(image);
		            team.setTeamimage(image.getOriginalFilename());
		            teamser.addTeam(team);
		            model.addAttribute("message", "Upload success");
		        } else {
		            model.addAttribute("message", "Upload fail");
		        }
		        return "admin/teamadd";
		    }

	
	@GetMapping("/team/edit")
	public String getedit(@RequestParam int id, Model model) {	
	model.addAttribute("TeamObject",teamser.getNoticeById(id));		
	return "admin/teamedit";
	}
	
	
	@PostMapping("/team/update")
	public String update(@ModelAttribute Team_tb team, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "image", required = false) MultipartFile image, Model model) {
			    Team_tb existingNotice = teamser. getNoticeById(team.getId());
			    if (image.isEmpty()) {
			        team.setTeamimage(existingNotice.getTeamimage());
			    } else {
			    	fileutil.fileUpload(image);
			        team.setTeamimage(image.getOriginalFilename());
			    }
			    team.setStatus(status != null && status.equals("1") ? 1 : 0);
			    teamser.updateTeam(team);
			    return "redirect:/admin/team";
			}


	@GetMapping("/team/delete")
	public String delete(@RequestParam int id) {
	teamser.deleteTeam(id);
	return "redirect:/admin/team";
	}



}

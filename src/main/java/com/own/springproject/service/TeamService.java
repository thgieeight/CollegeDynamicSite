package com.own.springproject.service;

import java.util.List;

import com.own.springproject.model.Team_tb;


public interface TeamService {

	void addTeam(Team_tb team);
	List<Team_tb> getallteam();
	
	void deleteTeam(int id);
	void updateTeam(Team_tb team);
	Team_tb getNoticeById(int id);
}

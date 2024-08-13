package com.own.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.own.springproject.model.Team_tb;
import com.own.springproject.repository.TeamRepository;
import com.own.springproject.service.TeamService;
@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamrepo;
	
	@Override
	public void addTeam(Team_tb team) {
		teamrepo.save(team);
	}

	@Override
	public List<Team_tb> getallteam() {
		return teamrepo.findAll();
	}

	@Override
	public void deleteTeam(int id) {
		teamrepo.deleteById(id);
	}

	@Override
	public void updateTeam(Team_tb team) {
		teamrepo.save(team);
	}

	@Override
	public Team_tb getNoticeById(int id) {
		return teamrepo.findById(id).get();
	}

}

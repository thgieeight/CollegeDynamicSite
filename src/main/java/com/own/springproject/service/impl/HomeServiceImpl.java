package com.own.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.own.springproject.model.Home_tb;
import com.own.springproject.repository.HomeRepository;
import com.own.springproject.service.HomeService;
@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeRepository homerepo;
	
	@Override
	public void addHome(Home_tb home) {
		homerepo.save(home);		
	}

	@Override
	public List<Home_tb> getallhome() {
		return homerepo.findAll();
	}

	@Override
	public void deleteHome(int id) {
		homerepo.deleteById(id);
	}

	@Override
	public void updateHome(Home_tb home) {
		homerepo.save(home);		
		
	}

	@Override
	public Home_tb getHomeById(int id) {
		return homerepo.findById(id).get();
	}

}

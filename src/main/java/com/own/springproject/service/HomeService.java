package com.own.springproject.service;

import java.util.List;

import com.own.springproject.model.Home_tb;


public interface HomeService {

	void addHome(Home_tb home);
	List<Home_tb> getallhome();
	
	void deleteHome(int id);
	void updateHome(Home_tb home);
	Home_tb getHomeById(int id);
}

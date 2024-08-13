package com.own.springproject.service;

import java.util.List;

import com.own.springproject.model.About_tb;


public interface AboutService {


	void addAbout(About_tb about);
	List<About_tb> getallabout();
	
	void deleteAbout(int id);
	void updateAbout(About_tb about);
	About_tb getAboutById(int id);
}

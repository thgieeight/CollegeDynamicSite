package com.own.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.own.springproject.model.About_tb;
import com.own.springproject.repository.AboutRepository;
import com.own.springproject.service.AboutService;

@Service
public class AboutServiceImpl implements AboutService {

	@Autowired
	private AboutRepository aboutrepo;	
	
	
	@Override
	public void addAbout(About_tb about) {
		aboutrepo.save(about);		
	}

	@Override
	public List<About_tb> getallabout() {
		return aboutrepo.findAll();
	}

	@Override
	public void deleteAbout(int id) {
		aboutrepo.deleteById(id);
	}

	@Override
	public void updateAbout(About_tb about) {
		aboutrepo.save(about);		
		
	}

	@Override
	public About_tb getAboutById(int id) {
		return aboutrepo.findById(id).get();
	}

}

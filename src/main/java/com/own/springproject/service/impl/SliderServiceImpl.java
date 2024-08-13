package com.own.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.own.springproject.model.Slider_tb;
import com.own.springproject.repository.SliderRepository;
import com.own.springproject.service.SliderService;

@Service
public class SliderServiceImpl implements SliderService {

	@Autowired
	private SliderRepository sliderrepo;
	
	@Override
	public void addSlider(Slider_tb slider) {
		sliderrepo.save(slider);		
	}

	@Override
	public List<Slider_tb> getallslider() {
		return sliderrepo.findAll();
	}

	@Override
	public void deleteSlider(int id) {
		sliderrepo.deleteById(id);		
	}

	@Override
	public void updateSlider(Slider_tb slider) {
		sliderrepo.save(slider);		
		
	}

	@Override
	public Slider_tb getSliderById(int id) {
		return sliderrepo.findById(id).get();
	}

	

}

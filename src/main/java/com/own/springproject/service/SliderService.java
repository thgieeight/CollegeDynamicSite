package com.own.springproject.service;

import java.util.List;

import com.own.springproject.model.Slider_tb;


public interface SliderService {


	void addSlider(Slider_tb slider);
	List<Slider_tb> getallslider();
	
	void deleteSlider(int id);
	void updateSlider(Slider_tb slider);
	Slider_tb getSliderById(int id);
}

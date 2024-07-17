package com.own.springproject.service;

import java.util.List;

import com.own.springproject.model.Contact_tb;

public interface ContactService {

	void addContact(Contact_tb contact);
	
	
	List<Contact_tb> getallcontact();
}

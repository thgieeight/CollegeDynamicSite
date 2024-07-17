package com.own.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.own.springproject.model.Contact_tb;
import com.own.springproject.repository.ContactRepository;
import com.own.springproject.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	public ContactRepository contactrepo;
	
	@Override
	public void addContact(Contact_tb contact) {
		contactrepo.save(contact);
	}

	@Override
	public List<Contact_tb> getallcontact() {
		return contactrepo.findAll();
	}

}

package com.own.springproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.own.springproject.model.Contact_tb;
import com.own.springproject.service.ContactService;

@RestController
public class RestapiController {
	
	@Autowired
	public ContactService contactser;
	
	@GetMapping("api/v1/contact/list")
	public List<Contact_tb> getallcontact(){
		return contactser.getallcontact();
	}
	
	@PostMapping("api/v1/contact/add")
	public String add(@RequestBody Contact_tb contact ) {
		contactser.addContact(contact);
		return "ok the data is added";
	}

}

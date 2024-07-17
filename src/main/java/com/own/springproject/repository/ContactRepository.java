package com.own.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.own.springproject.model.Contact_tb;

public interface ContactRepository extends JpaRepository<Contact_tb, Long> {

}

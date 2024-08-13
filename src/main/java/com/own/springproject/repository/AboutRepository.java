package com.own.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.own.springproject.model.About_tb;

public interface AboutRepository extends JpaRepository<About_tb, Integer> {

}

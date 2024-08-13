package com.own.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.own.springproject.model.Home_tb;

public interface HomeRepository extends JpaRepository<Home_tb, Integer> {

}

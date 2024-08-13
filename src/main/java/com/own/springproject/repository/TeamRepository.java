package com.own.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.own.springproject.model.Team_tb;

public interface TeamRepository extends JpaRepository<Team_tb, Integer> {

}

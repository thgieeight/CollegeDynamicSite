package com.own.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.own.springproject.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}

package com.own.springproject.service;

import java.util.List;

import com.own.springproject.model.Notice;

public interface NoticeService {

	void addNotice(Notice notice);
	List<Notice> getallnotice();
	
	void deleteNotice(long id);
	void updateNotice(Notice notice);
	Notice getNoticeById(long id);

}

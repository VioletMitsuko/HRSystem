package com.cn.qingruan.hrsystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.dao.NoticeDao;
import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<Notice> findAll() {
		return noticeDao.findAll();
	}

	@Override
	public List<Notice> findNoticeByLimitAndOffset(Integer offset, Integer limit) {
		return noticeDao.findNoticeByLimitAndOffset(offset, limit);
	}

	@Override
	public int countNotice() {
		return noticeDao.countNotice();
	}

	@Override
	public int deleteNotice(Integer id) {
		return noticeDao.deleteNotice(id);
	}

	@Override
	public int addNotice(String title, String context, Date create_date, Date lastModifiled, int user_id) {
		return noticeDao.addNotice(title, context, create_date, lastModifiled, user_id);
	}

	@Override
	public int updateNotice(String title, String context, Date create_date, Date lastModifiled, int user_id, int id) {
		return noticeDao.updateNotice(title, context, create_date, lastModifiled, user_id, id);
	}

	@Override
	public Notice findNoticeById(int id) {
		return noticeDao.findNoticeById(id);
	}
}

package com.cn.qingruan.hrsystem.service;

import java.util.Date;
import java.util.List;


import com.cn.qingruan.hrsystem.domain.Notice;

public interface NoticeService {

	// 查询所有公告
	public List<Notice> findAll();
	
	// 根据id查询合同
	public Notice findNoticeById(int id);
	
	// 分页查询
	public List<Notice> findNoticeByLimitAndOffset(Integer offset, Integer limit);

	// 查询所有公告总数
	public int countNotice();
	
	//删除公告
	public int deleteNotice(Integer id);
	
	//添加公告
	public int addNotice(String title,String context,Date create_date,Date lastModifiled,int user_id);
	
	//修改公告
	public int updateNotice(String title,String context,Date create_date,Date lastModifiled,int user_id,int id);
}

package com.cn.qingruan.hrsystem.service;

import java.util.Date;
import java.util.List;


import com.cn.qingruan.hrsystem.domain.Notice;

public interface NoticeService {

	// ��ѯ���й���
	public List<Notice> findAll();
	
	// ����id��ѯ��ͬ
	public Notice findNoticeById(int id);
	
	// ��ҳ��ѯ
	public List<Notice> findNoticeByLimitAndOffset(Integer offset, Integer limit);

	// ��ѯ���й�������
	public int countNotice();
	
	//ɾ������
	public int deleteNotice(Integer id);
	
	//��ӹ���
	public int addNotice(String title,String context,Date create_date,Date lastModifiled,int user_id);
	
	//�޸Ĺ���
	public int updateNotice(String title,String context,Date create_date,Date lastModifiled,int user_id,int id);
}

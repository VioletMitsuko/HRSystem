package com.cn.qingruan.hrsystem.service;

import java.util.List;

import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.domain.User;

public interface UserService {
	//��ѯ�û�
	public User findUser(String username,String password);
	//����id��ѯ�û�
	public User findUserById(int id);
	//��ѯ���й���
	public List<Notice> findAllNotice();
	//����id��ѯ����
	public Notice findNoticeById(int id);
}

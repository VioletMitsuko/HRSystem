package com.cn.qingruan.hrsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.domain.User;

@Repository("userDao")
public interface UserDao {
	//��ѯ�û�
	@Select("select * from user where username=#{username} and password=#{password}")
	public User findUserByUsernameAndPassword(User user);
	//����id��ѯ�û�
	@Select("select * from user where id=#{id}")
	public User findUserById(int id);
	//��ѯ���й���
	@Select("select * from notice")
	public List<Notice> findAllNotice();
	//����ID��ѯ����
	@Select("select * from notice where id=#{id}")
	public Notice findNoticeById(int id);
}

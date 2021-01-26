package com.cn.qingruan.hrsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.qingruan.hrsystem.domain.Dept;

@Repository("deptDao")
public interface DeptDao {

	//��ѯ���в���
	@Select("select * from dept")
	public List<Dept> findAll();
	
	//����id��ѯ����
	@Select("select * from dept where id=#{id}")
	public Dept findDeptById(@Param("id") int id);
	
	//��ѯ��������
    @Select({"select count(*) from dept"})
    public int countDepts();
}

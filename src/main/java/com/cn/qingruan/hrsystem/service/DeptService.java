package com.cn.qingruan.hrsystem.service;

import java.util.Date;
import java.util.List;

import com.cn.qingruan.hrsystem.domain.Dept;

public interface DeptService {
	// ��ѯ���в���
	public List<Dept> findAll();

	// ����id��ѯ����
	public Dept findDeptById(String id);

	// ��ѯ��������
	public int countDepts();

	// ��Ӳ���
	public int addDept(int deptno, String deptname, Date create_date, int deptManager);

	// �޸Ĳ�����Ϣ
	public int updateDept(int deptno, String deptname, Date create_date, int deptManager, int id);

	// ɾ��������Ϣ
	public int deleteDept(int id);

	// ��ѯ���в�����Ϣ
	public List<Dept> findDeptsByLimitAndOffset(Integer offset, Integer limit);
}

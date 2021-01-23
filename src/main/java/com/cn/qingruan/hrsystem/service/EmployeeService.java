package com.cn.qingruan.hrsystem.service;

import java.util.List;

import com.cn.qingruan.hrsystem.domain.Employee;
import com.cn.qingruan.hrsystem.domain.PageBean;

public interface EmployeeService {
	/**
	 * �������е�Ա��
	 * @return
	 */
	public List<Employee> findAll();
	
	/**
	 * ���ݵ�ǰ��ҳ��ȥ��ѯ��Ӧ��PageBean
	 * @param pageNo
	 * @return
	 */
	public PageBean<Employee> findEmployeeAndPaging(String pageNo);
	
	/**
	 * ��ѯ��ҳ��
	 * @return
	 */
	public int findTotalPages();
	
	/**
	 * ���Ա����Ϣ
	 * @param employee
	 */
	public void addEmp(Employee employee);
	
	/**
	 * ����Ա�����ȥ���Ҷ�Ӧ��Ա��
	 * @param empID
	 */
	public Employee findEmpByEmpID(String empID);
	
	/**
	 * ����Ա������Ϣ
	 * @param employee
	 */
	public void updateEmp(Employee employee);
	
	/**
	 * ����Ա����empID��ɾ����Ӧ�ļ�¼
	 * @param empID
	 */
	public void deleteEmpByEmpID(String empID);
}

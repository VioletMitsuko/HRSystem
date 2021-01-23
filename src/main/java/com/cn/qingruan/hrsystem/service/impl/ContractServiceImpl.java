package com.cn.qingruan.hrsystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.qingruan.hrsystem.dao.ContractDao;
import com.cn.qingruan.hrsystem.domain.Contract;
import com.cn.qingruan.hrsystem.service.ContractService;

@Service("contractService")
public class ContractServiceImpl implements ContractService{
	@Autowired
	private ContractDao contractDao;
	@Override
	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		return contractDao.findAll();
	}

	@Override
	public Contract findContractById(String id) {
		// TODO Auto-generated method stub
		return contractDao.findContractById(id);
	}

	@Override
	public List<Contract> findContractsByLimitAndOffset(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return contractDao.findContractsByLimitAndOffset(offset, limit);
	}

	@Override
	public int countContract() {
		// TODO Auto-generated method stub
		return contractDao.countContract();
	}

	@Override
	public int deleteContract(Integer id) {
		// TODO Auto-generated method stub
		return contractDao.deleteContract(id);
	}

	@Override
	public int addContract(Date contract_date, Date start_date, Date end_date, String comment, int emp_id) {
		// TODO Auto-generated method stub
		return contractDao.addContract(contract_date, start_date, end_date, comment, emp_id);
	}

	@Override
	public int updateContract(Date end_date, String comment, int emp_id, int id) {
		// TODO Auto-generated method stub
		return contractDao.updateContract(end_date, comment, emp_id, id);
	}

}

package com.cn.qingruan.hrsystem.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cn.qingruan.hrsystem.domain.Contract;
import com.cn.qingruan.hrsystem.service.ContractService;

@Controller
@RequestMapping("/contract")
public class ContractController {
	@Autowired
	private ContractService contractService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
	@RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
	public String getTotalPages(HttpSession session) {
		int limit = 5;
		int totalItems = contractService.countContract();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		session.setAttribute("totalPages", totalPages);
		return "contractPage";
	}

	@RequestMapping(value = "/getContractList", method = RequestMethod.GET)
	public ModelAndView getContractList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		ModelAndView mv = new ModelAndView("contractPage");
		// 每页显示的记录行数
		int limit = 5;
		// 总记录数
		int totalItems = contractService.countContract();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		// 每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
		int offset = (pageNo - 1) * limit;
		List<Contract> contracts = contractService.findcontractsByLimitAndOffset(offset, limit);

		mv.addObject("contracts", contracts).addObject("totalItems", totalItems).addObject("totalPages", totalPages)
				.addObject("curPageNo", pageNo);
		return mv;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(HttpSession session) {
		List<Contract> contracts = contractService.findAll();
		session.setAttribute("contracts", contracts);
		return "contractPage";
	}
	
	@RequestMapping(value = "/getContractById", method = RequestMethod.GET)
	public String findContractById(@PathVariable("id") int id,HttpSession session) {
		Contract contract = contractService.findcontractById(id);
		if(contract!=null) {
			session.setAttribute("contract", contract);
		}
		return "contractPage";
	}

	@RequestMapping(value = "/deleteContract/{id}", method = RequestMethod.GET)
	public String deleteContract(@PathVariable("id") int id,HttpSession session) {
		contractService.deleteContract(id);
		return "contractPage";
	}
	
	@RequestMapping(value = "/addContract", method = RequestMethod.GET)
	public String addContract(Date contract_date,Date start_date,Date end_date,String comment,int emp_id,HttpSession session) {
		contractService.addContract(contract_date, start_date, end_date, comment, emp_id);
		return "contractPage";
	}
	
	@RequestMapping(value = "/updateContract/{id}", method = RequestMethod.GET)
	public String updateContract(Date end_date, String comment, int emp_id,@PathVariable("id") int id,HttpSession session) {
		contractService.updateContract(end_date, comment, emp_id, id);
		return "contractPage";
	}
}

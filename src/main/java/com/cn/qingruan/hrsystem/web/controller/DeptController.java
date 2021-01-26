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

import com.cn.qingruan.hrsystem.domain.Dept;
import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.service.DeptService;
import com.cn.qingruan.hrsystem.service.NoticeService;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
	@RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
	public @ResponseBody int getTotalPages(HttpSession session) {
		// 每页显示的记录行数
		int limit = 5;
		// 总记录数
		int totalItems = deptService.countDepts();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		
		return totalPages;
	}

	@RequestMapping(value = "/getDeptList", method = RequestMethod.GET)
	public ModelAndView getNoticeList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		ModelAndView mv = new ModelAndView("deptPage");
		// 每页显示的记录行数
		int limit = 5;
		// 总记录数
		int totalItems = deptService.countDepts();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		// 每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
		int offset = (pageNo - 1) * limit;
		List<Dept> depts = deptService.findDeptsByLimitAndOffset(offset, limit);

		mv.addObject("depts", depts).addObject("totalItems", totalItems).addObject("totalPages", totalPages)
				.addObject("curPageNo", pageNo);
		return mv;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(HttpSession session) {
		List<Dept> depts = deptService.findAll();
		session.setAttribute("depts", depts);
		return "deptPage";
	}
	
	@RequestMapping(value = "/findDeptById", method = RequestMethod.GET)
	public @ResponseBody Dept findDeptById(String id,HttpSession session) {
		
		return deptService.findDeptById(id);
	}

	@RequestMapping(value = "/deleteDept/{id}", method = RequestMethod.GET)
	public String deleteDept(@PathVariable("id") int id,HttpSession session) {
		deptService.deleteDept(id);
		return "deptPage";
	}
	
	@RequestMapping(value = "/addDept", method = RequestMethod.GET)
	public String addContract(int deptno,String deptname,Date create_date,int deptManager,HttpSession session) {
		deptService.addDept(deptno, deptname, create_date, deptManager);
		return "deptPage";
	}
	
	@RequestMapping(value = "/updateNotice/{id}", method = RequestMethod.GET)
	public String updateNotice(int deptno,String deptname,Date create_date,int deptManager,@PathVariable("id") int id,HttpSession session) {
		deptService.updateDept(deptno, deptname, create_date, deptManager, id);
		return "deptPage";
	}
}

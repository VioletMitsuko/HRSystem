package com.cn.qingruan.hrsystem.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.qingruan.hrsystem.domain.Job;
import com.cn.qingruan.hrsystem.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
	public String getTotalPages(HttpSession session) {
		int limit = 5;
		int totalItems = jobService.countJob();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		session.setAttribute("totalPages", totalPages);
		return "jobPage";
	}

	@RequestMapping(value = "/getJobList", method = RequestMethod.GET)
	public ModelAndView getJobList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		ModelAndView mv = new ModelAndView("jobPage");
		// 每页显示的记录行数
		int limit = 5;
		// 总记录数
		int totalItems = jobService.countJob();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		// 每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
		int offset = (pageNo - 1) * limit;
		List<Job> jobs = jobService.findJobsByLimitAndOffset(offset, limit);

		mv.addObject("jobs", jobs).addObject("totalItems", totalItems).addObject("totalPages", totalPages)
				.addObject("curPageNo", pageNo);
		return mv;
	}

	@RequestMapping("/findAll")
	public String findAll(HttpSession session) {
		List<Job> jobs = jobService.findAll();
		session.setAttribute("jobs", jobs);
		return "jobPage";
	}

	@RequestMapping("/deleteJob")
	public String deleteJob(int id) {
		jobService.deleteJob(id);
		return "jobPage";
	}
}

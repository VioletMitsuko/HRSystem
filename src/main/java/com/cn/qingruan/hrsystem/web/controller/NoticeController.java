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

import com.cn.qingruan.hrsystem.domain.Notice;
import com.cn.qingruan.hrsystem.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
	@RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
	public String getTotalPages(HttpSession session) {
		int limit = 5;
		int totalItems = noticeService.countNotice();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		session.setAttribute("totalPages", totalPages);
		return "noticePage";
	}

	@RequestMapping(value = "/getNoticeList", method = RequestMethod.GET)
	public ModelAndView getNoticeList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		ModelAndView mv = new ModelAndView("noticePage");
		// 每页显示的记录行数
		int limit = 5;
		// 总记录数
		int totalItems = noticeService.countNotice();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		// 每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
		int offset = (pageNo - 1) * limit;
		List<Notice> notices = noticeService.findNoticeByLimitAndOffset(offset, limit);

		mv.addObject("notices", notices).addObject("totalItems", totalItems).addObject("totalPages", totalPages)
				.addObject("curPageNo", pageNo);
		return mv;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(HttpSession session) {
		List<Notice> notices = noticeService.findAll();
		session.setAttribute("notices", notices);
		return "noticePage";
	}
	
	@RequestMapping(value = "/findNoticeById", method = RequestMethod.GET)
	public @ResponseBody Notice findNoticeById(String id,HttpSession session) {
		
		return noticeService.findNoticeById(id);
	}

	@RequestMapping(value = "/deleteNotice/{id}", method = RequestMethod.GET)
	public String deleteNotice(@PathVariable("id") int id,HttpSession session) {
		noticeService.deleteNotice(id);
		return "noticePage";
	}
	
	@RequestMapping(value = "/addNotice", method = RequestMethod.GET)
	public String addContract(String title,String context,Date create_date,int user_id,HttpSession session) {
		noticeService.addNotice(title, context, create_date, new Date(), user_id);
		return "noticePage";
	}
	
	@RequestMapping(value = "/updateNotice/{id}", method = RequestMethod.GET)
	public String updateNotice(String title,String context,int user_id,@PathVariable("id") int id,HttpSession session) {
		noticeService.updateNotice(title, context, new Date(), user_id, id);
		return "noticePage";
	}
}

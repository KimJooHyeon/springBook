package com.kjh.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kjh.service.BookService;

@Controller
public class BookController {
	@Inject
	BookService bookService;
	
	@RequestMapping (value="/create", method=RequestMethod.GET)
	public ModelAndView create(ModelAndView mav) {
		mav.setViewName("book/create");
		return mav;
	}
	
	@RequestMapping (value="/create", method=RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map, ModelAndView mav) {
		String bookId = this.bookService.insert(map);
		if (bookId == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	@RequestMapping (value="/detail", method=RequestMethod.GET)
	public ModelAndView select(@RequestParam Map<String, Object> map, ModelAndView mav) {
		Map<String, Object> detailMap = this.bookService.select(map);
		mav.addObject("data", detailMap);
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		mav.setViewName("book/detail");
		return mav;
	}
	
	@RequestMapping (value="/update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map, ModelAndView mav) {
		Map<String, Object> detailMap = this.bookService.select(map);
		mav.addObject("data", detailMap);
		mav.setViewName("book/update");
		return mav;
	}
	
	@RequestMapping (value="/update", method=RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map, ModelAndView mav) {
		boolean isSuccess =  this.bookService.update(map);
		if (isSuccess) {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		} else {
			mav = this.update(map, mav);
		}
		return mav;
	}
	
	@RequestMapping (value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam Map<String, Object> map, ModelAndView mav) {
		boolean isSuccess = this.bookService.delete(map);
		if (isSuccess) {
			mav.setViewName("redirect:/list");
		} else {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId" + bookId);
		}
		return mav;
	}
	
	@RequestMapping (value="/list", method=RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, Object> map, ModelAndView mav) {
		List<Map<String, Object>> list = this.bookService.list();
		mav.addObject("data", list);
		mav.setViewName("book/list");
		return mav;
	}
}
















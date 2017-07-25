package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.spring.entity.KindCodeVO;
import com.spring.entity.RecipeVO;
import com.spring.service.KindCodeService;
import com.spring.service.RcpService;
import com.spring.service.RcpServiceImpl;

@Controller
@RequestMapping("/welcome")
public class RecipeServlet extends AbstractController {
	
	@Autowired
	@Qualifier("rcpService")
	private RcpService rcpService;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView model = new ModelAndView("indexTest");
		model.addObject("msg", "hi,Brendan");
		return model;
	}
	
	@GetMapping
	ModelAndView getMessage(){
		
		ModelAndView model = new ModelAndView("indexTest");
		
		List<RecipeVO> list = rcpService.getAll();
		
		model.addObject("msg", list);
		
		return model;
	}
	
}

package com.hanrabong.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanrabong.web.services.EmpService;
import com.hanrabong.web.seviceImpls.EmpServiceImpl;

@Controller
@RequestMapping("/emp/*")
public class EmpController {
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	@Autowired EmpServiceImpl empServiceImpl;
	
	@GetMapping("/count")
	public String count(Model model) {
		int count = empServiceImpl.countEmps();
		model.addAttribute("count", count);
		return "index";
		
	}
	
	@GetMapping("/info")
	public String findEmpByCnum(@RequestParam("cnum") String name) {
		
		return null;
	}
}

package com.hanrabong.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanrabong.web.domains.HCustDTO;
import com.hanrabong.web.seviceImpls.HCustServiceImpl;

@Controller
@RequestMapping("/hcust/*")
public class HCustController {
	private static final Logger logger = LoggerFactory.getLogger(HCustController.class);
	@Autowired HCustServiceImpl hCustServiceImpl;

	@GetMapping("/count")
	public String count(Model model) {
		int count = hCustServiceImpl.countHCusts();
		model.addAttribute("count", count);
		return "index";
	} 
	
	@PostMapping("/join")
	public @ResponseBody Map<?,?> join(@RequestBody HCustDTO hcust) {
		Map<String, String> map = new HashMap<>();
		map.put("cid", hcust.getCid());
		map.put("cpw", hcust.getCpw());
		logger.info("Ajax가 보내서 map에 담은 아이디와 비번{}", map.get("cid")+", "+map.get("cpw"));
		return map;
	} 
	
	@GetMapping("/info")
	public String findHCustByCNum(@RequestParam("cnum") String name) {
		return null;
	}
}

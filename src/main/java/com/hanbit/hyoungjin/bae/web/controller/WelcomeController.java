package com.hanbit.hyoungjin.bae.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("name","hanbit");
		return "welcome";		//return이 이름이 되는거고
	}

	@RequestMapping("/api/data")
	@ResponseBody					//data 받고싶을때. return 이 view자체가 되는거
	public Map getData(){
		Map map = new HashMap();

		map.put("name", "Hanbit");
		map.put("message", "Hello");

		return map;
	}
}

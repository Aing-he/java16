package com.turing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turing.entity.Emp;
import com.turing.service.EmpService;

@Controller
public class AjaxController {
	// ×¢ÈëÒµÎñ²ã
	@Autowired
	private EmpService empService;

	@RequestMapping(value = "/test1")
	@ResponseBody
	public String test1() {
		return "Holle Ajax";
	}

	@RequestMapping(value ="/getemps")
	@ResponseBody
	public List<Emp> list(Model model) {
		return empService.findAll();

	}

	@RequestMapping(value ="/regist")
	@ResponseBody
	public int regist(Emp emp) {
		return empService.addEmp(emp);
	}
}

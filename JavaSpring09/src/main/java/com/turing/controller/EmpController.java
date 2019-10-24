package com.turing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.entity.Emp;
import com.turing.service.EmpService;

@Controller
public class EmpController {

	//×¢ÈëÒµÎñ²ã
	@Autowired
	private  EmpService empService ;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Emp> list = empService.findAll();
		model.addAttribute("list",list);
		return "show";
	}
}

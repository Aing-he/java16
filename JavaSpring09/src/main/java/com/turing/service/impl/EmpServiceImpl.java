package com.turing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.entity.Emp;
import com.turing.mapper.EmpMapper;
import com.turing.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<Emp> findAll() {
		return empMapper.selectByExample(null);
	}

	@Override
	public int addEmp(Emp emp) {
		
		return empMapper.insertSelective(emp);
	}

}

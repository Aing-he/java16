package com.turing.service;

import java.util.List;

import com.turing.entity.Emp;

/**
 * 业务接口层
 * @author Aing
 *
 */
public interface EmpService {
	
	List<Emp> findAll();
	
	int addEmp(Emp emp);
}

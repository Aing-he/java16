package com.turing.service;

import java.util.List;

import com.turing.entity.Emp;

/**
 * ҵ��ӿڲ�
 * @author Aing
 *
 */
public interface EmpService {
	
	List<Emp> findAll();
	
	int addEmp(Emp emp);
}

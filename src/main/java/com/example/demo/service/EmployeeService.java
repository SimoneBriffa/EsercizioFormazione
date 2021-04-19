package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends AbstractService<Employee>{
	
	@Autowired
	EmployeeDAO dao;
	
	@Transactional
	public void requestItem(int employeeId, int itemId) {
		
		System.out.format("Sono al service con %d e %d", employeeId, itemId);
		dao.requestItem(employeeId, itemId);
	}
	
	
}

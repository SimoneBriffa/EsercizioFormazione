package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController extends AbstractController<Employee>{
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/request/{info}")
	private void requestItem(@PathVariable("info") String info) {
		
		String[] pieces = info.split("_");
		int employeeId = Integer.parseInt(pieces[0]);
		int itemId = Integer.parseInt(pieces[1]);
		
		System.out.println(employeeId + "/" + itemId);
		
		service.requestItem(employeeId, itemId);
		
		
		
	}
	
}

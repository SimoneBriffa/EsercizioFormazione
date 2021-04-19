package com.example.demo.controller;


import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class AbstractController<DTO>{

	@Autowired
	private Service<DTO> service;
	
	@GetMapping("/getall")
	public List<DTO> getAll(){
		return service.getAll();		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
	
	@PutMapping("/update")
	public DTO update(@RequestBody DTO dto){
		service.update(dto);
		return dto;
	}
	
	@PostMapping("/insert")
	public DTO insert (@RequestBody DTO dto) {
		service.insert(dto);
		return dto;
	}
	
	@GetMapping("/read/{id}")
	public DTO read(@PathVariable("id") int id) {
		return service.read(id);
	}
	
	
	
}
package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;


@RestController
@RequestMapping("/item")
public class ItemController extends AbstractController<Item> {
	
	
}

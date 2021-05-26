package com.cysout.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cysout.springboot.app.item.dto.ItemDto;
import com.cysout.springboot.app.item.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	//@Qualifier("serviceRestTemplate")
	@Qualifier("serviceFeign")
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<ItemDto> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/amount/{amount}")
	public ItemDto detalle(@PathVariable Long id, @PathVariable Integer amount) {
		return itemService.findById(id, amount);
	}
	
}

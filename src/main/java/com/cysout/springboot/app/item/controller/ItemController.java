package com.cysout.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cysout.springboot.app.item.dto.ItemDto;
import com.cysout.springboot.app.item.dto.ProductDto;
import com.cysout.springboot.app.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

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
	
	//Implementa al recibir el erro
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/amount/{amount}")
	public ItemDto detalle(@PathVariable Long id, @PathVariable Integer amount) {
		return itemService.findById(id, amount);
	}
	
	//Esta funcion seria el camino alternativo
	public ItemDto metodoAlternativo(Long id, Integer amount) {
		ItemDto item = new ItemDto();
		ProductDto product = new ProductDto();
		item.setAmount(amount);
		product.setId(id);
		product.setName("Default product");
		product.setPrice(0.0);
		item.setProduct(product);
		return item;
	}
	
}

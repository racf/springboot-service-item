package com.cysout.springboot.app.item.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cysout.springboot.app.item.dto.ProductDto;

@FeignClient(name = "service-products")
public interface ProductClientRest {
	
	@GetMapping("/listar")
	public List<ProductDto> listar();
	
	@GetMapping("/detalle/{id}")
	public ProductDto detalle(@PathVariable Long id);
}

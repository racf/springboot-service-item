package com.cysout.springboot.app.item.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cysout.springboot.app.item.dto.ItemDto;
import com.cysout.springboot.app.item.dto.ProductDto;
import com.cysout.springboot.app.item.service.ItemService;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<ItemDto> findAll() {
		List<ProductDto> products = Arrays.asList(clienteRest.getForObject("http://service-products/listar", ProductDto[].class));
		return products.stream().map(p -> new ItemDto(p, 1)).collect(Collectors.toList());
	}

	@Override
	public ItemDto findById(Long id, Integer amount) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		ProductDto product = clienteRest.getForObject("http://service-products/detalle/{id}", ProductDto.class, pathVariables);
		return new ItemDto(product, amount);
	}

}

package com.cysout.springboot.app.item.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cysout.springboot.app.item.client.ProductClientRest;
import com.cysout.springboot.app.item.dto.ItemDto;
import com.cysout.springboot.app.item.service.ItemService;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService{
	
	@Autowired
	private ProductClientRest clienteFeign;
	
	@Override
	public List<ItemDto> findAll() {
		return clienteFeign.listar().stream().map(p -> new ItemDto(p, 1)).collect(Collectors.toList());
	}

	@Override
	public ItemDto findById(Long id, Integer amount) {
		return new ItemDto(clienteFeign.detalle(id), amount);
	}

}

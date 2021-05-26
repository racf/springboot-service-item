package com.cysout.springboot.app.item.service;

import java.util.List;

import com.cysout.springboot.app.item.dto.ItemDto;

public interface ItemService {
	public List<ItemDto> findAll();
	public ItemDto findById(Long id, Integer amount);
}

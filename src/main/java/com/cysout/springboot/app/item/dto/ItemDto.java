package com.cysout.springboot.app.item.dto;

public class ItemDto {
	private ProductDto product;
	private Integer amount;
	
	public ItemDto() {
		
	}
	public ItemDto(ProductDto product, Integer amount) {
		this.product = product;
		this.amount = amount;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Double getTotal() {
		return product.getPrice() * amount.doubleValue();
	}
}

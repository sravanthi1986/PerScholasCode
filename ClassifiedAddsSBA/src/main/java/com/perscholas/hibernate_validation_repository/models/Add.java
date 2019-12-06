package com.perscholas.hibernate_validation_repository.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Add {
	@Id
	@GeneratedValue
	private Integer addId;
	
	@Size(min=2, max=50,  message="Item name must be between 2 and 50 characters long.")
	@NotBlank(message="Item name is required.")
	private String item;
	
	private Double price;
	
	private Integer status;

	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}

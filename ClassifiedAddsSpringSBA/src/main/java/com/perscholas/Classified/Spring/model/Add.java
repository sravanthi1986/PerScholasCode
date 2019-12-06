package com.perscholas.Classified.Spring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Add {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=5, max=20,  message="Item must be between 2 and 20 characters long.")
	@NotBlank(message="Item Name is required.")
	private String item;
	
	@Size(min=4, max=50,  message="Price must be between 4 and 50 characters long.")
	@NotBlank(message="price is required.")
	private Double price;

	private Boolean status;
	
	public Add() {}
	
	public Add(int id, String item, Double price, Boolean status) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
     
}

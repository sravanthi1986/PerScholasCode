package org.perscholas7;

public class Car {
	private Integer ID;
	private Double price;
	private String description;

	public Car() {
	}

	public Car(Integer ID, Double price, String description) {
		this.ID = ID;
		this.price = price;
		this.description = description;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;

	}
	
	public Double caliculatePrice() {
		System.out.println("in Car==="+this.getDescription());
		return this.getPrice();
	}

}

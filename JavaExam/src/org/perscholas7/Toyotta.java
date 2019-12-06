package org.perscholas7;

public class Toyotta extends Car {


	public Toyotta() {
		super();
		this.setID(2);
		this.setPrice(25000.00);
		this.setDescription("Toyota");
	}

	public Toyotta(Integer ID, Double price, String description) {
		super(ID,20000.00,"Nissan");

	}

	@Override
	public Double caliculatePrice() {
		//System.out.println("in Toyotta class");
		return this.getPrice();
	}

}

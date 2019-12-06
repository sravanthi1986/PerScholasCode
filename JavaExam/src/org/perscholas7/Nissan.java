package org.perscholas7;

public class Nissan extends Car {


	public Nissan() {
		super();
		this.setID(1);
		this.setPrice(20000.00);
		this.setDescription("Nissan");
	}

	public Nissan(Integer ID, Double price, String description) {
		super(ID,20000.00,"Nissan");

	}
	
  @Override
	public Double caliculatePrice() {
	  //System.out.println("in Nissan class");
	  return this.getPrice();
	  
	}

}

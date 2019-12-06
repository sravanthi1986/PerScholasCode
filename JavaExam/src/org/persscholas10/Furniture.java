package org.persscholas10;

public abstract class Furniture {

	public Integer productId;
	public String productName;
	public Integer productPrice;
	public String productColor;
	public Integer productQuantity;
    
	abstract Integer caliculatePrice();

}

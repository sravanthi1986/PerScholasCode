package org.persscholas10;

public class Chair extends Furniture{
	private String type;
	private Boolean isCustomColor;
	
	public Chair(){
		
	}
    public Chair(Integer productId, String productName, Integer productPrice, String productColor,Integer productQuantity,String type,Boolean customColor){
		this.type = type;
		this.isCustomColor = customColor;
	}
    
    public Chair(int productPrice, Boolean isCustomColor,int quantity){
		this.productPrice = productPrice;
		this.isCustomColor = isCustomColor;
		this.productQuantity = quantity;

  }
	
	@Override
	public Integer caliculatePrice(){
		if(this.isCustomColor){
			return (this.productQuantity*this.productPrice)+60;
		}else
			return (this.productQuantity*this.productPrice);	
	}

}

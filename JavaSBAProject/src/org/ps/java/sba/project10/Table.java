package org.ps.java.sba.project10;

public class Table extends Furniture{
	private String shape;
	private Integer length;


	public  Table(){
	
	}
	
  public  Table(Integer productId, String productName, Integer productPrice, String productColor,Integer productQuantity,String shape, Integer length){
		this.shape = shape;
		this.length = length;
		this.productId = productId;		
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;

}
  
  public  Table(int productPrice, int length,int productQuantity){
		this.length = length;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;

  }
  
  public  Table(int productPrice, int length){
		this.length = length;
		this.productPrice = productPrice;

 }
	
	@Override
	public Integer caliculatePrice(){
		return this.productPrice*this.productQuantity;
	}

}

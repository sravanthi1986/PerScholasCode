package org.ps.java.sba.project10;

public class FurnitureApp {
	
	private static final int TAX = 10;

	public static void main(String[] args) {
		Table table1 = new Table(200,60,1); // price,length and quantity are parameters
		System.out.println("60 inches Table(s) Price =of Quantity====>"+table1.productQuantity+"="+table1.caliculatePrice());
		int tablePrice = table1.caliculatePrice();
		Chair chair = new Chair(150,true,1);
		System.out.println("Chair(s) Price With custom color =of Quantity==> "+chair.productQuantity+" ="+chair.caliculatePrice());
		int chairPrice = chair.caliculatePrice();
		int subTotal = tablePrice+chairPrice;
		System.out.println("Tax ====> $"+TAX);
		int total = subTotal+ TAX;
		System.out.println("Total ====> $"+total);
	}

}

package org.perscholas7;

import java.util.Scanner;

public class CarApp {
	
	public static void main(String[] a) {
		final Double SALES_TAX = 0.06;
		final Double TITLE_FEE = 150.00;
		final Double LICENSE_FEE = 0.015;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select Car from the below list!");
		System.out.println("1: Nissan");
		System.out.println("2: Toyotta");
		Car car = null;
		int userOption = scanner.nextInt();
		System.out.println("Selected Option :"+userOption);
		if(userOption ==1 ) {
			car = new Nissan();
		} else if(userOption ==2 ) {
			car = new Toyotta();
			
		}
		Double price = car.caliculatePrice();
		System.out.printf("Name: %s\nSubtotal:%.2f\n", car.getDescription(), price);
		Double transactionTax = price * SALES_TAX;
		Double licenceFee = price * LICENSE_FEE;
		Double Total = price + transactionTax + licenceFee+ TITLE_FEE;
		System.out.printf("Tax:%.2f\nLicence Fee:%.2f\nTitle Fee:%.2f\nTotal:%.2f\n",  transactionTax, licenceFee,TITLE_FEE,Total);
		scanner.close();
	}

}

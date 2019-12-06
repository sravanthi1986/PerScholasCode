package org.perscholas;

import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int x;
		String n;
		System.out.println("Enter Name");
		n=obj.next();
		System.out.println("Enter number:");
		x=obj.nextInt();
		
		//closing scanner
		
		while(x<=10) 
			System.out.println("Enter number:");
			x=obj.nextInt();
	
		if(x>10) {
			
	      System.out.println("result is " +(x*5));
		}
	
		
	}

}

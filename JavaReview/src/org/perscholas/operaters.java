package org.perscholas;

import java.util.Scanner;

public class operaters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner obj=new Scanner(System.in);
		int a,b;
		System.out.println("Enter 1st value:");
		a=obj.nextInt();
		System.out.println("Enter 2nd value:");
		b=obj.nextInt(); 
		//closing scanner
		obj.close();
		if(a>b) {
			System.out.println(a +"a is gareter than b" + b);
		}
		else 
			System.out.println(b +"b is greater" + a);*/
		Scanner obj=new Scanner(System.in);
		int x;
		System.out.println("Enter number:");
		x=obj.nextInt();
	
		//closing scanner
		obj.close();
		if(x%2==0) {
			System.out.println("number is even");
		}
		else
		System.out.println("number is odd");
	}

}

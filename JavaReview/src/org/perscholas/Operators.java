package org.perscholas;

import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int a,b;
		System.out.println("Enter a:");
		a=obj.nextInt();
		System.out.println("Enter b:");
		b=obj.nextInt(); 
		//closing scanner
		obj.close();
       //declaring
		//int a,b;
		//intialization(delcare in begain if you doing later on the app that is called asigining)
		//a=1;
		//b=7;
		System.out.println("adding result " + (a+b));
		System.out.println("sub is " + (b-a));
		System.out.println("div " + (b/a));
		System.out.println("mul is " + (a*b));
		
        
		
		
	}

}

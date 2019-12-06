package org.platform.firstproject;

public class Hello {
	
	public static void main(String[] a) {
		//Print p = new Print();
		//System.out.println("My First Program ==========> "+p.add(1, 2));
		printEven(10);
	}
	
	private static void printEven(int num) {
		for(int i=0;i<=num;i++)
		{
			if(i%2==0) {
				System.out.println("Printing Even NUM=====>" +i);
		}
		
	}
	}

}


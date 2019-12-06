package com.perscholas.java_algorithms;

import java.util.Arrays;
import java.util.List;

class Main {

	public static void main(String[] a) {
		String[] cars = {"Nissan", "Toyotta", 
                "Tesla", "Accura"}; 
 
		List<String> list = Arrays.asList(cars); 
		System.out.println("List======>"+list.size()+list+list.get(0));
		
		Stack stack = new Stack(5);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		System.out.println("1. Size of stack after push operations: " + stack.size());

		System.out.printf("2. Pop elements from stack : ");
		while (!stack.isEmpty()) {
			System.out.printf(" %d", stack.pop());
		}

		System.out.println("\n3. Size of stack after pop operations : " + stack.size());
	
	}
	
	

}

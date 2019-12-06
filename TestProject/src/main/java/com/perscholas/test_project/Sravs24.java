package com.perscholas.test_project;


	import java.util.Arrays;
	import java.util.Scanner;

	public class Sravs24 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);  // Create a Scanner object
	System.out.println("Enter Student s Marks here:");
	int marks[]=new int[24];
	// Initialize sum and count of input elements
	        int count = 0;
	 
	        // Check if an int value is available
	        while (count<= marks.length-1 && sc.hasNextInt())
	        {
	            // Read an int value
	            int num = sc.nextInt();
	            marks[count] = num;
	            count++;
	        }
	        System.out.println("Array: " + Arrays.toString(marks));
	        Arrays.sort(marks);
	        System.out.println("Sorted Array: " + Arrays.toString(marks));
	        int min = Arrays.stream(marks).min().getAsInt();
	        int max = Arrays.stream(marks).max().getAsInt();
	        System.out.println("Min = " + min);
	        System.out.println("Max = " + max);

	}
	}



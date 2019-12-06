package org.perscholas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class arrayminmax {
public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Size of arr:");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Array Size: " + size);
		
		for(int i = 0; i < size; i++) {
			arr[i] = random.nextInt(851);
		}
		
		arr = sort(arr);
		
		
		
		System.out.println(Arrays.toString(arr));
		System.out.println("difference: " + (arr[size -1] - arr[0]));
		
		System.out.println("Select opperator:");
		System.out.print("\nequal to (=)"
				+ "\ngreater than (>)"
				+ "\nless than (<)");
		
		System.out.println("input:");
		String input = scanner.next();
		
		System.out.println(input + " matches what value?");
		int value = scanner.nextInt();
		
		boolean valid = false;
		while(!valid) {
			if(input.equals("=")) {
				valid = true;
				System.out.println(hasEqual(arr, value));
				
			}else if(input.equals(">")) {
				valid = true;
				System.out.println(hasGreater(arr, value));
				
			}else if(input.equals("<")) {
				valid = true;
				System.out.println(hasLesser(arr, value));
			}
		}
		
		scanner.close();
	}
	
	public static boolean hasEqual(int[] arr, int value) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value)
				return true;
		}
		return false;
	}
	
	public static String hasGreater(int[] arr, int value) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > value)
				output.add(arr[i]);
		}
		
		return output.toString();
	}
	
	public static String hasLesser(int[] arr, int value) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < value)
				output.add(arr[i]);
		}
		
		return output.toString();
	}
	
	public static int[] sort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int former = arr[j];
					int later = arr[j+1];
					
					arr[j] = later;
					arr[j+1] = former;
				}
			}
		}
		
		return arr;
	}

}

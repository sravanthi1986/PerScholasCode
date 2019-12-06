package org.perscholas;

import java.util.Scanner;

import com.sun.javafx.binding.StringFormatter;

public class CapitalWord {

	public static void main(String[] args){
		 Scanner sc = new Scanner(System.in);
	     System.out.print("Enter a Sentence: ");
		 String line = sc.nextLine();
		 String upper_case = ""; 
	       Scanner Scan = new Scanner(line); 
	         while(Scan.hasNext()) {
	             String word = Scan.next(); 
	             upper_case += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " "; 
	         }
	      System.out.println(upper_case); 
	    }
	}

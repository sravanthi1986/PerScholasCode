/**
 * 
 */
package org.ps.java.sba;

import java.util.Scanner;

public class Project4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// Define list of options 
			String[] options = {"Good Morning !!","Good Afternoon !!","Good Evening !!","Good Night !!"};

			int option = sc.nextInt(); // read the user input
			if(option > 4 || option < 1){ // check for available option
				System.out.println("We are Sorry. Option is not availble");
			}else
			System.out.println(options[option-1]);
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			sc.close();
		}
	}

}

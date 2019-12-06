/**
 * 
 */
package org.perscholas4;

import java.util.Scanner;

public class Project4 {


		public static void main (String[] arg) {
		    Scanner s = new Scanner(System.in);
		    String mainMenu = ("Select a choice from the menu: \n"
		            + "1\n"
		            + "2\n"
		            + "3\n"
		            + "4\n");
		            System.out.println(mainMenu);
		    int menuChoice = s.nextInt();
		    while (menuChoice < 1 || menuChoice > 4) {
		        System.out.print("\nError! Incorrect choice.\n");
		        System.out.println(mainMenu);
		        menuChoice = s.nextInt();
		    }
		    switch (menuChoice) {
		    case 1: {
		            System.out.print("GOOD MORNING.\n");
		            return;
		        }
		   
		    case 2: {
		        System.out.print("GOOD AFTERNOON.\n");
		        return;
		    }
		    case 3: {
		        System.out.print("GOOD EVENING.\n");
		        return;
		    }
		   
		    case 4: {
		        System.out.print("GOOD NIGHT.\n");
		        System.exit(0);
		        return;
		    }
		    }
		}
	}

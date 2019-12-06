/**
 * 
 */
package org.ps.java.sba;

import java.util.Scanner;

public class Project3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// Course course2 = new Course(1,"Java","Java Programming");
			// System.out.println(course2);
			// System.out.println("Enter Course Id");
			int id = sc.nextInt();
			// System.out.println("Enter Course Name");
			String name = sc.nextLine();
			// System.out.println("Enter Course Description");
			String description = sc.nextLine();
			Course course = new Course(id, name, description);
			System.out.println(course);
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			sc.close();
		}
	}

}

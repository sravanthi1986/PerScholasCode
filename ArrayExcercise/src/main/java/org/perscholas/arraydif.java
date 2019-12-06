package org.perscholas;

import java.util.Scanner;

public class arraydif {
	public static void main(String[] args) {
		int n, temp;
		// scanner class object creation
		Scanner s = new Scanner(System.in);

		// input total number of elements to be read
		System.out.print("Enter the size of array : ");
		n = s.nextInt();

		// integer array object
		int a[] = new int[n];

		// read elements
		System.out.println("Enter all the elements in the array:");
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}

		// sorting elements
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		// print sorted elements
		System.out.println("sorting the array in Ascending Order:");
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
        System.out.println("min="+a[0]);
		System.out.println("max="+a[n-1]);
		System.out.println("dif="+((a[n-1])-a[0]));
	}
	

}


package com.perscholas.java_algorithms;

public class StringMain {

	public String[] returnWords() {
		String demo = "Hello 2019 QE";
		String[] strArr = demo.split(" ");
		return strArr;
	}

	public static void main(String[] args) {

		String demo = "Hello 2019 QE";

		String[] strArr = demo.split(" ");
		for (String str : strArr) {
			System.out.println(str);
		}

		String demo1 = demo.concat("World");
		System.out.println(demo1);
		System.out.println(demo.contains("Hello"));
		System.out.println(demo.subSequence(2, 9));

	}

}
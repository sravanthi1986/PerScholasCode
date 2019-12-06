package com.perscholas;


public class StringAlg {
	public static void main(String[] args) {
		StringAlg sa=new StringAlg();
		String demo="hello world 2000";
		String[] strarr=demo.split(" ");
		for(String str: strarr) {
			System.out.println(str);
		}
		

}}
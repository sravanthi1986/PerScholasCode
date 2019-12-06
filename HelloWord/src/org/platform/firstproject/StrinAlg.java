package org.platform.firstproject;

public class StrinAlg {
	
	public static void main(String[] args) {
		StrinAlg sa=new StrinAlg();
		String demo="hello world 2000";
		String[] strarr=demo.split(" ");
		for(String str: strarr) {
			System.out.println(str);
		}
		
		
		//String demo1=demo.concat("quite world");
		//System.out.println(demo.contains("hello"));
		//System.out.println(demo.subSequence(2, 9));
		//System.out.println(demo1);
		
	}

}

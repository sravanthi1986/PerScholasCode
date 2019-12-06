package org.platform.firstproject;

public class FizBiz {

	public static void main(String[] a) {
		
		for(int i=1;i<=100;i++) {
			if(i%3 == 0) {
				if(i%5 == 0) {
				System.out.println(i+"+++++++++Fizz-Buzz+++++++++");
				}else {
					System.out.println(i+"Fizz");
				}
			}else if(i%5 == 0) {
				System.out.println(i+"Buzz");
			}else
				System.out.println("*******Number********"+i);
		}
		
		
		/*for(int i=1;i<=100;i++) {
			
			if(i%3 == 0 && i%5 == 0) {
				System.out.println(i+"+++++++++Fizz-Buzz+++++++++");
			}else if(i%5 == 0) {
				System.out.println(i+"Buzz");
			}else if(i%3 == 0) {
				System.out.println(i+"fizz");
			}else
 			 System.out.println("*******Number********"+i);
		}*/
		
		
	}
}

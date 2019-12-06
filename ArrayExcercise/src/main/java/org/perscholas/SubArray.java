package org.perscholas;

import java.util.Arrays;

public class SubArray {
	public static void main(String args[]) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		int subarraySize = 7;
		int b=a.length;
		int c=b/subarraySize;
		System.out.println(b);
		System.out.println(c);
		int beginIndex=0;
        for(int iteration=1; iteration<=c;iteration++) {
        	
        	 int[] e =Arrays.copyOfRange(a, beginIndex, iteration*subarraySize);
             System.out.println(Arrays.toString(e));
             beginIndex = (iteration*subarraySize);
             
        }
        
        int remain = b - (c*subarraySize);
        System.out.println("remain======"+remain);
        if(remain != 0) {      
        	
          int[] e =Arrays.copyOfRange(a, beginIndex, b);
          System.out.println(Arrays.toString(e));
        }
		
	}
}

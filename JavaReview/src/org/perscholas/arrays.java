package org.perscholas;

import java.util.Scanner;

public class arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*  int[] arr= {1,4,5,6};
          for(int i=0;i<arr.length-1;i++)
          System.out.println(arr[i]+arr[i+1]);*/
		/*int[] arr1= {1,4,5,6};
		int[] arr2= {3,7,8,10};
		//int[] results= {0,0,0,0};or
		int[] results=new int[4];
		for(int i=0;i<arr1.length;i++) {
	      results[i]=arr1[i]+arr2[i];
				System.out.println(results[i] + "");
		
		
		  }*/
		/*int[] arr1= {1,4,5,6};
		int[] arr2= {3,7,8,10};
		//int[] results= {0,0,0,0};or
		int[] results=new int[4];
		for(int i=0,j=3;i<arr1.length;i++,j--) {
	      results[i]=arr1[i]+arr2[j];
				System.out.println(results[i] + "");
		
 
		}*/
     
       int[][] d2arr=new int[3][4];
       Scanner scan=new Scanner(System.in);
       System.out.println(d2arr.length+" " +d2arr[0].length);
	
       for(int r=0;r<d2arr.length;r++) {
    	   for(int c=0;c<d2arr.length;c++) {
    		   
    		   System.out.println("enetr a values@[" + r + "," + c +"]");
    		   d2arr[r][c]=scan.nextInt();
    	   }
    	   
       }
       for(int i[]:d2arr)
    	   for(int j:i)
    		   System.out.println(j);
       
	}}



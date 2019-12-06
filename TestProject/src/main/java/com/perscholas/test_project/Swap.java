package com.perscholas.test_project;
import java.util.Arrays;

	public class Swap {
	public static void main(String[] args) {
	int[] Bil={9,7,3,6,2};


	         for(int i=0;i<Bil.length;i++){
	             for(int j=Bil.length-1;j>i;j--){
	                   if(Bil[j-1]>Bil[j]){
	                     int temp=Bil[j];
	                         Bil[j]=Bil[j-1];
	                         Bil[j-1]=temp;
	
	                   }
	             }
	         
	
	System.out.println(Bil[i]);
	         }
	

	         }
	         }



package org.perscholas9;

	
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class JavaSBAProject_09 {


	    public static void main(String[] args) {

	        String csvFile = "student.csv";
	        String line = "";
	        String cvsSplitBy = ",";
	        List<String> names = new ArrayList<String>();
	        Scanner sc = new Scanner(System.in);
	        try {
	       
	        BufferedReader br = new BufferedReader(new FileReader(csvFile));

	            while ((line = br.readLine()) != null) {
	            //System.out.println(line);
	            names.add(line);

	               
	            }
	           
	            System.out.println(names);
	           
	            for(String name: names){
	           
	            System.out.print("Enter Marks for "+name+ ":");
	            int marks = sc.nextInt();          
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    

	}

}

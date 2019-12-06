package org.perscholas;

public class stringsjava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="welcome to QE";
		String[] arrstr= str.split(" ");
		
		
		for(int i=0;i<arrstr.length;i++)
			System.out.println(arrstr[i]);
		
		for(String c : arrstr)
			System.out.println(c);
	}

}

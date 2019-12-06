package org.perscholas.oops;

public class qe extends person {
  String p1;
  public void FindBug(String code){
	  if(code.equals("Error"))
		  System.out.println("find a bug");
	  else 
		  System.out.println("clean code");
  }
  public void Eat(String s,int y) {
	  System.out.println(s+ " " +y);
  }
  public void Eat(String s) {
	  System.out.println(s);
  }
  
}

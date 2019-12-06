package org.perscholas.junit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathHam {
      public int add(int a,int b) {
    	  return a+b;
      }
      public int sub(int a,int b) {
    	  return a-b;
      }
      public int mul(int a,int b) {
    	  return a*b;
      }
      
      public List<Integer> listClass() {
      List<Integer> arr = Arrays.asList(5, 2, 4);
      
      return arr;
      } 
      
      
      public Map<Integer, Integer> mapmath() {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
      map.put(10, 20); 
      map.put(15, 12); 
      map.put(20, 34); 
      map.put(25, 11); 
      map.put(30, 54); 
     // Getting the value of 25 
      return map; 
     
  } 

}

package com.perscholas.java_algorithms;
import java.util.LinkedList;
import java.util.Queue;
public class BasicQueue {
	
	  public static void main(String[] args) {
	        // Create and initialize a Queue using a LinkedList
	        Queue<String> qu = new LinkedList<>();

	        // Adding new elements to the Queue (The Enqueue operation)
	        qu.add("Rajeev");
	        qu.add("Chris");
	        qu.add("John");
	        qu.add("Mark");
	        qu.add("Steven");

	        System.out.println("Elements in Queue : " + qu);

	        // Removing an element from the Queue using remove() (The Dequeue operation)
	        // The remove() method throws NoSuchElementException if the Queue is empty
	        String name = qu.remove();
	        System.out.println("Removed from Queue : " + name + " | New Queue : " + qu);

	        // Removing an element from the Queue using poll()
	        // The poll() method is similar to remove() except that it returns null if the Queue is empty.
	        name = qu.poll();
	        System.out.println("Removed from Queue : " + name + " | New Queue : " + qu);
	    }
	}



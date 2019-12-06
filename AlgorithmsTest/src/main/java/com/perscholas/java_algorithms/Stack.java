package com.perscholas.java_algorithms;

import java.util.EmptyStackException;

public class Stack {

	private int arr[];
	private int size;
	private int index = 0;

	public Stack(int size) {
		this.size = size;
		arr = new int[size];
	}
	
	//Push: Add element to the Stack
	public void push(int element) {
		if (isFull()) {
			throw new StackOverflowError("Stack is full");
		}
		arr[index] = element;
		index++;
	}
	
	//Pop: Remove element from the Stack
	public int pop() {

		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return arr[--index];
	}
	
	//IsEmpty: Check if the Stack is empty
	public boolean isEmpty() {
		if (index == 0) {
			return true;
		}
		return false;
	}

	//isFull: Check if the Stack is full
	public boolean isFull() {
		if (index == size) {
			return true;
		}
		return false;
	}

	//size: Return the size of the stack (number of elements)
	public int size() {
		return index;
	}
	public int[] getStackValues() {
		return this.arr;
	}
	
}
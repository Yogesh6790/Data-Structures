package com.stackandqueue;

import java.util.NoSuchElementException;

public class SingleArrayToImplement3Stacks {

	int[] size;
	int values[];
	int[] index;
	int capacity;
	
	SingleArrayToImplement3Stacks(int totalSize, int capacity) {
		this.size = new int[totalSize];
		this.values = new int[totalSize * capacity];
		this.index = new int[totalSize];
		this.capacity = capacity;
	}
	
	private void push(int stackNumber, int data){
		if(size[stackNumber] < this.capacity){
			values[stackNumber+index[stackNumber]] = data;
			index[stackNumber] += 3;
			size[stackNumber]++;
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	private int pop(int stackNumber){
		if(isEmpty(stackNumber)){
			throw new NoSuchElementException();
		}
		int val = values[index[stackNumber]-3+stackNumber];
		values[index[stackNumber]] = 0;
		index[stackNumber] -= 3;
		size[stackNumber]--;
		return val;
	}
	
	private int peek(int stackNumber){
		if(isEmpty(stackNumber)){
			throw new NoSuchElementException();
		}
		return values[index[stackNumber]-3+stackNumber];		
	}
	
	private boolean isEmpty(int stackNumber){
		return size[stackNumber] == 0;
	}

	public static void main(String[] args) {
		SingleArrayToImplement3Stacks stack = new SingleArrayToImplement3Stacks(
				3, 5);
		stack.push(0, 1);
		stack.push(0, 2);
		stack.push(0, 3);
		stack.push(0, 4);
		
		stack.push(1, 7);
		stack.push(1, 8);
		stack.push(1, 9);
		stack.push(1, 0);
		
		stack.push(2, 5);
		stack.push(2, 6);
		stack.push(2, 15);
		stack.push(2, 16);
		
		System.out.println(stack.peek(0));
		System.out.println(stack.peek(1));
		System.out.println(stack.peek(2));
		
		System.out.println(stack.pop(0));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(2));
		
		System.out.println(stack.peek(0));
		System.out.println(stack.peek(1));
		System.out.println(stack.peek(2));
		
		System.out.println(stack.pop(0));
		System.out.println(stack.pop(2));
		
		System.out.println(stack.peek(0));
		System.out.println(stack.peek(1));
		System.out.println(stack.peek(2));
	}
}

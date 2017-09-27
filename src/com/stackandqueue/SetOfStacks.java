package com.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class SetOfStacks {
	List<Stack> list;
	int capacity;
	
	SetOfStacks(int capacity){
		this.capacity = capacity;
		list = new ArrayList<>();
	}
	
	private void push(int data){
		if(list.size() == 0 || list.get(list.size()-1).size() == this.capacity){
			list.add(new Stack());
		}
		list.get(list.size()-1).push(data);
	}
	
	private int pop(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		int val = (int) list.get(list.size()-1).pop();
		if(list.get(list.size()-1).size() == 0){
			list.remove(list.size()-1);
		}
		return val;
	}
	
	private int peek(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		return (int) list.get(list.size()-1).peek();
	}
	
	private boolean isEmpty(){
		return list.size() == 0;
	}

	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks(3);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		System.out.println(stacks.peek());
		System.out.println(stacks.pop());
		System.out.println(stacks.peek());
		System.out.println(stacks.pop());
		System.out.println(stacks.peek());
		System.out.println(stacks.pop());
		System.out.println(stacks.peek());
		System.out.println(stacks.pop());
		System.out.println(stacks.peek());
		System.out.println(stacks.pop());
	}

}

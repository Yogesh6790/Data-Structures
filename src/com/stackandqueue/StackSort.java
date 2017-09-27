package com.stackandqueue;

import java.util.NoSuchElementException;

public class StackSort {

	Node top;

	int size;

	StackSort() {
		size = 0;
		top = null;
	}

	private void push(Node node) {
		if (top == null) {
			top = node;
		} else {
			Node prevNode = null;
			Node temp = top;
			while (temp != null) {
				if (node.data < temp.data) {
					node.next = temp;
					if (prevNode != null) {
						prevNode.next = node;
					}else{
						top = node;
					}
					break;
				} else {
					prevNode = temp;
					if (temp.next == null) {
						temp.next = node;
						break;
					}
					temp = temp.next;
				}
			}
		}
		size++;
	}

	private int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int val = top.data;
		top = top.next;
		size--;
		return val;
	}

	private int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return top.data;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		StackSort obj = new StackSort();
		obj.push(new Node(2));
		obj.push(new Node(3));
		obj.push(new Node(1));
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.push(new Node(2));
		obj.push(new Node(4));
		obj.push(new Node(3));
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.push(new Node(2));
		obj.push(new Node(4));
		obj.push(new Node(5));
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}

}

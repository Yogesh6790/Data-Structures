package com.linkedlist;

public class Node<T> {
	T data;
	Node next;

	Node(T data) {
		this.data = data;
		this.next = null;
	}
	
	public static Node createList(){
		Node root = new Node(5);
		Node temp = root;
		temp.next = new Node(2);
		temp = temp.next;
		temp.next = new Node(1);
		temp = temp.next;
		temp.next = new Node(2);
		temp = temp.next;
		temp.next = new Node(5);
		return root;
	}

}

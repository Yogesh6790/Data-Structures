package com.linkedlist;

import java.util.Stack;

public class ReturnKthElementFromLast {

	public static void main(String[] args) {
		Node root = Node.createList();
		Stack<Node> stack = new Stack<Node>();
		Node iterate = root;
		int size = 0;
		while (iterate != null) {
			stack.push(iterate);
			iterate = iterate.next;
			size++;
		}
		int k = 2;
		int curr = 0;
		Node next = null;
		while (!stack.isEmpty()) {
			curr++;
			if (curr == k) {
				stack.pop();
				if (stack.isEmpty()) {
					root = root.next;
					break;
				}
				stack.peek().next = next;
				break;
			}
			next = stack.pop();
		}
		size--;
		printElements("By Stack",root);
		
		int toRemove = size - k + 1;
		if(toRemove == 1){
			root = root.next;
		}else{
			byList(root,toRemove);
		}
		size--;
		printElements("By List",root);
		
		k = 3;
		curr = 0;
		next = null;
		while (!stack.isEmpty()) {
			curr++;
			if (curr == k) {
				stack.pop();
				if (stack.isEmpty()) {
					root = root.next;
					break;
				}
				stack.peek().next = next;
				break;
			}
			next = stack.pop();
		}
		size--;
		printElements("By Stack",root);
		
		k = 2;
		toRemove = size - k + 1;
		if(toRemove == 1){
			root = root.next;
		}else{
			byList(root,toRemove);
		}
		size--;
		printElements("By List",root);
		
	}

	private static void printElements(String string,Node root) {
		System.out.println(string);
		Node iterate = root;
		while (iterate != null) {
			System.out.println(iterate.data);
			iterate = iterate.next;
		}
		
	}

	private static void byList(Node root, int toRemove) {
		Node iterate = root;
		Node prev = null;
		int curr = 0;
		while (iterate != null) {
			curr++;
			if(toRemove == curr){
				prev.next = iterate.next;
				break;
			}
			prev = iterate;
			iterate = iterate.next;
		}
	}

}

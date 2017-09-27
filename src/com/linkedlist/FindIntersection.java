package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class FindIntersection {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node temp = root;
		temp.next = new Node(2);
		temp = temp.next;
		temp.next = new Node(3);
		temp = temp.next;
		temp.next = new Node(8);
		temp = temp.next;
		temp.next = new Node(9);
		temp =temp.next;
		
		Node root2 = new Node(7);
		temp = root2;
		temp.next = new Node(3);
		temp = temp.next;
		
		Map<Node,Boolean> map = new HashMap<Node,Boolean>();
		while(root != null){
			map.put(root, true);
			root = root.next;
		}
		
		while(root2 != null){
			if(map.get(root2) != null){
				System.out.println(root2.data);
				break;
			}
			root2 = root2.next;
		}
		System.out.println("No intersection");
	}

}

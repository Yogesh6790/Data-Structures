package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnsortedLinkedList {
	public static void main(String args[]) {
		Node root = Node.createList();
		Node iterate = root;
		Map<Integer, Boolean> map = new HashMap<>();
		while (iterate != null) {
			Node prevNode = iterate;
			while (iterate.next != null
					&& map.get((Integer) iterate.next.data) != null) {
				iterate = iterate.next;
			}
			prevNode.next = iterate.next;
			map.put((Integer) iterate.data, true);
			iterate = iterate.next;
		}

		while (root != null) {
			System.out.println(root.data);
			root = root.next;
		}
	}
}

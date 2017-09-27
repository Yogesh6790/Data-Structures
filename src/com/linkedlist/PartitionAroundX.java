package com.linkedlist;

public class PartitionAroundX {

	public static void main(String[] args) {
		Node rootMain = Node.createList();
		Node leftNode = null;
		Node rightNode = null;
		Node start = null;
		Node rightPrevNode = null;
		Node root = rootMain;
		int compareWith = 3;
		while (root != null) {
			if ((int) root.data < compareWith) {
				if (leftNode == null) {
					leftNode = new Node(root.data);
					start = leftNode;
				} else {
					leftNode.next = new Node(root.data);
					leftNode = leftNode.next;
				}
			} else {
				if (rightNode == null) {
					rightNode = new Node(root.data);
					rightPrevNode = rightNode;
				} else {
					rightNode.next = new Node(root.data);
					rightNode = rightNode.next;
				}
			}
			root = root.next;
		}
		if (leftNode != null) {
			leftNode.next = rightPrevNode;
		} else {
			start = rightPrevNode;
		}
		while (start != null) {
			System.out.println(start.data);
			start = start.next;
		}
	}

}

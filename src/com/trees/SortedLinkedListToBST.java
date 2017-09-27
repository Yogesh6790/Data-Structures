package com.trees;

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortedLinkedListToBST {

	static ListNode h;

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode ln = root;
		ln.next = new ListNode(2);
		ln = ln.next;
		ln.next = new ListNode(3);
		ln = ln.next;
		ln.next = new ListNode(4);
		ln = ln.next;
		ln.next = new ListNode(5);
		ln = ln.next;
		ln.next = new ListNode(6);
		ln = ln.next;
		ln.next = new ListNode(7);
		ln = ln.next;
		ln.next = new ListNode(8);
		ln = ln.next;
		ln.next = new ListNode(9);
		ln = ln.next;
		
		TreeNode tn = sortedListToBST(root);
		System.out.println(tn);
	}

	private static TreeNode sortedListToBST(ListNode root) {
		if (root == null) {
			return null;
		}
		h = root;
		int length = getLength(root);
		return sortedListToBST(0, length - 1);
	}

	private static TreeNode sortedListToBST(int start, int end) {
		TreeNode root = null;
		if (start <= end) {
			int mid = (start + end) / 2;
			TreeNode left = sortedListToBST(start, mid - 1);
			root = new TreeNode(h.val);
			h = h.next;
			TreeNode right = sortedListToBST(mid + 1, end);
			root.left = left;
			root.right = right;
		}
		return root;
	}

	private static int getLength(ListNode root) {
		ListNode p = root;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
}

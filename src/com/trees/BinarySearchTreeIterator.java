package com.trees;

import java.util.Stack;

public class BinarySearchTreeIterator {

	private static Stack<TreeNode> stack;

	public static void main(String[] args) {
		TreeNode root = createTree();
		stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		System.out.println(hasNext());
		System.out.println(next());
		System.out.println(next());
	}

	private static int next() {
		TreeNode node = stack.pop();
		int result = node.val;
		node = node.right;
		if (node != null) {
			stack.push(node);
			while (node.left != null) {
				stack.push(node.left);
				node = node.left;
			}
		}
		return result;
	}

	private static boolean hasNext() {
		return !stack.isEmpty();
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(6);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(3);
		root.left.left.right.left = new TreeNode(2);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		return root;
	}

}

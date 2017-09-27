package com.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSum2 {

	private static int k = 22;
	
	public static void main(String[] args) {
		TreeNode root  = createTree();
		Stack<Integer> stack = new Stack<>();
		preOrderTraversal(root,stack,0);

	}

	private static void preOrderTraversal(TreeNode root, Stack<Integer> stack,int sum) {
		stack.push(root.val);
		if(sum + root.val == k){
			System.out.println(stack);
		}
		if(root.left != null){
			preOrderTraversal(root.left, stack, sum + root.val);
			stack.pop();
		}
		if(root.right != null){
			preOrderTraversal(root.right, stack, sum + root.val);
			stack.pop();			
		}
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7); 
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5); 
		root.right.right.right = new TreeNode(1);
		return root;
	}
	
}

package com.trees;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode root  = createTree();
		List<Integer> list = new LinkedList<>();
		preOrderTraversalRecursion(root,list);
		System.out.println(" Recursion "+list);
		
		list = new LinkedList<>();
		preOrderTraversalIteration(root,list);
		System.out.println(" Iteration "+list);
	}

	private static void preOrderTraversalRecursion(TreeNode root,List list) {
		if(root == null){
			return;
		}
		list.add(root.val);
		preOrderTraversalRecursion(root.left,list);
		preOrderTraversalRecursion(root.right,list);
	}

	private static void preOrderTraversalIteration(TreeNode root,List list) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
		
	}
	
	private static TreeNode createTree() {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
//		root.left.right = new TreeNode(1);
		root.left.right = new TreeNode(3);
		return root;
	}

}

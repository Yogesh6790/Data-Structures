package com.trees;

import java.util.ArrayList;
import java.util.List;


public class Traversal {
	
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		preOrderTraversal(root);
		System.out.println("Preorder traversal of 1 2 3: " + list);
		
		list = new ArrayList<Integer>();
		inOrderTraversal(root);
		System.out.println("Inorder traversal of 1 2 3: " + list);
		
		list = new ArrayList<Integer>();
		postOrderTraversal(root);
		System.out.println("Postorder traversal of 1 2 3: " + list);
	}

	private static void preOrderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		list.add(root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	private static void inOrderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		inOrderTraversal(root.left);
		list.add(root.val);
		inOrderTraversal(root.right);
	}

	private static void postOrderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		list.add(root.val);
	}
}

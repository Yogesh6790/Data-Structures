package com.trees;

import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTree {

	private static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		invertTree(root);
		System.out.println(list);
	}

	private static void invertTree(TreeNode root) {
		if(root!=null){
			process(root);
		}
		preOrderTraversal(root);
	}

	private static void preOrderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		list.add(root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
	}

	private static void process(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null){
			process(root.left);
		}
		if(root.right != null){
			process(root.right);
		}
		
	}

}

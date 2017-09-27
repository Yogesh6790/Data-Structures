 package com.trees;

public class LongestConsequencePath {
	
	private static int max = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.left.right = new TreeNode(3);
		preOrderTraversal(root,0);
		System.out.println(max);
	}

	private static void preOrderTraversal(TreeNode root, int i) {
		if(root == null){
			return;
		}
		i++;
		max = Math.max(i, max);
		preOrderTraversal(root.left,i);
		preOrderTraversal(root.right,i);
	}

}

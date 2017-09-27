package com.trees;

public class BalancedBinaryTree {

	private static boolean check = true;

	public static void main(String[] args) {
		TreeNode root = createTree();
		dfs(root);
		System.out.println(check);
	}

	private static int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		if (Math.abs(left - right) > 1) {
			check = false;
		}
		return Math.max(left+1, right+1);
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(31);
		return root;
	}

}

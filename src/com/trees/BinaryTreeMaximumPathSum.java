package com.trees;

public class BinaryTreeMaximumPathSum {
	
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root  = createTree();
		dfs(root);
		System.out.println(max);
	}

	private static int dfs(TreeNode root) {
		int sum = 0;
		if(root != null){
			int leftSum =  dfs(root.left);
			int rightSum = dfs(root.right);
			sum = Math.max(leftSum+root.val, rightSum+root.val);
			max = Math.max(max, leftSum+rightSum+root.val);
		}
		return sum;
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		return root;
	}

}

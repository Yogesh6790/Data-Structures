package com.trees;

public class MaximumDepthOfBinaryTree {

	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		TreeNode root  = createTree();
		dfs(root,0);
		System.out.println(max);
	}
	
	private static void dfs(TreeNode root, int i) {
		if(root != null){
			i++;
			max = Math.max(max, i);
			dfs(root.left,i);
			dfs(root.right,i);
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
		root.right.right.right.left = new TreeNode(10);
		root.right.right.right.left.right = new TreeNode(19);
		root.right.right.right.left.right.left = new TreeNode(22);
		return root;
	}

}

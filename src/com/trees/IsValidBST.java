package com.trees;

public class IsValidBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.left.right = new TreeNode(1);
		//root.left.right = new TreeNode(3);
		System.out.println(preOrderTraversal(root));
	}

	private static boolean preOrderTraversal(TreeNode root) {
		if(root == null){
			return true;
		}
		if(!((root.left == null || root.left.val < root.val) && (root.right == null || root.right.val > root.val))){
			return false;
		}
		return preOrderTraversal(root.left) && preOrderTraversal(root.right);
	}

}

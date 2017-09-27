package com.trees;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(isSymmetric(root.left,root.right));
	}
	
	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null){
			return true;
		}else if(left == null || right == null){
			return false;
		}
		if(left.val != right.val){
			return false;
		}
		if(!isSymmetric(left.left,right.right)){
			return false;
		}
		if(!isSymmetric(left.right,right.left)){
			return false;
		}
		return true;
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		return root;
	}

}

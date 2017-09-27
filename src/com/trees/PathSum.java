package com.trees;

public class PathSum {
	
	private static int k = 6;
//	private static int k = 11;

	public static void main(String[] args) {
		TreeNode root  = createTree();
		System.out.println(preOrderTraversal(root,0));
	}
	
	private static boolean preOrderTraversal(TreeNode root, int count) {
		if(root == null){
			return false;
		}
		if(count+root.val == k){
			return true;
		}
		return preOrderTraversal(root.left,count+root.val) || preOrderTraversal(root.right, count+root.val);
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

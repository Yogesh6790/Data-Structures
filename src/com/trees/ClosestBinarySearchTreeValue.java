package com.trees;

public class ClosestBinarySearchTreeValue {

	private static int min = Integer.MAX_VALUE;
	private static int closestVal = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		TreeNode root = createRoot();
		findClosest(root,17);
		System.out.println(closestVal);
	}

	private static void findClosest(TreeNode root,int val) {
		if(root == null){
			return;
		}
		if(min > Math.abs(root.val-val)){
			min = Math.abs(root.val-val);
			closestVal = root.val;
		}
		findClosest(root.left,val);
		findClosest(root.right,val);
	}

	private static TreeNode createRoot() {
		TreeNode root = new TreeNode(8);
		TreeNode left = new TreeNode(6);
		TreeNode right = new TreeNode(12);
		root.left = left;
		root.right = right;
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(13);
		return root;
	}

}

package com.trees;

public class CheckIfTreeisSubTreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		boolean[] flag = new boolean[1];
		checkSubTree(root.left,root.left.left,flag);
		System.out.println(flag[0]);
		flag[0] = false;
		checkSubTree(root.left,new TreeNode(2),flag);
		System.out.println(flag[0]);
	}
	
	private static void checkSubTree(TreeNode root, TreeNode target,boolean[] flag) {
		if(root == null)return;
		if(root == target){
			flag[0] = true;
		}
		checkSubTree(root.left,target,flag);
		checkSubTree(root.right,target,flag);
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

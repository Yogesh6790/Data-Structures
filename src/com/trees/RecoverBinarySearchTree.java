package com.trees;

public class RecoverBinarySearchTree {
	
	private static TreeNode first;
	private static TreeNode second;
	private static TreeNode pre;
	
	public static void main(String args[]){
		TreeNode root = createTree();
		recoverTree(root);
		inOrderTraversal(root);
	}



	private static void inOrderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		inOrderTraversal(root.left);
		System.out.println(root.val);
		inOrderTraversal(root.right);
	}



	private static void recoverTree(TreeNode root) {
		inorder(root);
		if(second !=null && first != null){
			int val =  second.val;
			second.val = first.val;
			first.val = val;
		}
		
	}



	private static void inorder(TreeNode root) {
		if(root == null){
			return;
		}
		inorder(root.left);
		if(pre == null){
			pre = root;
		}else{
			if(root.val < pre.val){
				first = pre;
				second = root;
			}
			pre = root;
		}
		inorder(root.right);
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;
		return root;
	}

}

package com.trees;

public class LowestCommonAncestorBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode node = lowestCommonAncestor(root,root.left.left,root.left.right);
		System.out.println(node.val);

	}
	
	
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
		if(root.val > left.val && root.val < right.val){
			return root;
		}else if(root.val > left.val && root.val > right.val){
			return lowestCommonAncestor(root.left, left, right); 
		}else if(root.val < left.val && root.val < right.val){
			return lowestCommonAncestor(root.right, left, right); 
		}
		return null;
	}


	private static TreeNode createTree() {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(31);
		return root;
	}

}

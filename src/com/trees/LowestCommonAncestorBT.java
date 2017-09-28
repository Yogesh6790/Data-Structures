package com.trees;

public class LowestCommonAncestorBT {

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(lowestCommonAncestor(root, root.left.left, root.right.left).val);
	}
	
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
		if(root == null){
			return null;
		}
		if(root == left || root == right){
			return root;
		}
		TreeNode l = lowestCommonAncestor(root.left,left,right);
		TreeNode r = lowestCommonAncestor(root.right,left,right);
		
		if(l != null && r != null) return root;
		else if(l==null && r!=null) return null;
		else{
			return l==null?r:l;
		}
	}


	private static TreeNode createTree() {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.right.left = new TreeNode(9);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(31);
		return root;
	}

}

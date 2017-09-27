package com.trees;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(countNodes(root));
	}

	private static int countNodes(TreeNode root) {
		int leftHeight = getLeftHeight(root.left);
		int rightHeight = getRightHeight(root.right);
		if(leftHeight == rightHeight){
			return (int) (Math.pow(2, leftHeight)-1);
		}else{
			return countNodes(root.left)+countNodes(root.right)+1;
		}
	}

	private static int getRightHeight(TreeNode right) {
		int height = 1;
		while(right != null){
			right = right.right;
			height++;
		}
		return height;
	}

	private static int getLeftHeight(TreeNode left) {
		int height = 1;
		while(left != null){
			left = left.left;
			height++;
		}
		return height;
	}
	
	public static TreeNode createTree(){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
//		root.right.right = new TreeNode(6);
//		root.right.right = new TreeNode(7);
		return root;
	}

}

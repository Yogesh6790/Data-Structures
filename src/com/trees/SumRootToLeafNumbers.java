package com.trees;

public class SumRootToLeafNumbers {

	private static int sum = 0;

	public static void main(String[] args) {
		TreeNode root = createTree();
		dfs(root, "");
		System.out.println(sum);
		System.out.println(dfs2(root,0));
	}

	private static int dfs2(TreeNode root, int num) {
		if (root == null) {	return 0; }
		num = num * 10 + root.val;
		if (root.left == null && root.right == null) {
			return num;
		}
		return dfs2(root.left, num) + dfs2(root.right, num);
	}

	private static void dfs(TreeNode root, String str) {
		if (root == null) {
			return;
		}
		str += root.val;
		if(root.left == null && root.right == null){
			sum += Integer.parseInt(str);
		}
		dfs(root.left, str);
		dfs(root.right, str);
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(9);
		return root;
	}

}

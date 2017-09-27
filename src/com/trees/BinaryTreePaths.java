package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BinaryTreePaths {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<String> list = new ArrayList<>();
		preOrderTraversal(root,list,"");
		System.out.println(list);
	}
	
	private static void preOrderTraversal(TreeNode root, List<String> list,String str) {
		if(root == null){
			return;
		}
		str += root.val;
		if(root.left == null && root.right == null){
			list.add(str);
		}
		preOrderTraversal(root.left,list,str);
		preOrderTraversal(root.right,list,str);
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(6);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(3);
		root.left.left.right.left = new TreeNode(2);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		return root;
	}

}

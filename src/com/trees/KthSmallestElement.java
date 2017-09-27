package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElement {

	private static int k = 2;
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		inOrderTraversalByIteration(root);
		System.out.println(list);
	}

	private static void inOrderTraversalByIteration(TreeNode root) {
		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<>();
		while(p != null){
			stack.push(p);
			p = p.left;
		}
		int i = 0;
		while(!stack.isEmpty()){
			TreeNode x = stack.pop();
			i++;
			if(i == k){
				System.out.println(x.val);
			}
			list.add(x.val);
			x= x.right;
			while(x!= null){
				stack.push(x);
				x = x.left;
			}
		}
		
	}

}

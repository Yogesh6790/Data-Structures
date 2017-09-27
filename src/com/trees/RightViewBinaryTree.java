package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		rightSideView(root);
	}
	
	private static void rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Queue<Integer> depth = new LinkedList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		depth.add(1);

		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			int lvl = depth.poll();
			if (depth.isEmpty() || lvl < depth.peek()) {
				res.add(top.val);
			}
			//Left should be specified first for right side view
			if(top.left != null){
				queue.add(top.left);
				depth.add(lvl+1);
			}
			//Right should be specified first for left side view
			if(top.right != null){
				queue.add(top.right);
				depth.add(lvl+1);
			}
		}
		System.out.println(res);
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		return root;
	}

}

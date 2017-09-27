package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {

	public static void main(String args[]) {
		TreeNode root = createTree();
		Map<Integer, List<Integer>> map = new TreeMap<>();
//		verticalTraversalWithPreOrder(root,0, map);
		verticalTraversalWithLevelOrder(root);
//		System.out.println(map);
	}

	private static void verticalTraversalWithLevelOrder(TreeNode root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> index = new LinkedList<>();
		queue.add(root);
		index.add(0);
		while (!queue.isEmpty()) {
			TreeNode tn = queue.poll();
			int val = index.poll();
			List<Integer> list = map.get(val) == null ? new ArrayList<Integer>()
					: map.get(val);
			list.add(tn.val);
			map.put(val, list);
			if (tn.left != null) {
				queue.add(tn.left);
				index.add(val - 1);
			}
			if (tn.right != null) {
				queue.add(tn.right);
				index.add(val + 1);
			}
		}
		System.out.println(map);
	}

	private static void verticalTraversalWithPreOrder(TreeNode root, int val,
			Map<Integer, List<Integer>> map) {
		if(root == null) return;
		List<Integer> list;
		list = map.get(val) == null ? new ArrayList<Integer>() : map.get(val);
		list.add(root.val);
		map.put(val, list);
		verticalTraversalWithPreOrder(root.left,val-1,map);
		verticalTraversalWithPreOrder(root.right,val+1,map);
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(10);
		root.right.right.right = new TreeNode(9);
		root.right.right.left.right = new TreeNode(11);
		root.right.right.left.right.right = new TreeNode(12);
		return root;
	}

}

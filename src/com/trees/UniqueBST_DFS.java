package com.trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST_DFS {

	public static void main(String args[]) {
		int noOfNodes = 3;
		System.out.println(generateTree(noOfNodes).size());
	}

	private static List<TreeNode> generateTree(int noOfNodes) {
		if(noOfNodes == 0){
			return null;
		}
		return helper(1, noOfNodes);
	}

	private static List<TreeNode> helper(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start>end){
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftList = helper(start, i - 1);
			List<TreeNode> rightList = helper(i + 1, end);
			for (TreeNode leftNode : leftList) {
				for (TreeNode rightNode : rightList) {
					TreeNode current = new TreeNode(i);
					current.left = leftNode;
					current.right = rightNode;
					result.add(current);
				}
			}
		}
		return result;
	}

}

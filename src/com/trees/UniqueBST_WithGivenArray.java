package com.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBST_WithGivenArray {

	public static void main(String args[]) {
		int[] arr = {3,1,2};
		Arrays.sort(arr);
		List<TreeNode> result = generateTree(0,arr.length-1,arr);
		System.out.println(result.size());
	}

	private static List<TreeNode> generateTree(int start, int end,int[] arr) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start>end){
			result.add(null);
			return result;
		}
		for(int i=start;i<=end;i++){
			List<TreeNode> leftList = generateTree(start, i-1, arr);
			List<TreeNode> rightList = generateTree(i+1, end, arr);
			for (TreeNode left : leftList) {
				for (TreeNode right : rightList) {
					TreeNode curr = new TreeNode(arr[i]);
					curr.left = left;
					curr.right = right;
					result.add(curr);
				}
			}
		}
		return result;
	}

}

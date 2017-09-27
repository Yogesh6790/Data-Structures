package com.trees;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5};
		TreeNode node = convertArrayToBST(num,0,num.length-1);
		List<Integer> list = new ArrayList<>();
		preOrderTraversal(node, list);
		System.out.println(list);
	}
	
	private static void preOrderTraversal(TreeNode tn,List<Integer> list) {
		if(tn == null){
			return;
		}
		list.add(tn.val);
		preOrderTraversal(tn.left,list);
		preOrderTraversal(tn.right,list);
	}
	
	private static TreeNode convertArrayToBST(int[] num, int i, int j) {
		TreeNode root = null;
		if (i <= j) {
			int mid = (i + j) / 2;
			root = new TreeNode(num[mid]);
			root.left = convertArrayToBST(num, i, mid - 1);
			root.right = convertArrayToBST(num, mid + 1, j);
		}
		return root;
	}

}

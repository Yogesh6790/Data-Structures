package com.trees;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsEqualtoK {
	
	public static void main(String[] args) {
		TreeNode root = createTree();
		int k = 0;
		int[] cntr = {0};
		List<Integer> list = new ArrayList<Integer>();
		preOrderTraversal(root,list,k,cntr);
		System.out.println(cntr[0]);
	}
	
	private static void preOrderTraversal(TreeNode root, List<Integer> list,
			int target, int[] cntr) {
		if(root == null) return;
		//Adding values to list
		for(int i=0;i<list.size();i++){
			int checkVal = list.get(i)+root.val;
			if(checkVal == target){
				cntr[0]++;
			}
			list.remove(i);
			list.add(i,checkVal);
		}
		list.add(root.val);
		preOrderTraversal(root.left,list,target,cntr);
		preOrderTraversal(root.right,list,target,cntr);
		//Removing values from list
		list.remove(list.size()-1);
		for(int i=0;i<list.size();i++){
			int val = list.get(i)-root.val;
			list.remove(i);
			list.add(i,val);
		}
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(-1);
		TreeNode right = new TreeNode(-1);
		root.left = left;
		root.right = right;
		root.left.right = new TreeNode(0);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(2);
		return root;
	}

}

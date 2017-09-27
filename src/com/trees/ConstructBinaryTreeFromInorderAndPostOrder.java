package com.trees;

import java.util.ArrayList;
import java.util.List;

// Expected output : [1, 2, 4, 5, 3, 7, 6, 8]
public class ConstructBinaryTreeFromInorderAndPostOrder {

	public static void main(String[] args) {
		int[] inorder =  {4,2,5,1,6,7,3,8};
		int[] postorder = {4,5,2,6,7,8,3,1};
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;
		TreeNode tn = buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
		List<Integer> list = new ArrayList<>();
		preOrderTraversal(tn,list);
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

	private static TreeNode buildTree(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if(inStart>inEnd || postStart>postEnd){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == postorder[postEnd]){
				k = i;
				break;
			}
		}
		root.left = buildTree(inorder,inStart,k-1,postorder,postStart,postStart + k - (inStart + 1));
		root.right = buildTree(inorder,k+1,inEnd,postorder,postStart + k - (inStart + 1)+1,postEnd-1);
		return root;
	}

}

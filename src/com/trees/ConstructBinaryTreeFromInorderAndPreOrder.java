package com.trees;

import java.util.ArrayList;
import java.util.List;

// Expected output  : [4, 5, 2, 6, 7, 8, 3, 1]
public class ConstructBinaryTreeFromInorderAndPreOrder {


	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] preorder = { 1, 2, 4, 5, 3, 7, 6, 8 };
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int preEnd = preorder.length - 1;
		TreeNode tn = buildTree(inorder, inStart, inEnd, preorder, postStart,
				preEnd);
		List<Integer> list = new ArrayList<>();
		postOrderTraversal(tn, list);
		System.out.println(list);
	}
	
	private static void postOrderTraversal(TreeNode tn,List<Integer> list) {
		if(tn == null){
			return;
		}
		postOrderTraversal(tn.left,list);
		postOrderTraversal(tn.right,list);
		list.add(tn.val);
	}
	

	private static TreeNode buildTree(int[] inorder, int inStart, int inEnd,
			int[] preorder, int preStart, int preEnd) {
		if(inStart>inEnd || preStart>preEnd){
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == preorder[preStart]){
				k = i;
				break;
			}
		}
		root.left = buildTree(inorder,inStart,k-1,preorder, preStart+1, preStart + k - inStart);
		root.right = buildTree(inorder,k+1,inEnd,preorder,preStart + k - inStart + 1, preEnd);
		return root;
	}


}

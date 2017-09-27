package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointers2 {
	
	public static void main(String args[]){
		TreeNode root = createTree();
		populatingNextPointer(root);
		preOrderTraversal(root);
	}
	
	private static void preOrderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		System.out.println(root.val+ " "+ (root.next != null ? root.next.val : root.next));
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	private static void populatingNextPointer(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> depth = new LinkedList<Integer>();
		
		queue.add(root);
		depth.add(1);
		
		while(!queue.isEmpty()){
			TreeNode topNode = queue.poll();
			int lvl = depth.poll();
			
			if(queue.isEmpty() || lvl <  depth.peek()){
				topNode.next = null;
			}else{
				topNode.next = queue.peek();
			}
			
			if(topNode.left != null){
				queue.add(topNode.left);
				depth.add(lvl+1);
			}
			
			if(topNode.right != null){
				queue.add(topNode.right);
				depth.add(lvl+1);				
			}
		}
		
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		return root;
	}

}

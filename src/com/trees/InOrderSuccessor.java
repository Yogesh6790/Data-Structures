package com.trees;

public class InOrderSuccessor {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode root2 = createTree2();
		System.out.println(inOrderSuccessor(root,root.right.right.right).val);
		System.out.println(inOrderSuccessor(root2,root2.left.right.right.right).val);		
	}

	private static TreeNode inOrderSuccessor(TreeNode root,TreeNode toFind) {
		if(root == null) return null;
		TreeNode currentNode = root;
		TreeNode next = null;
		while(currentNode != null && currentNode.val != toFind.val){
			if(currentNode.val > toFind.val){
				next = currentNode;
				currentNode = currentNode.left;
			}else{
				currentNode = currentNode.right;
			}
		}
		if(currentNode == null) return null;
		if(currentNode.right == null) return next;
		currentNode = currentNode.right;
		TreeNode currentNode2 = currentNode;
		while(currentNode != null){
			currentNode2 = currentNode;
			currentNode = currentNode.left;
		}
		return currentNode2;
		
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.right = right;
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(6);
		root.right.right.right.left = new TreeNode(5);
		root.right.right.right.right = new TreeNode(8);
		return root;
	}
	
	private static TreeNode createTree2() {
		TreeNode init_root = new TreeNode(10);
		TreeNode root = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		init_root.left = root;
		root.right = right;
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(6);
		return init_root;
	}

}

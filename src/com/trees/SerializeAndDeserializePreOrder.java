package com.trees;

import java.util.Stack;

public class SerializeAndDeserializePreOrder {

	public static void main(String[] args) {
		TreeNode root = createTree();
		String data = serialize(root);
		TreeNode node = deserialize(data);
		System.out.println("****");
	}

	private static TreeNode deserialize(String data) {
		if (data.equals(""))
			return null;
		String[] arr = data.split(" ");
		int[] i = {0};
		return formNode(arr, i);
	}

	private static TreeNode formNode(String[] arr, int[] i) {
		if (arr[i[0]].equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(arr[i[0]]));
		i[0]++;
		root.left = formNode(arr, i);
		i[0]++;
		root.right = formNode(arr, i);
		return root;
	}

	private static String serialize(TreeNode root) {
		String str = "";
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode topNode = stack.pop();
			if (topNode != null) {
				str += topNode.val + " ";
				stack.push(topNode.right);
				stack.push(topNode.left);
			} else {
				str += "# ";
			}
		}
		return str;
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		return root;
	}

}

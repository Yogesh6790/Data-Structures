package com.trees;

import java.util.LinkedList;

public class CheckIfTwoTreesAreSame {

	public static void main(String[] args) {
		TreeNode t1 = createTree();
		TreeNode t2 = createTree();
//		t2.val = 11;
		System.out.println(check(t1,t2)); 
		serialize(t1);
	}

	
	private static boolean check(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null){
			return true;
		}else if(t1 == null || t2 == null){
			return false;
		}
		if(t1.val != t2.val){
			return false;
		}
		return check(t1.left,t2.left) && check(t1.right, t2.right);
	}
	
	public static String serialize(TreeNode root) {
	    if(root==null){
	        return "";
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	 
	    queue.add(root);
	    while(!queue.isEmpty()){
	        TreeNode t = queue.poll();
	        if(t!=null){
	            sb.append(String.valueOf(t.val) + ",");
	            queue.add(t.left);
	            queue.add(t.right);
	        }else{
	            sb.append("#,");
	        }
	    }
	 
	    sb.deleteCharAt(sb.length()-1);
	    System.out.println(sb.toString());
	    return sb.toString();
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

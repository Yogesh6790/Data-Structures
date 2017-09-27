package com.linkedlist;

//https://leetcode.com/problems/add-two-numbers/description/
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}
public class AddTwoNumbersinLinkedList {
	
	public static void main(String args[]){
		ListNode root1 = new ListNode(2);
		ListNode temp1 = root1;
		temp1.next = new ListNode(4);
		temp1 = temp1.next;
		temp1.next = new ListNode(3);
		
		ListNode root2 = new ListNode(5);
		ListNode temp2 = root2;
		temp2.next = new ListNode(6);
		temp2 = temp2.next;
		temp2.next = new ListNode(4);
		
		ListNode result = new ListNode((root1.val+root2.val)%10);
		int carry = root1.val+root2.val > 9 ? 1 : 0;
		ListNode res = result;
		root1 = root1.next;
		root2 = root2.next;
		while(root1 != null || root2 != null){
			int root1Val = root1 != null ? root1.val : 0;
			int root2Val = root2 != null ? root2.val : 0;
			res.next = new ListNode((root1Val + root2Val+carry)%10);
			carry = root1Val+root2Val + carry > 9 ? 1 : 0;
			res = res.next;
			root1 = root1 != null ? root1.next : root1;
			root2 = root2 != null ? root2.next : root2;
		}
		if(carry == 1){
			res.next = new ListNode(1);
		}
		System.out.println(result);
	}

}

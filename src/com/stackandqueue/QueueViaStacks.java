package com.stackandqueue;

public class QueueViaStacks {

	static Node root1;

	Node root2;
	
	int size;
	
	QueueViaStacks() {
		size = 0;
	}
	
	private void enqueue(Node root, Node node) {
		if (root == root1) {
			node.next = root1;
			root1 = node;
		} else {
			node.next = root2;
			root2 = node;
		}
		size++;
	}
	
	private int dequeue(){
		int returnVal = Integer.MIN_VALUE;
		while(root1!=null){
			if(root1.next == null){
				returnVal = root1.data;
			}else{
				enqueue(root2,new Node(root1.data));
			}
			root1 = root1.next;
		}
		while(root2 != null){
			enqueue(root1,new Node(root2.data));
			root2 = root2.next;
		}
		size--;
		return returnVal;
	}
	
	private int front(){
		int returnVal = Integer.MIN_VALUE;
		while(root1!=null){
			returnVal = root1.data;
			enqueue(root2,new Node(returnVal));
			root1 = root1.next;
		}
		while(root2 != null){
			enqueue(root1,new Node(root2.data));
			root2 = root2.next;
		}
		return returnVal;
	}
	
	private boolean isEmpty(){
		return size == 0;
	}

	public static void main(String args[]) {
		
		QueueViaStacks obj = new QueueViaStacks();
		obj.enqueue(root1, new Node(1));
		obj.enqueue(root1, new Node(2));
		obj.enqueue(root1, new Node(3));
		obj.enqueue(root1, new Node(4));
		System.out.println(obj.front());
		System.out.println(obj.dequeue());
		System.out.println(obj.front());
		System.out.println(obj.dequeue());
		System.out.println(obj.front());
		System.out.println(obj.dequeue());
	}

}

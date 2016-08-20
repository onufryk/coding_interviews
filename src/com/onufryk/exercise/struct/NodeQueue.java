package com.onufryk.exercise.struct;

public class NodeQueue {
	public class Node {
		TreeNode<Integer> value = null;
		Node next = null;
		
		public Node(TreeNode<Integer> value) {
			this.value = value;
		}
		
		public Node(TreeNode<Integer> value, Node link) {
			this.value = value;
			this.next = link;
		}
		
		public void setNext(Node link) {
			this.next = link;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public TreeNode<Integer> getValue() {
			return this.value;
		}
		
		public void setValue(TreeNode<Integer> value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public boolean hasOneItem() {
		return this.first == this.last;
	}

	public void enqueue(TreeNode<Integer> value) {
		Node lastNode = last;
		
		Node newNode = new Node(value);
		this.last = newNode;
		
		if (this.first == null) {
			this.first = newNode;
		} else {
			lastNode.next = newNode;
		}
	}
	
	public TreeNode<Integer> dequeue() {
		if (this.first == null) {
			return null;
		}
		TreeNode<Integer> firstValue = first.value;
		
		this.first = this.first.next;
		
		if (this.first == null) {
			this.last = null;
		}
		
		return firstValue;
	}
	
	public String print() {
		if (this.first == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		Node cursor = this.first;
		while (cursor != null) {
			buffer.append(cursor.value.value);
			buffer.append(' ');
			cursor = cursor.next;
		}
		return buffer.toString();
	}

}

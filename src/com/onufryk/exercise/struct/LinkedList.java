package com.onufryk.exercise.struct;

public class LinkedList {
	protected Node root = null;
	
	public Node getRoot() {
		return this.root;
	}
	
	public void init(Node rootNode) throws Exception {
		if (this.root != null) {
			throw new Exception();
		}
		this.root = rootNode;
	}
	
	public void add(Integer value) {
		if (this.root == null) {
			this.root = new Node(value);
			return;
		}
		Node current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

	public void print() {
		Node current = this.root;
		StringBuffer output = new StringBuffer();
		while (current != null) {
			output.append(current.value);
			output.append(' ');
			current = current.next;
		}
		System.out.println(output);
	}
	
	private void printNext(Node node) {
		if (node != null) {
			printNext(node.next);
			System.out.print(node.value);
			System.out.print(' ');
		}
	}
	
	public void printReversed() {
		printNext(root);
		System.out.println();
	}
}

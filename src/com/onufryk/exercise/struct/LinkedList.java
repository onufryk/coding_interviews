package com.onufryk.exercise.struct;

public class LinkedList {
	protected Node<Integer> root = null;
	
	public Node<Integer> getRoot() {
		return this.root;
	}
	
	public void init(Node<Integer> rootNode) throws Exception {
		if (this.root != null) {
			throw new Exception();
		}
		this.root = rootNode;
	}
	
	public void add(Integer value) {
		if (this.root == null) {
			this.root = new Node<Integer>(value);
			return;
		}
		Node<Integer> current = this.root;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node<Integer>(value);
	}

	public void print() {
		Node<Integer> current = this.root;
		StringBuffer output = new StringBuffer();
		while (current != null) {
			output.append(current.value);
			output.append(' ');
			current = current.next;
		}
		System.out.println(output);
	}
	
	private void printNext(Node<Integer> node) {
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

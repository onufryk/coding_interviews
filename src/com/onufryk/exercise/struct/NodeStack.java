package com.onufryk.exercise.struct;

public class NodeStack<V> {

	public class Node<T> {
		TreeNode<T> value = null;
		Node<T> next = null;

		public Node(TreeNode<T> value) {
			this.value = value;
		}

		public Node(TreeNode<T> value, Node<T> link) {
			this.value = value;
			this.next = link;
		}

		public void setNext(Node<T> link) {
			this.next = link;
		}

		public Node<T> getNext() {
			return this.next;
		}

		public TreeNode<T> getValue() {
			return this.value;
		}

		public void setValue(TreeNode<T> value) {
			this.value = value;
		}
	}

	public Node<V> top = null;

	public Boolean isEmpty() {
		return this.top == null;
	}

	public void push(TreeNode<V> value) {
		if (top == null) {
			top = new Node<V>(value);
			return;
		}
		Node<V> first = top;

		top = new Node<V>(value);
		top.setNext(first);
	}

	public TreeNode<V> pop() {
		if (top == null) {
			return null;
		}

		Node<V> first = top;

		top = top.next;

		return first.value;
	}

	public Node<V> top() {
		if (top == null) {
			return null;
		}
		return this.top;
	}

	public void print() {
		Node<V> current = this.top;
		StringBuffer output = new StringBuffer();
		while (current != null) {
			output.append(current.value);
			output.append(' ');
			current = current.next;
		}
		System.out.println(output);
	}

}

package com.onufryk.exercise.struct;

public class Stack {
	Node top = null;
	
	public void push(Integer value) {
		if (top == null) {
			top = new Node(value);
			return;
		}
		Node first = top;
		
		top = new Node(value);
		top.setNext(first);
	}
	
	public Node pop() {
		if (top == null) {
			return null;
		}
		
		Node first = top;
		
		top = top.next;
		
		return first;
		
	}

	public void print() {
		Node current = this.top;
		StringBuffer output = new StringBuffer();
		while (current != null) {
			output.append(current.value);
			output.append(' ');
			current = current.next;
		}
		System.out.println(output);
	}
}

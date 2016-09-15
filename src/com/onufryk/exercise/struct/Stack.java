package com.onufryk.exercise.struct;

public class Stack {
	public Node top = null;
	private Integer size = 0;
	
	public Boolean isEmpty() {
		return this.top == null;
	}
	
	public void push(Integer value) {
		this.size++;
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
		
		this.size--;
		
		return first;
	}
	
	public Node top() {
		if (top == null) {
			return null;
		}
		return this.top;
	}
	
	public Integer size() {
		return this.size;
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

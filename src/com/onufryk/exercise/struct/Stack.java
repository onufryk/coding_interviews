package com.onufryk.exercise.struct;

public class Stack {
	public Node<Integer> top = null;
	private Integer size = 0;
	
	public Boolean isEmpty() {
		return this.top == null;
	}
	
	public void push(Integer value) {
		this.size++;
		if (top == null) {
			top = new Node<Integer>(value);
			return;
		}
		Node<Integer> first = top;
		
		top = new Node<Integer>(value);
		top.setNext(first);
	}
	
	public Node<Integer> pop() {
		if (top == null) {
			return null;
		}
		
		Node<Integer> first = top;
		
		top = top.next;
		
		this.size--;
		
		return first;
	}
	
	public Node<Integer> top() {
		if (top == null) {
			return null;
		}
		return this.top;
	}
	
	public Integer size() {
		return this.size;
	}

	public void print() {
		Node<Integer> current = this.top;
		StringBuffer output = new StringBuffer();
		while (current != null) {
			output.append(current.value);
			output.append(' ');
			current = current.next;
		}
		System.out.println(output);
	}
}

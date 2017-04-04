package com.onufryk.exercise.struct;

public class Queue {
	protected Node<Integer> first;
	protected Node<Integer> last;
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public boolean hasOneItem() {
		return this.first == this.last;
	}

	public void enqueue(Integer value) {
		Node<Integer> lastNode = last;
		
		Node<Integer> newNode = new Node<Integer>(value);
		this.last = newNode;
		
		if (this.first == null) {
			this.first = newNode;
		} else {
			lastNode.next = newNode;
		}
	}
	
	public Integer dequeue() {
		if (this.first == null) {
			return null;
		}
		Integer firstValue = first.value;
		
		this.first = this.first.next;
		
		if (this.first == null) {
			this.last = null;
		}
		
		return firstValue;
	}
	
	public Integer peek() {
		if (this.first == null) {
			return null;
		}
		Integer firstValue = first.value;
		return firstValue;
	}
	
	public String print() {
		if (this.first == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		Node<Integer> cursor = this.first;
		while (cursor != null) {
			buffer.append(cursor.value);
			buffer.append(' ');
			cursor = cursor.next;
		}
		return buffer.toString();
	}

}

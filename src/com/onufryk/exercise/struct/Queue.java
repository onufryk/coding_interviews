package com.onufryk.exercise.struct;

public class Queue {
	private Node first;
	private Node last;
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public boolean hasOneItem() {
		return this.first == this.last;
	}

	public void enqueue(Integer value) {
		Node lastNode = last;
		
		Node newNode = new Node(value);
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
	
	public String print() {
		if (this.first == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		Node cursor = this.first;
		while (cursor != null) {
			buffer.append(cursor.value);
			buffer.append(' ');
			cursor = cursor.next;
		}
		return buffer.toString();
	}

}

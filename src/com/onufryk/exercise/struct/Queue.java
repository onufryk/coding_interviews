package com.onufryk.exercise.struct;

public class Queue {
	private Node first;
	private Node last;
	
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

}

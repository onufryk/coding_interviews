package com.onufryk.exercise.struct;

public class Node {
	Integer value = null;
	Node next = null;
	
	public Node(Integer value) {
		this.value = value;
	}
	
	public Node(Integer value, Node link) {
		this.value = value;
		this.next = link;
	}
	
	public void setNext(Node link) {
		this.next = link;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}

}

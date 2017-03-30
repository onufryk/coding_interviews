package com.onufryk.exercise.struct;

public class Node<Item> {
	Item value = null;
	Node<Item> next = null;
	
	public Node(Item value) {
		this.value = value;
	}
	
	public Node(Item value, Node<Item> link) {
		this.value = value;
		this.next = link;
	}
	
	public void setNext(Node<Item> link) {
		this.next = link;
	}
	
	public Node<Item> getNext() {
		return this.next;
	}
	
	public Item getValue() {
		return this.value;
	}
	
	public void setValue(Item value) {
		this.value = value;
	}

}

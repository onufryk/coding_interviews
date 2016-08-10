package com.onufryk.exercise;

import com.onufryk.exercise.struct.LinkedList;
import com.onufryk.exercise.struct.Node;

public class Question043 {
	private LinkedList list = new LinkedList();

	public Question043(Node rootNode) {
		try {
			list.init(rootNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print() {
		list.print();
	}
	
	public void delete(Node node) {
		if (node.getNext() != null) {
			Node next = node.getNext().getNext();
			Integer value = node.getNext().getValue();
			node.setValue(value);
			node.setNext(next);
			next = null;
			
		} else if (list.getRoot() == node) {
			// delete the only node
		} else {
			// delete sequentially
		}
		
	}

	public static void main(String[] args) {
		Node nodeToDelete = new Node(9, new Node(3, new Node(2, new Node(6))));
		Node rootNode = new Node(5,
				new Node(4, new Node(6, new Node(7, new Node(4, new Node(6, new Node(7, nodeToDelete)))))));

		Question043 app = new Question043(rootNode);
		app.print();
		app.delete(nodeToDelete);
		app.print();
	}

}

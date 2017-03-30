package com.onufryk.exercise;

import com.onufryk.exercise.struct.LinkedList;
import com.onufryk.exercise.struct.Node;

public class Question043 {
	private LinkedList list = new LinkedList();

	public Question043(Node<Integer> rootNode) {
		try {
			list.init(rootNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print() {
		list.print();
	}

	public void delete(Node<Integer> node) {
		if (node.getNext() != null) {
			Node<Integer> next = node.getNext().getNext();
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
		Node<Integer> nodeToDelete = new Node<Integer>(9, new Node<Integer>(3, new Node<Integer>(2, new Node<Integer>(6))));
		Node<Integer> rootNode = new Node<Integer>(5, new Node<Integer>(4, new Node<Integer>(6,
				new Node<Integer>(7, new Node<Integer>(4, new Node<Integer>(6, new Node<Integer>(7, nodeToDelete)))))));

		Question043 app = new Question043(rootNode);
		app.print();
		app.delete(nodeToDelete);
		app.print();
	}

}

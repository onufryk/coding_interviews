package com.onufryk.exercise;

import com.onufryk.exercise.struct.Node;
import com.onufryk.exercise.struct.LinkedList;

public class Question082 {

	public static void main(String[] args) throws Exception {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(7);
		
		Node<Integer> root1 = node1;
		Node<Integer> root2 = node4;
		
		root1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node6);
		node6.setNext(node7);
		
		root2.setNext(node5);
		node5.setNext(node6);
		
		Node<Integer> current1 = root1;
		Boolean commonNodeFound = false;
		while (current1 != null && !commonNodeFound) {
			Node<Integer> current2 = root2;
			while (current2 != null && !commonNodeFound) {
				if (current1 == current2) {
					System.out.println("First common node is " + current1.getValue());
					commonNodeFound = true;
					break;
				}
				current2 = current2.getNext();
			}
			current1 = current1.getNext();
		}
				
		
		
	}

}

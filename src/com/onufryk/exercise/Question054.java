package com.onufryk.exercise;

import java.util.HashMap;

public class Question054 {
	
	public class Node {
		public Character value;
		public Node next;
		public Node sibling;
		
		public Node(Character value) {
			this.value = value;
		}
		public Node(Character value, Node next) {
			this.value = value;
			this.next = next;
		}
		public Node(Character value, Node next, Node sibling) {
			this.value = value;
			this.next = next;
			this.sibling = sibling;
		}
	}
	
	public Node root;
	
	public Question054() {
		Node E = new Node('E');
		Node D = new Node('D', E);
		Node C = new Node('C', D);
		Node B = new Node('B', C);
		Node A = new Node('A', B);
		
		A.sibling = C;
		B.sibling = E;
		D.sibling = B;
		
		this.root = A;
	}
	
	public void cloneList1() {
		if (this.root == null) {
			return;
		}
		HashMap<Node, Node> mapping = new HashMap<Node, Node>();

		Node cloned = new Node(this.root.value);
		Node clonedRoot = cloned;
		
		Node cursor = this.root.next;
		mapping.put(this.root, clonedRoot);
		while (cursor != null) {
			Node newNode = new Node(cursor.value);
			cloned.next = newNode;
			
			
			cloned = cloned.next;
			mapping.put(cursor, cloned);
			cursor = cursor.next;
		}
		
		cursor = this.root;
		Node cursor2 = clonedRoot;
		while (cursor2 != null) {
			if (mapping.containsKey(cursor.sibling)) {
				cursor2.sibling = mapping.get(cursor.sibling);
			}
			
			cursor = cursor.next;
			cursor2 = cursor2.next;
		}
		this.print(clonedRoot);
	}
	
	public void cloneList2() {
		if (this.root == null) {
			return;
		}
		Node cursor = this.root;
		while (cursor != null) {
			Node next = cursor.next;
			Node cloned = new Node(cursor.value, next);
			cursor.next = cloned;
			
			cursor = next;
		}
		cursor = this.root;
		while (cursor != null) {
			Node cloned = cursor.next;
			
			if (cursor.sibling != null) {
				cloned.sibling = cursor.sibling.next;
			}
			
			cursor = cloned.next;
		}
		
		cursor = this.root;
		Node clonedRoot = null;
		Node cloned = null;
		
		if (cursor != null) {
			cloned = cursor.next;
			clonedRoot = cloned;
			cursor.next = cloned.next;
			cursor = cursor.next;
		}
		while (cursor != null) {
			cloned.next = cursor.next;
			cloned = cloned.next;
			cursor.next = cloned.next;
			cursor = cursor.next;
		}
		
		this.print();
		this.print(clonedRoot);
	}
	
	public void print() {
		this.print(this.root);
 	}
	
	public void print(Node node) {
		if (node == null) {
			return;
		}
		Node cursor = node;
		while (cursor != null) {
			System.out.print(cursor.value);
			if (cursor.sibling != null) {
				System.out.print('(');
				System.out.print(cursor.sibling.value);
				System.out.print(')');
			}
			System.out.print(' ');
			cursor = cursor.next;
		}
		System.out.println();
	}
	
	public void run() {
		this.print();
//		this.cloneList1();
		this.cloneList2();
	}

	public static void main(String[] args) {
		Question054 app = new Question054();
		app.run();

	}

}

package com.onufryk.exercise;

public class Question048 {

	
	private static class Node {
		public Integer value;
		public Node next;
		
		public Node(Integer value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private static class NodeList {
		public Node root = null;
		
		public NodeList() {
			super();
		}

		public void add(Integer value) {
			if (this.root == null) {
				this.root = new Node(value, null);
				return;
			}
			Node current = this.root;
			
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(value, null);
		}
		
		public void print() {
			Node current = this.root;
			StringBuffer output = new StringBuffer();
			while (current != null) {
				output.append(current.value);
				current = current.next;
			}
			System.out.println(output);
		}
		
		public void reverse() {
			if (this.root == null) {
				return;
			}
			Node current = this.root;
			Node previousNode = null;
			Node nextNode = null;

			while (current != null) {
				if (current.next == null) {
					this.root = current;
				}
				nextNode = current.next;
				current.next = previousNode;
				
				previousNode = current;
				current = nextNode;
				
			}

		}
		
	}

	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.print();
		list.reverse();
		list.print();
	}


}

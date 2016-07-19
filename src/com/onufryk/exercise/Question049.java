package com.onufryk.exercise;


public class Question049 {

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

		private void reverseGroup(Node first, Node last) {
			System.out.println(first.value + " - " + last.value);
			if (first == null || last == null) {
				return;
			}
			Node current = first;
			Node previousNode = null;
			while (current != last) {
				Node nextNode = current.next;
				current.next = previousNode;
				
				previousNode = current;
				current = nextNode;
			}
			current.next = previousNode;
		}
		
		public void reverseGroups(Integer nodesInGroup) {
			if (this.root == null) {
				return;
			}
			Node current = this.root;
			Node firstNode = null;
			Node lastNode = null;

			Integer k = 0;
			while (current != null && k < nodesInGroup) {
				System.out.println(k + ": " + current.value);
				if (k == 0) {
					firstNode = current;
				}
				
				k++;
				
				if (k == nodesInGroup || current.next == null) {
					lastNode = current;
					this.reverseGroup(firstNode, lastNode);
				}

				current = current.next;
				
				if (k == nodesInGroup) {
					k = 0;
				}
			}

		}

	}

	public static void main(String[] args) {
		NodeList list = new NodeList();
		for (int ii = 1; ii <= 8; ii++) {
			list.add(ii);
		}
		list.print();
		list.reverseGroups(3);
		list.print();
	}

}

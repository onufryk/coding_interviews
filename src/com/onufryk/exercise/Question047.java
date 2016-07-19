package com.onufryk.exercise;

public class Question047 {
	
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
		
		public Integer find(Integer k) {
			if (this.root == null || k == 0) {
				return null;
			}
			Node p1 = this.root;
			Node p2 = this.root;
			Integer index = 0;
			while (p1.next != null && index < k - 1) {
				p1 = p1.next;
				index++;
			}
			if (index < k - 1) {
				return null;
			}
			while (p1.next != null) {
				p1 = p1.next;
				p2 = p2.next;
				index++;
			}
			return p2.value;
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
		System.out.println(list.find(3));
	}

}

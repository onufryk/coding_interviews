package com.onufryk.exercise;

import com.onufryk.exercise.struct.LinkedList;
import com.onufryk.exercise.struct.Node;

public class Question044 {
	
	public static class SingleEntryList extends LinkedList {
		public void deduplicate() {
			if (this.root == null) {
				return;
			}
			Node previous = null;
			Node cursor = this.root;
			while (cursor != null) {
				Node next = cursor.getNext();
				
				if (next != null && cursor.getValue() == next.getValue()) {
					Integer duplicatedValue = cursor.getValue();
					Node deleteMe = cursor;
					while (deleteMe != null && deleteMe.getValue() == duplicatedValue) {
						next = deleteMe.getNext();
						deleteMe = null;
						deleteMe = next;
					}
					if (previous == null) {
						this.root = next;
					} else {
						previous.setNext(next);
					}
					cursor = next;
				} else {
					previous = cursor;
					cursor = cursor.getNext();
				}
				
			}
			
		}
		
	}

	public static void main(String[] args) throws Exception {
		Node root = new Node(1, new Node(2, new Node(3, new Node (3, new Node(4, new Node(4, new Node (5)))))));
		SingleEntryList list = new SingleEntryList();
		list.init(root);
		
		list.print();
		
		list.deduplicate();
		
		list.print();

	}

}

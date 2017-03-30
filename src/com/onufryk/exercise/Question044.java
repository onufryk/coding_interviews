package com.onufryk.exercise;

import com.onufryk.exercise.struct.LinkedList;
import com.onufryk.exercise.struct.Node;

public class Question044 {
	
	public static class SingleEntryList extends LinkedList {
		public void deduplicate() {
			if (this.root == null) {
				return;
			}
			Node<Integer> previous = null;
			Node<Integer> cursor = this.root;
			while (cursor != null) {
				Node<Integer> next = cursor.getNext();
				
				if (next != null && cursor.getValue() == next.getValue()) {
					Integer duplicatedValue = cursor.getValue();
					Node<Integer> deleteMe = cursor;
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
		Node<Integer> root = new Node<Integer>(1, new Node<Integer>(2,
				new Node<Integer>(3, new Node<Integer>(3, new Node<Integer>(4, new Node<Integer>(4, new Node<Integer>(5)))))));
		SingleEntryList list = new SingleEntryList();
		list.init(root);
		
		list.print();
		
		list.deduplicate();
		
		list.print();

	}

}

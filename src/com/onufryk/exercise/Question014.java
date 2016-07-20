package com.onufryk.exercise;

import java.util.Random;

import com.onufryk.exercise.struct.Node;
import com.onufryk.exercise.struct.LinkedList;

public class Question014 {
	
	public static class SortableLinkedList extends LinkedList {
		private Node lastSortedNode;
		private Node nextToBeSorted;
		
		public void sort() {
			if (this.root == null || this.root.getNext() == null) {
				return;
			}
			this.lastSortedNode = this.root;
			this.nextToBeSorted = this.lastSortedNode.getNext();
			
			int i = 0;
			while (this.nextToBeSorted != null) {
				i++;
				
				if (this.nextToBeSorted.getValue() < this.root.getValue()) {
					this.lastSortedNode.setNext(this.nextToBeSorted.getNext());
					this.nextToBeSorted.setNext(this.root);
					this.root = this.nextToBeSorted;
				} else {
					Node cursor = this.root;
					while (cursor != this.lastSortedNode && cursor.getNext().getValue() < this.nextToBeSorted.getValue()) {
						cursor = cursor.getNext();
					}
					if (cursor != this.lastSortedNode) {
						this.lastSortedNode.setNext(this.nextToBeSorted.getNext());
						this.nextToBeSorted.setNext(cursor.getNext());
						cursor.setNext(this.nextToBeSorted);
					} else {
						this.lastSortedNode = this.lastSortedNode.getNext();
					}
				}
				this.nextToBeSorted = this.lastSortedNode.getNext();
			}
		}
		
	}

	public static void main(String[] args) {
		Random randomizer = new Random();
		SortableLinkedList list = new SortableLinkedList();
		
		for (int ii = 0; ii < 10; ii++) {
			list.add(randomizer.nextInt(99) + 1);
		}

		list.print();
		
		list.sort();
		
		list.print();
	}

}

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
			
			while (this.nextToBeSorted != null) {
				if (this.nextToBeSorted.getValue() < this.root.getValue()) {
					this.lastSortedNode.setNext(this.nextToBeSorted.getNext());
					this.nextToBeSorted.setNext(this.root);
					this.root = this.nextToBeSorted;
				} else {
					Node indexNode = this.root;
					
					while (indexNode != this.lastSortedNode && indexNode.getNext().getValue() < this.nextToBeSorted.getValue()) {
						indexNode = indexNode.getNext();
					}
					
					if (indexNode != this.nextToBeSorted) {
						this.lastSortedNode.setNext(this.nextToBeSorted.getNext());
						this.nextToBeSorted.setNext(indexNode.getNext());
						indexNode.setNext(this.nextToBeSorted);
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

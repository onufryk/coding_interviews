package com.onufryk.exercise;

import com.onufryk.exercise.struct.LinkedList;
import com.onufryk.exercise.struct.Node;

public class Question017 {

	public static class LinkedListWithLoop extends LinkedList {
		public void loop(int index) {
			if (this.root == null) {
				return;
			}

			Node cursor = this.root;
			int ii = 1;
			Node loopNode = null;

			while (cursor != null) {
				if (ii == index) {
					loopNode = cursor;
				}

				ii++;
				if (cursor.getNext() == null) {
					cursor.setNext(loopNode);
					break;
				}
				cursor = cursor.getNext();
			}
		}
		
		private Integer getLoopLength() {
			if (this.root == null) {
				return null;
			}
			Node pointer1 = this.root;
			Node pointer2 = this.root.getNext();

			boolean loopFound = false;
			while (pointer1 != null && pointer2 != null) {
				if (pointer1 == pointer2) {
					loopFound = true;
					break;
				}
				pointer1 = pointer1.getNext();
				pointer2 = pointer2.getNext();
				if (pointer2 != null) {
					pointer2 = pointer2.getNext();
				}
			}
			Integer loopLen = null;
			if (loopFound) {
				loopLen = 0;
				do {
					loopLen++;
					pointer2 = pointer2.getNext();
				} while (pointer1 != pointer2);
			}

			return loopLen;
		}

		public Node getLoopEntry() {
			Integer loopLength = this.getLoopLength();
			if (loopLength == null || loopLength == 0) {
				return null;
			}
			Node loopEntry = this.root;
			Node cursor = this.root;
			for (int ii = 0; ii < loopLength; ii++) {
				cursor = cursor.getNext();
			}
			while (cursor != loopEntry) {
				loopEntry = loopEntry.getNext();
				cursor = cursor.getNext();
			}
			return loopEntry;
		}

	}

	public static void main(String[] args) {
		LinkedListWithLoop list = new LinkedListWithLoop();
		for (int value = 1; value <= 6; value++) {
			list.add(value);
		}
		list.print();
		list.loop(3);
		System.out.println(list.getLoopEntry().getValue());
	}

}

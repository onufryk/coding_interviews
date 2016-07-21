package com.onufryk.exercise;

import com.onufryk.exercise.struct.LinkedList;
import com.onufryk.exercise.struct.Node;

public class Question016 {

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

		public boolean hasLoop() {
			if (this.root == null) {
				return false;
			}
			Node pointer1 = this.root;
			Node pointer2 = this.root.getNext();

			boolean result = false;
			while (pointer1 != null && pointer2 != null) {
				if (pointer1 == pointer2) {
					result = true;
					break;
				}
				pointer1 = pointer1.getNext();
				pointer2 = pointer2.getNext();
				if (pointer2 != null) {
					pointer2 = pointer2.getNext();
				}
			}

			return result;
		}

	}

	public static void main(String[] args) {
		LinkedListWithLoop list = new LinkedListWithLoop();
		for (int value = 1; value <= 6; value++) {
			list.add(value);
		}
		list.print();
		list.loop(3);
		System.out.println(list.hasLoop());

	}

}

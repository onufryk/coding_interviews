package com.onufryk.exercise;

import com.onufryk.exercise.struct.Node;
import com.onufryk.exercise.struct.Stack;

public class Question021 {
	
	public static class CustomQueue {
		Stack stackLeft = new Stack();
		Stack stackRight = new Stack();
		
		public CustomQueue() {
			
		}
		
		public void enqueue(Integer value) {
			this.stackLeft.push(value);
		}
		
		public Integer dequeue() {
			if (this.stackRight.isEmpty()) {
				while (!this.stackLeft.isEmpty()) {
					stackRight.push(stackLeft.pop().getValue());
				}
			}
			if (this.stackRight.isEmpty()) {
				return null;
			}
			return this.stackRight.pop().getValue();
		}
		
	}

	public static void main(String[] args) {
		CustomQueue queue = new CustomQueue();
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(1);
		queue.enqueue(7);
		queue.enqueue(3);
		queue.enqueue(9);
		
		Integer cursor;
		do {
			cursor = queue.dequeue();
			System.out.println(cursor);
		} while (cursor != null);
		
	}

}

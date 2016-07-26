package com.onufryk.exercise;

import com.onufryk.exercise.struct.Queue;

public class Question022 {
	
	public static class CustomStack {
		private Queue queue1 = new Queue();
		private Queue queue2 = new Queue();
		
		public void push(Integer value) {
			if (!queue2.isEmpty()) {
				queue2.enqueue(value);
			} else {
				queue1.enqueue(value);
			}
			
		}
		public Integer pop() {
			if (queue1.isEmpty() && queue2.isEmpty()) {
				return null;
			}
			Queue emptyQ = queue1;
			Queue nonemptyQ = queue2;
			
			if (!queue1.isEmpty()) {
				emptyQ = queue2;
				nonemptyQ = queue1;
			}
			
			while (!nonemptyQ.hasOneItem()) {
				emptyQ.enqueue(nonemptyQ.dequeue());
			}
			return nonemptyQ.dequeue();
		}
		
		public void print() {
			System.out.println("Left:  "+queue1.print());
			System.out.println("Right: "+queue2.print());
		}
	}

	public static void main(String[] args) {
		CustomStack stack = new CustomStack();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		Integer value = stack.pop();
		while (value != null) {
			System.out.println(value);
			value = stack.pop();
		}
	}

}

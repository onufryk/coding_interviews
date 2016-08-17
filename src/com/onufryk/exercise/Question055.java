package com.onufryk.exercise;

import com.onufryk.exercise.struct.Node;
import com.onufryk.exercise.struct.Stack;

public class Question055 {
	public static class MinimalStack extends Stack {
		private Integer minimal;

		public MinimalStack() {
			super();
		}

		public void push(Integer value) {
			if (this.isEmpty()) {
				super.push(value);
				this.minimal = value;
			} else if (value >= minimal) {
				super.push(value);
			} else {
				super.push(2 * value - this.minimal);
				this.minimal = value;
			}
			this.print();
 		}

		public Node pop() {
			if (this.top.getValue() < this.minimal) {
				this.minimal = 2 * this.minimal - this.top.getValue();
			}
			
			return super.pop();
		}

		public void print() {
//			super.print();
			System.out.println("minimal:" + this.minimal);
		}
		
		
		
	}

	public static void main(String[] args) {
		
		MinimalStack stack = new MinimalStack();
		
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.pop().getValue());
		System.out.println(stack.pop().getValue());
		stack.push(0);
	}

}

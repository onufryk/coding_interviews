package com.onufryk.exercise;

import com.onufryk.exercise.struct.LinkedList;
import com.onufryk.exercise.struct.Stack;
import com.onufryk.exercise.struct.Node;

public class Question013 {
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Stack stack = new Stack();
				
		for (int ii = 1; ii <= 8; ii++) {
			list.add(ii);
			stack.push(ii);
		}
		
		list.print();
		
		list.printReversed();
		
		Node top = stack.pop();
		while (top != null) {
			System.out.println(top.getValue());
			top = stack.pop();
		}

	}

}

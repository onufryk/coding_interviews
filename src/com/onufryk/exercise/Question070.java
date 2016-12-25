package com.onufryk.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Question070 {
	private PriorityQueue<Integer> queue = null;
	
	class ReversedComparator implements Comparator<Integer> {
		public int compare(Integer int1, Integer int2) {
			int num1 = int1.intValue();
			int num2 = int2.intValue();
			if (num1 < num2)
				return 1;
			else if (num1 == num2)
				return 0;
			else
				return -1;
		}
	}
	
	public void getMinimums(Integer[] numbers, Integer k) {
		this.queue = new PriorityQueue<Integer>(k, new ReversedComparator());
		this.queue.clear();
		
		for (int ii = 0; ii < numbers.length; ii++) {
			if (this.queue.size() < k) {
				this.queue.add(numbers[ii]);
			} else {
				Integer max = this.queue.peek();
				if(this.queue.comparator().compare(numbers[ii], max) > 0) {
					this.queue.poll();
					this.queue.add(numbers[ii]);
				}
			}
		}
		
		Iterator<Integer> iter = this.queue.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		Integer numbers[] = { 4, 5, 1, 6, 2, 7, 3, 8 };
		Question070 app = new Question070();
		app.getMinimums(numbers, 4);
	}

}

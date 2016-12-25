package com.onufryk.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question069 {
	
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
	

	
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new ReversedComparator());
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private Double median = null;

	public void add(Integer number) {
		if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
			if(maxHeap.size() > 0 && number < maxHeap.peek()) {
				maxHeap.add(number);
				number = maxHeap.poll();
			}
				minHeap.add(number);
		} else {
			if(minHeap.size() > 0 && minHeap.peek() < number) {
				minHeap.add(number);
				number = minHeap.poll();
			}
			maxHeap.add(number);
		}

		int size = minHeap.size() + maxHeap.size();
		if (size == 0) {
			return;
		}

		this.median = 0.0;
		if ((size & 1) == 1) {
			this.median = new Double(this.minHeap.peek());
		} else {
			this.median = new Double(this.minHeap.peek() + this.maxHeap.peek()) / 2;
		}

		if (median != null) {
			System.out.println("Median is " + this.median);
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		Integer newNumber = 0;
		while (newNumber >= 0) {
			newNumber = scanner.nextInt();
			if (newNumber > 0) {
				this.add(newNumber);
			}
		}
		scanner.close();

	}

	public static void main(String[] args) {
		Question069 app = new Question069();
		app.run();
	}

}

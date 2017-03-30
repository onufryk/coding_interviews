package com.onufryk.exercise;

import java.util.Random;
import com.onufryk.exercise.struct.Node;
import com.onufryk.exercise.struct.LinkedList;

public class Question015 {
	
	public static Node<Integer> merge(Node<Integer> cursor1, Node<Integer> cursor2) {
		if (cursor1 == null) {
			return cursor2;
		} else if (cursor2 == null) {
			return cursor1;
		}
		Node<Integer> cursor = null;
		
		if (cursor1.getValue() < cursor2.getValue()) {
			cursor = cursor1;
			cursor.setNext(merge(cursor1.getNext(), cursor2));
		} else {
			cursor = cursor2;
			cursor.setNext(merge(cursor1, cursor2.getNext()));
		}
		return cursor;
	}

	public static void main(String[] args) {
		Random randomizer = new Random();
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();

		int prevVal = 0;
		for (int ii = 1; ii <= 10; ii++) {
			int newVal = randomizer.nextInt(10) + prevVal;
			list1.add(newVal);
			prevVal = newVal;
		}

		prevVal = 0;
		for (int ii = 1; ii <= 10; ii++) {
			int newVal = randomizer.nextInt(10) + prevVal;
			list2.add(newVal);
			prevVal = newVal;
		}

		list1.print();
		list2.print();

		Node<Integer> cursor1 = list1.getRoot();
		Node<Integer> cursor2 = list2.getRoot();

		while (cursor1 != null || cursor2 != null) {
			
			while (cursor1 != null && (cursor2 == null || cursor1.getValue() <= cursor2.getValue())) {
				list3.add(cursor1.getValue());
				cursor1 = cursor1.getNext();
			}
			
			while (cursor2 != null && (cursor1 == null || cursor2.getValue() <= cursor1.getValue())) {
				list3.add(cursor2.getValue());
				cursor2 = cursor2.getNext();
			}
			
		}

		list3.print();
		
		Node<Integer> sorted = merge(list1.getRoot(), list2.getRoot());
		LinkedList list4 = new LinkedList();
		try {
			list4.init(sorted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list4.print();
		

	}

}

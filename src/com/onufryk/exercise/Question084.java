package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinarySearchTree;

public class Question084 {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		tree.add(3);
		tree.add(2);
		tree.add(4);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		
		tree.traverseInOrder();
	}

}

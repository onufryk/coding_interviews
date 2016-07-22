package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinarySearchTree;

public class Question019 {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.setBuggy();
		
		tree.add(10);
		tree.add(6);
		tree.add(14);
		tree.add(4);
		tree.add(8);
		tree.add(12);
		tree.add(16);
		
		tree.traverseInOrder();
		System.out.println(tree.isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}

package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinarySearchTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question086 {

	public static Integer depth(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
	
	public static Boolean isBalanced(TreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		Integer left = depth(root.left);
		Integer right = depth(root.right);
		
		if (Math.abs(right - left) > 1) {
			return false;
		}
		
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(2);
		tree.add(1);
		tree.add(3);
		
		tree.traverseInOrder();
		System.out.println(isBalanced(tree.getRoot()));

	}

}

package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question020 {
	
	public static void main(String[] args) {
		TreeNode<Integer> nodeA = new TreeNode<Integer>(12);
		TreeNode<Integer> nodeB = new TreeNode<Integer>(6);
		TreeNode<Integer> nodeC = new TreeNode<Integer>(9);
		TreeNode<Integer> nodeD = new TreeNode<Integer>(5);
		TreeNode<Integer> nodeE = new TreeNode<Integer>(8);
		TreeNode<Integer> nodeF = new TreeNode<Integer>(10);
		
		nodeC.right = nodeF;
		nodeC.left = nodeE;
		nodeB.left = nodeD;
		nodeA.left = nodeB;
		nodeA.right = nodeC;

		BinaryTree<Integer> tree = new BinaryTree<Integer>(nodeA);
		
		tree.traverseInOrder();
		
		System.out.println(tree.sizeOfLargestTree());

	}

}

package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

/**
 * @deprecated
 */
public class Question020 {
	
	public static class CustomBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {

		public CustomBinaryTree() {
			super();
		}

		public CustomBinaryTree(TreeNode<Item> root) {
			super(root);
		}
		
		public int sizeOfLargestTree() {
			return this.sizeOfLargestTree(this.root);
		}
		
		private Integer sizeOfLargestTree(TreeNode<Item> node) {
			if (node == null) {
				return 0;
			}
			
			Integer leftSubtreeSize = sizeOfLargestTree(node.left);
			
			Integer rightSubtreeSize = sizeOfLargestTree(node.right);
			
			return leftSubtreeSize + rightSubtreeSize + 1;
			/*
			if (node == null) {
				largestSize = 0;
				min = Integer.MIN_VALUE;
				max = Integer.MAX_VALUE;
				return true;
			}
			int minLeft = Integer.MIN_VALUE, maxLeft = Integer.MAX_VALUE, leftSize = 0;
			boolean left = this.sizeOfLargestTree(node.left, minLeft, maxLeft, leftSize);
			
			int minRight = Integer.MIN_VALUE, maxRight = Integer.MAX_VALUE, rightSize = 0;
			boolean right = this.sizeOfLargestTree(node.right, minRight, maxRight, rightSize);
			
			boolean overall = false;
			if (left && right && node.value.compareTo(maxLeft) == -1 && node.value.compareTo(minRight) == 1) {
				largestSize = leftSize + rightSize + 1;
				overall = true;
				
				min = (node.value < minLeft ) ? node.value : minLeft;
				max = (node.value > maxRight) ? node.value : maxRight;
			} else {
				largestSize = (leftSize > rightSize) ? leftSize : rightSize;
			}
			
			return overall;
			*/
		}
	}
	
	
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

		CustomBinaryTree<Integer> tree = new CustomBinaryTree<Integer>(nodeA);
		
		tree.traverseInOrder();
		
		System.out.println(tree.sizeOfLargestTree());

	}

}

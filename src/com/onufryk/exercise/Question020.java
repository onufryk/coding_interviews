package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question020 {
	public static class SearchContext {
		public Integer min = Integer.MAX_VALUE;
		public Integer max = Integer.MIN_VALUE;
		public Integer size = 0;
		public Boolean isBST = false;
	}
	
	public static class CustomBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {

		public CustomBinaryTree() {
			super();
		}

		public CustomBinaryTree(TreeNode<Item> root) {
			super(root);
		}
		
		public int sizeOfLargestTree() {
			SearchContext context = this.sizeOfLargestTree(this.root, new SearchContext());
			return context.size;
		}
		
		private SearchContext sizeOfLargestTree(TreeNode<Item> node, SearchContext context) {
			if (node == null) {
				context.min = Integer.MAX_VALUE;
				context.max = Integer.MIN_VALUE;
				context.isBST = true;
				context.size = 0;
				return context;
			}
			
			SearchContext left = this.sizeOfLargestTree(node.left, new SearchContext());
			SearchContext right = this.sizeOfLargestTree(node.right, new SearchContext());
			
			context.isBST = false;
			if (left.isBST && right.isBST && node.value.compareTo((Item)left.max) != -1 && node.value.compareTo((Item)right.min) != 1) {
				context.size = left.size + right.size + 1;
				context.isBST = true;
				context.min = (node.value.compareTo((Item)left.min) == -1) ? (Integer)node.value : left.min;
				context.max = (node.value.compareTo((Item)right.max) == 1) ? (Integer)node.value : right.max;
			} else {
				context.size = (left.size > right.size) ? left.size : right.size;
			}
			return context;
			
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

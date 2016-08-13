package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question050 {
	public static class SubsctructuredBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {

		public SubsctructuredBinaryTree() {
			super();
			
		}

		public SubsctructuredBinaryTree(TreeNode<Item> root) {
			super(root);
		}
		
		public Boolean containsSubtree(TreeNode<Item> subtree) {
			return this.containsSubtree(this.root, subtree);
		}
		private Boolean containsSubtree(TreeNode<Item> tree, TreeNode<Item> subtree) {
			Boolean result = false;
			if (tree == null || subtree == null) {
				return false;
			}
			if (tree.value == subtree.value) {
				result = this.hasSubtree(tree, subtree);
			}
			if (!result) {
				result = this.containsSubtree(tree.left, subtree);
			}
			if (!result) {
				result = this.containsSubtree(tree.right, subtree);
			}
			return result;
		}
		private Boolean hasSubtree(TreeNode<Item> tree, TreeNode<Item> subtree) {
			Boolean result = false;
			if (subtree == null) {
				return true;
			}
			if (tree == null) {
				return false;
			}
			if (tree.value != subtree.value) {
				return false;
			}
			
			return this.hasSubtree(tree.left, subtree.left) && this.hasSubtree(tree.right, subtree.right);
		}
	}
	

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(8,  
			new TreeNode<Integer>(8,  
				new TreeNode<Integer>(9),  
				new TreeNode<Integer>(2,  
					new TreeNode<Integer>(4),  
					new TreeNode<Integer>(7)
				)
			),  
			new TreeNode<Integer>(7)
		);
		TreeNode<Integer> sub = new TreeNode<Integer>(8, new TreeNode<Integer>(9), new TreeNode<Integer>(2));
		SubsctructuredBinaryTree<Integer> tree = new SubsctructuredBinaryTree<Integer>(root);
		tree.traverseInOrder();
		System.out.println(tree.containsSubtree(sub));
	}

}

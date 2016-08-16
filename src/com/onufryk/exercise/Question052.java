package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question052 {

	public static class SymmetricalBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {

		public SymmetricalBinaryTree(TreeNode<Item> root) {
			super(root);
		}
		
		public Boolean isSymmetrical() {
			if (this.root == null) {
				return false;
			}
			return this.isSymmetrical(this.root, this.root);
		}
		public Boolean isSymmetrical(TreeNode<Item> node1, TreeNode<Item> node2) {
			if (node1 == null && node2 == null) {
				return true;
			}
			if (node1 == null || node2 == null) {
				return false;
			}
			if (node1.value != node2.value) {
				return false;
			}
			
			return this.isSymmetrical(node1.left, node2.right) && this.isSymmetrical(node2.left, node1.right);
		}

	}

	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<Integer>(8,
				new TreeNode<Integer>(6, new TreeNode<Integer>(5), new TreeNode<Integer>(7)),
				new TreeNode<Integer>(6, new TreeNode<Integer>(7), new TreeNode<Integer>(5)));
		TreeNode<Integer> root2 = new TreeNode<Integer>(8,
				new TreeNode<Integer>(6, new TreeNode<Integer>(5), new TreeNode<Integer>(7)),
				new TreeNode<Integer>(9, new TreeNode<Integer>(7), new TreeNode<Integer>(5)));
		TreeNode<Integer> root3 = new TreeNode<Integer>(8,
				new TreeNode<Integer>(6, new TreeNode<Integer>(5), new TreeNode<Integer>(7)),
				new TreeNode<Integer>(6, new TreeNode<Integer>(7), null));
		
		SymmetricalBinaryTree<Integer> tree1 = new SymmetricalBinaryTree<Integer>(root1);
		SymmetricalBinaryTree<Integer> tree2 = new SymmetricalBinaryTree<Integer>(root2);
		SymmetricalBinaryTree<Integer> tree3 = new SymmetricalBinaryTree<Integer>(root3);
		
		tree1.traverseInOrder();
		System.out.println(tree1.isSymmetrical());
		tree2.traverseInOrder();
		System.out.println(tree2.isSymmetrical());
		tree3.traverseInOrder();
		System.out.println(tree3.isSymmetrical());

	}

}

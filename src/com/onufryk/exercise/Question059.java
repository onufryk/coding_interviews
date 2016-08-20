package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.NodeStack;
import com.onufryk.exercise.struct.TreeNode;

public class Question059 {
	public static class ZigZagBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {
		private NodeStack<Item> stackForLefts = null;
		private NodeStack<Item> stackForRights = null;

		public ZigZagBinaryTree() {
			super();
		}

		public ZigZagBinaryTree(TreeNode<Item> root) {
			super(root);
		}

		public void ZigZag() {
			if (this.root == null) {
				return;
			}
			this.stackForLefts = new NodeStack<Item>();
			this.stackForRights = new NodeStack<Item>();

			boolean left = true;

			this.stackForLefts.push(root);

			while (!this.stackForLefts.isEmpty() || !this.stackForRights.isEmpty()) {
				if (left) {
					TreeNode<Item> head = this.stackForLefts.pop();
					
					System.out.printf("%d ", head.value);
					
					if (head.left != null) {
						stackForRights.push(head.left);
					}
					if (head.right != null) {
						stackForRights.push(head.right);
					}
					if (this.stackForLefts.isEmpty()) {
						System.out.println();
						left = false;
					}
				} else {
					TreeNode<Item> head = this.stackForRights.pop();
					
					System.out.printf("%d ", head.value);
					
					if (head.right != null) {
						stackForLefts.push(head.right);
					}
					if (head.left != null) {
						stackForLefts.push(head.left);
					}
					if (this.stackForRights.isEmpty()) {
						System.out.println();
						left = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ZigZagBinaryTree<Integer> tree = new ZigZagBinaryTree<Integer>(new TreeNode<Integer>(1,
				new TreeNode<Integer>(2, new TreeNode<Integer>(4, new TreeNode<Integer>(8), new TreeNode<Integer>(9)),
						new TreeNode<Integer>(5, new TreeNode<Integer>(10), new TreeNode<Integer>(11))),
				new TreeNode<Integer>(3, new TreeNode<Integer>(6, new TreeNode<Integer>(12), new TreeNode<Integer>(13)),
						new TreeNode<Integer>(7, new TreeNode<Integer>(14), new TreeNode<Integer>(15)))));

		tree.traversePreOrder();
		tree.ZigZag();
	}

}

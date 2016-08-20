package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.NodeStack;
import com.onufryk.exercise.struct.TreeNode;

public class Question060 {

	public static class BinaryTreeWithPath<Item extends Comparable<Item>> extends BinaryTree<Item> {
		private NodeStack<Integer> path = null;

		public BinaryTreeWithPath() {
			super();
		}

		public BinaryTreeWithPath(TreeNode<Item> root) {
			super(root);
		}

		public void findPath(Integer number) {
			if (this.root == null) {
				return;
			}
			Integer sum = 0;

			this.path = new NodeStack<Integer>();

			this.findPath(this.root, number, sum, this.path);
		}

		private void findPath(TreeNode<Item> node, Integer number, Integer sum, NodeStack<Integer> path) {
			if (node == null) {
				return;
			}
			sum = sum + (Integer) node.value;
			path.push(new TreeNode(node.value));

			boolean isLeaf = node.left == null && node.right == null;
			if (isLeaf && sum == number) {
				path.print();
			}

			if (node.left != null) {
				this.findPath(node.left, number, sum, path);
			}
			if (node.right != null) {
				this.findPath(node.right, number, sum, path);
			}
			path.pop();
		}

	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(10,
				new TreeNode<Integer>(5, new TreeNode<Integer>(4), new TreeNode<Integer>(7)), new TreeNode<Integer>(12));

		BinaryTreeWithPath<Integer> tree = new BinaryTreeWithPath<Integer>(root);

		tree.traverseInOrder();
		tree.findPath(22);
	}

}

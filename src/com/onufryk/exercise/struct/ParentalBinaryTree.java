package com.onufryk.exercise.struct;

public class ParentalBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {
	public ParentalBinaryTree(TreeNode<Item> root) {
		super(root);
	}

	public TreeNode<Item> nextNode(TreeNode<Item> node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			TreeNode<Item> cursor = node.right;
			while (cursor.left != null) {
				cursor = cursor.left;
			}
			return cursor;
		} else if (node.parent != null) {
			if (node.parent.left == node) {
				return node.parent;
			} else {
				TreeNode<Item> cursor = node;
				while (cursor.parent != null && cursor.parent.left != cursor) {
					cursor = cursor.parent;
				}
				return cursor.parent;
			}
		}
		return null;
	}
}

package com.onufryk.exercise.struct;

public class BinaryTree<Item> {
	protected TreeNode<Item> root = null;

	public BinaryTree() {
	}

	public BinaryTree(TreeNode<Item> root) {
		this.root = root;
	}
	
	public void traversePreOrder() {
		this.traversePreOrder(this.root);
		System.out.println();
	}
	
	public void traversePreOrder(TreeNode<Item> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value);
		System.out.print(" ");
		this.traversePreOrder(node.left);
		this.traversePreOrder(node.right);
	}
	
	public void traverseInOrder() {
		this.traverseInOrder(this.root);
		System.out.println();
	}
	public void traverseInOrder(TreeNode<Item> node) {
		if (node == null) {
			return;
		}
		this.traverseInOrder(node.left);
		System.out.print(node.value);
		System.out.print(" ");
		this.traverseInOrder(node.right);
	}
	
	public void traversePostOrder() {
		this.traversePostOrder(this.root);
		System.out.println();
	}
	
	public void traversePostOrder(TreeNode<Item> node) {
		if (node == null) {
			return;
		}
		this.traversePostOrder(node.left);
		this.traversePostOrder(node.right);
		System.out.print(node.value);
		System.out.print(" ");
		
	}
	
	public void traverseBreadthFirst() {
		traverseBreadthFirst(this.root);
	}
	
	private void traverseBreadthFirst(TreeNode<Item> node) {
		if (node == null) {
			return;
		}
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

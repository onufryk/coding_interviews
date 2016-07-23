package com.onufryk.exercise.struct;

public class BinaryTree<Item extends Comparable<Item>> {
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
	
	public int sizeOfLargestTree() {
		return this.sizeOfLargestTree(this.root, 0, 0, 0);
	}
	
	private Integer sizeOfLargestTree(TreeNode<Item> node, int min, int max, int largestSize) {
		if (node == null) {
			return 0;
		}
		return sizeOfLargestTree(node.left, min, max, largestSize) + sizeOfLargestTree(node.right, min, max, largestSize) + 1;
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

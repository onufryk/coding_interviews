package com.onufryk.exercise.struct;

public class BinarySearchTree<Item extends Comparable<Item>> extends BinaryTree<Item> {
	private boolean isBuggy = false;
	
	public void setBuggy() {
		this.isBuggy = true;
	}
	
	public Boolean isBinarySearchTree(Item min, Item max) {
		return this.isBinarySearchTree(this.root, min, max);
	}
	
	public Boolean isBinarySearchTree(TreeNode<Item> node, Item min, Item max) {
		if (node == null) {
			return true;
		}
		System.out.print(node.value);
		System.out.print(" ");
		
		if (node.value.compareTo(min) == -1 || node.value.compareTo(max) == 1) {
			return false;
		}
		
		return this.isBinarySearchTree(node.left, min, node.value) && this.isBinarySearchTree(node.right, node.value, max);
	}
	
	public Boolean isBinarySearchTree(Item min) {
		return this.isBinarySearchTree(this.root, min);
	}
	
	public Boolean isBinarySearchTree(TreeNode<Item> node, Item min) {
		if (node == null) {
			return true;
		}
		return this.isBinarySearchTree(node.left, min) && node.value.compareTo(min) == 1 && this.isBinarySearchTree(node.right, min = node.value);
	}
	

	
	public void add(Item value) {
		if (this.root == null) {
			this.root = new TreeNode<Item>(value);
			return;
		}
		this.add(value, this.root);
	}
	
	private void add(Item value, TreeNode<Item> parent) {
		if (parent == null) {
			parent = new TreeNode<Item>(value);
			return;
		}
		int comparison = value.compareTo(parent.value);
		if (comparison == -1) {
			if (parent.left == null) {
				parent.left = new TreeNode<Item>(value);
			} else {
				this.add(value, parent.left);
			}
		} else if (comparison == 1) {
			if (parent.right == null) {
				parent.right = new TreeNode<Item>(value);
				if (this.isBuggy && value.compareTo((Item)new Integer(8)) == 0) {
					parent.right.right = new TreeNode<Item>(((Item)new Integer(3)));
				}
			} else {
				this.add(value, parent.right);
			}
		}
	}
	
}

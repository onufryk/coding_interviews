package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinarySearchTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question064 {

	public static class LinkedListBST<T extends Comparable<T>> extends BinarySearchTree<T> {
		public static final boolean LEFT = true;
		public static final boolean RIGHT = false;

		public TreeNode<T> head = null;
		public TreeNode<T> tail = null;
		public TreeNode<T> lastNodeInTheList = null;

		public void convertToList() {
			this.lastNodeInTheList = null;
			this.convertToList(this.root);
			
			this.tail = this.lastNodeInTheList;
			
			this.head = this.lastNodeInTheList;
			while (this.head != null && this.head.left != null) {
				this.head = this.head.left;
			}
		}

		public void convertToList(TreeNode<T> node) {
			if (node == null) {
				return;
			}
			
			TreeNode<T> current = node;
			
			if (current.left != null) {
				convertToList(current.left);
			}
			
			current.left = this.lastNodeInTheList;
			
			if (this.lastNodeInTheList != null) {
				this.lastNodeInTheList.right = current;
			}
			
			this.lastNodeInTheList = current;
			
			if (current.right != null) {
				convertToList(current.right);
			}
		}

		public void printListForward() {
			TreeNode<T> current = this.head;
			while (current != null) {
				System.out.printf("%s ",current.value);
				current = current.right;
			}
			System.out.println();
		}

		public void printListReversed() {
			TreeNode<T> current = this.tail;
			while (current != null) {
				System.out.printf("%s ", current.value);
				current = current.left;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LinkedListBST<Integer> tree = new LinkedListBST<Integer>();
		tree.add(8);
		tree.add(6);
		tree.add(10);
		tree.add(5);
		tree.add(7);
		tree.add(9);
		tree.add(11);

		tree.traverseInOrder();
		
		tree.convertToList();

		tree.printListForward();
		tree.printListReversed();

	}

}

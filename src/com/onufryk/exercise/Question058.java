package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.NodeQueue;
import com.onufryk.exercise.struct.TreeNode;

public class Question058 {
	public static class LeveledBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {
		private NodeQueue queue = null;

		public LeveledBinaryTree() {
			super();
		}

		public LeveledBinaryTree(TreeNode<Item> root) {
			super(root);
		}

		public void traverseLevels() {
			if (this.root == null) {
				return;
			}
			this.queue = new NodeQueue();
			
			this.queue.enqueue((TreeNode<Integer>)this.root);
			
			int toBePrinted = 1;
			int inNextLevel = 0;
			
			while (!this.queue.isEmpty()) {
				TreeNode<Integer> top = this.queue.dequeue();
				
				System.out.print(top.value);
				System.out.print(" ");
				
				if (top.left != null) {
					this.queue.enqueue((TreeNode<Integer>)top.left);
					inNextLevel++;
				}
				if (top.right != null) {
					this.queue.enqueue((TreeNode<Integer>)top.right);
					inNextLevel++;
				}
				toBePrinted--;
				if (toBePrinted == 0) {
					System.out.println();
					toBePrinted = inNextLevel;
					inNextLevel = 0;
				}
			}

			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(8,
				new TreeNode<Integer>(6, new TreeNode<Integer>(5), new TreeNode<Integer>(7)),
				new TreeNode<Integer>(10, new TreeNode<Integer>(9), new TreeNode<Integer>(11)));

		LeveledBinaryTree<Integer> tree = new LeveledBinaryTree<Integer>(root);

		tree.traverseInOrder();

		tree.traverseLevels();
	}

}

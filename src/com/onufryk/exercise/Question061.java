package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question061 {
	int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
	int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
	
	BinaryTree<Integer> tree = null;

	public Question061() {}
	
	public void run() {
		this.tree = new BinaryTree<Integer>(this.buildTree());
		this.tree.traversePreOrder();
		this.tree.traverseInOrder();
	}
	
	public TreeNode<Integer> buildTree() {
		return this.buildTree(0, this.preOrder.length - 1, 0, this.inOrder.length - 1);
	}
	
	private  TreeNode<Integer> buildTree(int startPreorder, int endPreorder, int startInorder, int endInorder) {
		TreeNode<Integer> root = new TreeNode<Integer>();
		
		int rootValue = this.preOrder[startPreorder];
		int inorderPosition = startInorder;
		while (this.inOrder[inorderPosition] != rootValue) {
			inorderPosition++;
		}
		
		root.value = rootValue;
		root.left = null;
		root.right = null;

		if(startPreorder == endPreorder) {
			if(startInorder == endInorder && this.preOrder[startPreorder] == this.inOrder[startInorder]) {
				return root;
			}
		}
		
		int leftLength = inorderPosition - startInorder;
		int leftPreorderEnd = startPreorder + leftLength;
		if(leftLength > 0) {
			root.left = buildTree(startPreorder + 1, leftPreorderEnd, startInorder, inorderPosition - 1);
		}
		if(leftLength < endPreorder - startPreorder) {
			root.right = buildTree(leftPreorderEnd + 1, endPreorder, inorderPosition + 1, endInorder);
		}
		
		return root;
	}

	public static void main(String[] args) {
		Question061 app = new Question061();
		app.run();
	}

}

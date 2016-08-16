package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question051 {
	private BinaryTree<Integer> tree = null;
	
	public void setTree(TreeNode<Integer> node) {
		this.tree = new BinaryTree<Integer>(node); 
	}
	
	public BinaryTree<Integer> getTree() {
		return this.tree;
	}
	
	public void mirror() {
		if (this.tree == null) {
			return;
		}
		this.mirror(this.tree.getRoot());
	}
	
	private void mirror(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			return;
		}
		this.mirror(node.left);
		this.mirror(node.right);
		
		TreeNode<Integer> tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}

	public static void main(String[] args) {
		Question051 app = new Question051();
		
		TreeNode<Integer> tree = new TreeNode<Integer>(8, 
				new TreeNode<Integer>(6,
						new TreeNode<Integer>(5), 
						new TreeNode<Integer>(7)
				), 
				new TreeNode<Integer>(10, 
						new TreeNode<Integer>(9), 
						new TreeNode<Integer>(11)
				)
		);

		app.setTree(tree);
		
		app.getTree().traverseInOrder();
		
		app.mirror();
		
		app.getTree().traverseInOrder();
	}

}

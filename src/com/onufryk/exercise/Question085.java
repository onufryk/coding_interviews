package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question085 {
	
	public static Integer depth(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(
				new TreeNode<Integer>(1,
						new TreeNode<Integer>(2,
								new TreeNode<Integer>(4),
								new TreeNode<Integer>(5,
									new TreeNode<Integer>(7),
									null
								)
						),
						new TreeNode<Integer>(3,
								null,
								new TreeNode<Integer>(6)
						)
				)
		);
		tree.traverseInOrder();
		System.out.println(depth(tree.getRoot()));
	}
	
	

}

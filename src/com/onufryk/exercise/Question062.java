package com.onufryk.exercise;

import com.onufryk.exercise.struct.BinaryTree;
import com.onufryk.exercise.struct.TreeNode;

public class Question062 {
	
	public static class SerializableBinaryTree<Item extends Comparable<Item>> extends BinaryTree<Item> {
		private String serialized = null;

		public SerializableBinaryTree() {
			super();
		}

		public SerializableBinaryTree(TreeNode<Item> root) {
			super(root);
		}
		
		public String serialize() {
			return serialize(this.root, new String());
		}
		
		private String serialize(TreeNode<Item> currentNode, String currentString) {
			if (currentNode == null) {
				currentString = currentString.concat("$,");
				return currentString;
			}
			currentString = currentString.concat(currentNode.value+",");
			currentString = serialize(currentNode.left, currentString);
			currentString = serialize(currentNode.right, currentString);
			return currentString;
		}
		
		public SerializableBinaryTree<Item> deserialize (String serialized) {
			this.serialized = serialized;
			return new SerializableBinaryTree<Item>(this.deserialize(new TreeNode<Item>()));
		}
		
		private TreeNode<Item> deserialize (TreeNode<Item> currentNode) {
			String item = serialized.substring(0, 2);
			String digit = item.substring(0,1);
			serialized = serialized.substring(2);
			
			if (digit.equals("$")) {
				currentNode = null;
			} else {
				Integer value = Integer.parseInt(digit);
				currentNode.value = (Item)value;
				currentNode.left = new TreeNode<Item>();
				currentNode.right = new TreeNode<Item>();
				if (deserialize(currentNode.left) == null) {
					currentNode.left = null;
				}
				if (deserialize(currentNode.right) == null) {
					currentNode.right = null;
				}
			}
			
			
			return currentNode;
			
			
		}
	}
	
	SerializableBinaryTree<Integer> tree = null;
	
	public Question062() {
	}

	public void run(TreeNode<Integer> root) {
		tree = new SerializableBinaryTree<Integer>(root);
		
		tree.traverseInOrder();
		
		String serialized = tree.serialize();
		
		System.out.println(serialized);
		
		SerializableBinaryTree<Integer> restored = tree.deserialize(serialized);
		
		restored.traverseInOrder();
	}

	public static void main(String[] args) {
		Question062 app = new Question062();

		TreeNode<Integer> root = new TreeNode<Integer>(1, new TreeNode<Integer>(2, new TreeNode<Integer>(4), null),
				new TreeNode<Integer>(3, new TreeNode<Integer>(5), new TreeNode<Integer>(6)));

		app.run(root);
	}

}

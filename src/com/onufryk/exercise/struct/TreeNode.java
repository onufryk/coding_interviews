package com.onufryk.exercise.struct;

public class TreeNode<Item> {
	public Item value = null;
	public TreeNode<Item> parent = null;
	public TreeNode<Item> left = null;
	public TreeNode<Item> right = null;
	
	public TreeNode() {
		
	}
	
	public TreeNode(Item value) {
		this.value = value;
	}

	public String toString() {
		if (this.value != null) {
			return this.value.toString();
		}
		return super.toString();
	}
	
	
}

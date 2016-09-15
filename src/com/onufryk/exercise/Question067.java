package com.onufryk.exercise;

import com.onufryk.exercise.struct.Stack;

public class Question067 {
	private Integer[][] input = {{1,2},{3,4},{5,6}};
	
	public void print_permutations() {
		if (this.input == null) {
			return;
		}
		Stack permutation = new Stack();
		permutations(permutation);
	}
	
	private void permutations(Stack permutation) {
		if (permutation.size() == input.length) {
			permutation.print();
			return;
		}
		Integer[] array = input[permutation.size()];
		for (int ii = 0; ii < array.length; ii++) {
			permutation.push(array[ii]);
			permutations(permutation);
			permutation.pop();
		}
	}

	public static void main(String[] args) {
		Question067 app = new Question067();
		
		app.print_permutations();

	}

}

package com.onufryk.exercise;

import java.util.ArrayList;
import java.util.List;

public class Question074 {
	private Integer minimum = Integer.MAX_VALUE;
	private Integer arr[] = null;
	private List<Integer> permutations = new ArrayList<Integer>();

	public Question074(Integer[] arr) {
		this.arr = arr;
	}
	
	public void perm(Integer index) {
		if (index == this.arr.length) {
			StringBuffer permutation = new StringBuffer();
			for (int ii = 0; ii < this.arr.length; ii++) {
				permutation.append(this.arr[ii]);
			}
			Integer permValue = Integer.parseInt(permutation.toString());
			if (permValue < minimum) {
				minimum = permValue;
			}
			this.permutations.add(permValue);
		} else {
			for (int ii = index; ii < this.arr.length; ii++) {
				Integer tmp = arr[index];
				arr[index] = arr[ii];
				arr[ii] = tmp;
				
				perm(index + 1);
				
				tmp = arr[index];
				arr[index] = arr[ii];
				arr[ii] = tmp;
			}
		}
	}

	public void go() {
		perm(0);
		for (Integer permutation : this.permutations) {
			System.out.println(permutation);
		}
		System.out.println("Minimum is " + this.minimum);
	}
	
	public static void main(String[] args) {
		Integer input[] = {3, 32, 321};
		Question074 app = new Question074(input);
		app.go();
	}

}

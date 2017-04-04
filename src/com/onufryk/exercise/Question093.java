package com.onufryk.exercise;

public class Question093 {
	public static void bruteforce(Integer arr[], Integer size) {
		for (int ii = 0; ii < arr.length - size + 1; ii++) {
			Integer max = arr[ii];
			for (int jj = 0; jj < size; jj++) {
				if (arr[ii + jj] > max) {
					max = arr[ii + jj];
				}
			}
			System.out.print(max);
		}
	}

	public static void main(String[] args) {
		Integer numbers[] = {2, 3, 4, 2, 6, 2, 5, 1};
		Integer size = 3;
		bruteforce(numbers, size);
	}

}

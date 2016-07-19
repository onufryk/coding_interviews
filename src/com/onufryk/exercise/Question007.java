package com.onufryk.exercise;

public class Question007 {

	public static void main(String[] args) {
		Integer matrix[][] = { { 1, 3, 5 }, { 7, 9, 11 }, { 13, 15, 17 } };
		Integer value = 11;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start = 0;
		int end = rows * cols - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int row = mid / cols;
			int col = mid % cols;
			int v = matrix[row][col];
			if (v == value) {
				System.out.println("Found");
				return;
			}
			if (v > value)
				end = mid - 1;
			else
				start = mid + 1;
		}
		System.out.println("Not found");

	}

}

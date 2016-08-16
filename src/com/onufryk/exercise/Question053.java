package com.onufryk.exercise;

public class Question053 {

	public static void main(String[] args) {
		Integer[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int rows = 4;
		int cols = 4;
		int start = 0;

		while (cols > start * 2 && rows > start * 2) {
			int endX = cols - 1 - start;
			int endY = rows - 1 - start;

			for (int i = start; i <= endX; ++i) {
				int number = matrix[start][i];
				System.out.print(number);
				System.out.print(' ');
			}

			if (start < endY) {
				for (int i = start + 1; i <= endY; ++i) {
					int number = matrix[i][endX];
					System.out.print(number);
					System.out.print(' ');
				}
			}

			if (start < endX && start < endY) {
				for (int i = endX - 1; i >= start; --i) {
					int number = matrix[endY][i];
					System.out.print(number);
					System.out.print(' ');
				}
			}

			if (start < endX && start < endY - 1) {
				for (int i = endY - 1; i >= start + 1; --i) {
					int number = matrix[i][start];
					System.out.print(number);
					System.out.print(' ');
				}
			}
			++start;
		}
		System.out.println();
	}

}

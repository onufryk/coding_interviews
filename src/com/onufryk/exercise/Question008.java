package com.onufryk.exercise;

public class Question008 {
	public Integer matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 }, };

	private Boolean findUsingBinarySearch(Integer n) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int ii = 0; ii < rows; ii++) {
			int start = 0;
			int end = cols - 1;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (matrix[ii][mid] == n) {
					System.out.println(ii + ", " + mid);
					return true;
				} else if (matrix[ii][mid] < n) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

		}

		return false;
	}

	private Boolean findInSubMatrix(Integer n, int startRow, int startCol, int endRow, int endCol) {
		if (n < matrix[startRow][startCol] || n > matrix[endRow][endCol]) {
			return false;
		}
		if (n == matrix[startRow][startCol] || n == matrix[endRow][endCol]) {
			return true;
		}

		int initialStartRow = startRow;
		int initialStartCol = startCol;
		int initialEndRow = endRow;
		int initialEndCol = endCol;

		int midRow = (endRow + startRow) / 2;
		int midCol = (endCol + startCol) / 2;

		while ((midRow != startRow || midCol != startCol) && (midRow != endRow || midCol != endCol)) {
			if (matrix[midRow][midCol] == n) {
				return true;
			}
			if (n < matrix[midRow][midCol]) {
				endRow = midRow;
				endCol = midCol;
			} else {
				startRow = midRow;
				startCol = midCol;
			}
			midRow = (startRow + endRow) / 2;
			midCol = (startCol + endCol) / 2;
		}

		boolean found = false;

		if (midRow < matrix.length - 1) {
			found = this.findInSubMatrix(n, midRow + 1, initialStartCol, initialEndRow, midCol);
		}
		if (!found && midCol < matrix[0].length - 1) {
			found = this.findInSubMatrix(n, initialStartRow, midCol + 1, midRow, initialEndCol);
		}

		return found;
	}

	private Boolean findRecursively(Integer n) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		return findInSubMatrix(n, 0, 0, rows - 1, cols - 1);
	}

	private Boolean findByReduction(Integer n) {
		boolean found = false;
		int row = 0;
		int col = matrix[0].length - 1;

		while (row < matrix.length && col >= 0) {
			if (n == matrix[row][col]) {
				found = true;
				break;
			}
			if (matrix[row][col] > n) {
				--col;
			} else {
				++row;
			}
		}

		return found;
	}

	public Boolean find(Integer n) {
		return this.findByReduction(n);
	}

	public static void main(String[] args) {
		Question008 app = new Question008();
		if (app.find(1)) {
			System.out.println("Number found.");
		} else {
			System.out.println("Number not found.");
		}
	}

}

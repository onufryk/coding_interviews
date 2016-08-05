package com.onufryk.exercise;

public class Question030 {
	private char[][] matrix = { 
			{ 'a', 'b', 'c', 'e' }, 
			{ 's', 'f', 'c', 's' }, 
			{ 'a', 'd', 'e', 'e' } };
	private int rows = 3;
	private int cols = 4;
	private Boolean[][] visited = new Boolean[rows][cols];
	private int pathLength = 0;

	public Boolean containsPath(String str) {
		if (this.matrix == null || this.rows < 1 || this.cols < 1 || str == null) {
			return false;
		}
		this.pathLength = 0;
		for (int row = 0; row < this.rows; row++) {
			for (int col = 0; col < this.cols; col++) {
				this.visited[row][col] = false;
			}
		}
		for (int row = 0; row < this.rows; row++) {
			for (int col = 0; col < this.cols; col++) {
				if (this.containsPath(str, row, col)) {
					return true;
				}
			}
		}
		return false;
	}

	private Boolean containsPath(String str, int row, int col) {
		if (this.pathLength == str.length()) {
			return true;
		}
		Boolean hasPath = false;

		if (row >= 0 && row < this.rows && col >= 0 && col < this.cols
				&& this.matrix[row][col] == str.charAt(this.pathLength) && !this.visited[row][col]) {
			this.pathLength++;
			this.visited[row][col] = true;
			hasPath = this.containsPath(str, row, col - 1) || this.containsPath(str, row - 1, col)
					|| this.containsPath(str, row, col + 1) || this.containsPath(str, row + 1, col);
			if (!hasPath) {
				this.pathLength--;
				this.visited[row][col] = false;
			}
		}

		return hasPath;
	}

	public static void main(String[] args) {
		Question030 app = new Question030();
		System.out.println(app.containsPath("bcced"));
		System.out.println(app.containsPath("abcb"));
		System.out.println(app.containsPath("abceseedasfc"));
	}

}

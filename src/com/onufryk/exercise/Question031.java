package com.onufryk.exercise;

public class Question031 {
	private int[][] cells;
	private boolean[][] visited;
	private int rows;
	private int cols;

	public Question031(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.cells = new int[rows][cols];
		this.visited = new boolean[rows][cols];
	}

	public int movesCount(int threshold) {
		for (int row = 0; row < this.rows; row++) {
			for (int col = 0; col < this.cols; col++) {
				this.cells[row][col] = 5;
				this.visited[row][col] = false;
			}
		}
		return this.movesCount(threshold, 0, 0);
	}

	private int movesCount(int threshold, int row, int col) {
		int count = 0;
		if (this.check(threshold, row, col)) {
			this.visited[row][col] = true;
			count = 1 + this.movesCount(threshold, row, col - 1) + this.movesCount(threshold, row - 1, col)
					+ this.movesCount(threshold, row, col + 1) + this.movesCount(threshold, row + 1, col);
		}
		return count;
	}

	private boolean check(int threshold, int row, int col) {
		if (row < 0 || row >= this.rows) {
			return false;
		}
		if (col < 0 || col >= this.cols) {
			return false;
		}
		if (this.visited[row][col]) {
			return false;
		}
		return (this.sumDigits(row) + this.sumDigits(col) <= threshold);
	}

	private int sumDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Question031 app = new Question031(4, 4);
		System.out.println(app.movesCount(3));
	}

}

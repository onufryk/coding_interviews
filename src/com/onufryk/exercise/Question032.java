package com.onufryk.exercise;

public class Question032 {
	private int len1;
	private int len2;
	private int[][] distances;

	public int getDistance(String from, String to) {
		this.len1 = from.length();
		this.len2 = to.length();
		this.distances = new int[len2 + 1][len1 + 1];
		
		for (int ii = 0; ii < this.len2 + 1; ii++) {
			this.distances[ii][0] = ii;
		}
		for (int jj = 0; jj < this.len1 + 1; jj++) {
			this.distances[0][jj] = jj;
		}
		
		for (int ii = 1; ii < this.len2 + 1; ++ii) {
			for (int jj = 1; jj < this.len1 + 1; ++jj) {
				if (from.charAt(jj - 1) == to.charAt(ii - 1)) {
					this.distances[ii][jj] = this.distances[ii - 1][jj - 1];
				} else {
					int deletion = this.distances[ii][jj - 1] + 1;
					int insertion = this.distances[ii - 1][jj] + 1;
					int substitution = this.distances[ii - 1][jj - 1] + 1;
					this.distances[ii][jj] = this.Min(deletion, insertion, substitution);
				}
			}
		}
		return this.distances[len2][len1];
	}
	private int Min(int num1, int num2, int num3) {
		int less = (num1 < num2) ? num1 : num2;
		return (less < num3) ? less : num3;
		}

	public static void main(String[] args) {
		String from = "Saturday";
		String to = "Sunday";
		Question032 app = new Question032();
		System.out.println(app.getDistance(from, to));

	}

}

package com.onufryk.exercise;

public class Question026 {
	public static Integer fibonacci(Integer n) {
		Integer[] result = { 0, 1 };
		Integer fibNMinusOne = 1;
		Integer fibNMinusTwo = 0;
		if (n < 2) {
			return result[n];
		}
		Integer fibN = null;
		for (int ii = 2; ii <= n; ii++) {
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}

	public static void main(String[] args) {
		Integer numberOfRectangles = 8;
		System.out.println(fibonacci(numberOfRectangles));
	}

}

package com.onufryk.exercise;

public class Question037 {

	public static int difference(int m, int n) {
		int count = 0;

		int diff = m ^ n;

		while (diff != 0) {
			++count;
			diff = (diff - 1) & diff;
		}

		return count;
	}

	public static void main(String[] args) {
		int n = 10;
		int m = 8;

		System.out.println(n + " " + Integer.toBinaryString(n));
		System.out.println(m + " " + Integer.toBinaryString(m));

		System.out.println(difference(m, n));

	}

}

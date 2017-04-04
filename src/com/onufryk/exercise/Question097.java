package com.onufryk.exercise;

public class Question097 {
	public static int longestIncreasingLength(int[] seq) {
		int len = seq.length;
		int[] lookup = new int[len];
		for(int i = 0; i < len; i++) {
			int longestSoFar = 0;
			for(int j = 0; j < i; j++) {
				if (seq[i] > seq[j] && lookup[j] > longestSoFar) {
					longestSoFar = lookup[j];
				}
			}
			lookup[i] = longestSoFar + 1;
		}
		int longestLength = 0;
		for (int i = 0; i < len; i++) {
			if (lookup[i] > longestLength) {
				longestLength = lookup[i];
			}
		}
		return longestLength;
	}

	public static void main(String[] args) {
		int numbers[] = {1, 2, 5, 3, 4, 7, 6};
		System.out.println(numbers.length - longestIncreasingLength(numbers));
	}

}

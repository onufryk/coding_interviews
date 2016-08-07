package com.onufryk.exercise;

import java.util.Arrays;

public class Question034 {
	int MinKeyPress(int keys, int[] frequencies) {
		Arrays.sort(frequencies);
		int letters = frequencies.length;
		int presses = 0;
		// The last element has the highest frequency in
		// an increasingly sorted array
		for(int i = letters - 1; i >= 0; --i) {
		int j = letters - 1 - i;
		presses += frequencies[i] * (j / keys + 1);
		}
		return presses;
	}
	public static void main(String[] args) {

	}

}

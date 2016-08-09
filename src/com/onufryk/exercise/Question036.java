package com.onufryk.exercise;

public class Question036 {

	public static boolean isPowerOfTwo(int number) {
		return number != 0 && ((number - 1) & number) == 0;
	}

	public static void main(String[] args) {
		for (int ii = 0; ii <= 16; ii++) {
			System.out.println(ii + "=" + Integer.toBinaryString(ii) + " - " + isPowerOfTwo(ii));
			System.out.println(Integer.toBinaryString(ii - 1));
		}

	}

}

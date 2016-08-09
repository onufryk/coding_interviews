package com.onufryk.exercise;

public class Question038 {
	public static int findFirstBitIs1(int num) {
		int indexBit = 0;
		while (((num & 1) == 0) && (indexBit < 32)) {
			num = num >> 1;
			++indexBit;
		}
		return indexBit;
	}

	// check whether the bit with index indexBit is 1
	public static boolean isBit1(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 4, 3, 6, 3, 2, 5, 5 };

		int number = numbers[0];
		for (int ii = 1; ii < numbers.length; ii++) {
			number = number ^ numbers[ii];
		}
		int indexBit = findFirstBitIs1(number);

		int num1 = 0;
		int num2 = 0;
		for (int ii = 0; ii < numbers.length; ii++) {
			if (isBit1(numbers[ii], indexBit)) {
				num1 = num1 ^ numbers[ii];
			} else {
				num2 = num2 ^ numbers[ii];
			}
		}
		System.out.println(num1 + ", " + num2);
	}

}

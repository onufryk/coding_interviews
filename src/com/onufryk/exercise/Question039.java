package com.onufryk.exercise;

public class Question039 {
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
		int[] original = {1,2,4,5,6,8,9};
		int[] extended = new int[original.length * 2 + 2];
		for (int ii = 0; ii < original.length; ii++) {
			extended[ii] = original[ii];
		}
		for (int ii = original.length; ii < extended.length; ii++) {
			extended[ii] = ii - original.length + 1;
		}
		
		int number = extended[0];
		for (int ii = 1; ii < extended.length; ii++) {
			number = number ^ extended[ii];
		}
		int indexBit = findFirstBitIs1(number);

		int num1 = 0;
		int num2 = 0;
		for (int ii = 0; ii < extended.length; ii++) {
			if (isBit1(extended[ii], indexBit)) {
				num1 = num1 ^ extended[ii];
			} else {
				num2 = num2 ^ extended[ii];
			}
		}
		System.out.println(num1 + ", " + num2);
	}

}

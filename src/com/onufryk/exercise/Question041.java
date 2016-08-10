package com.onufryk.exercise;

public class Question041 {

	private static void printNumber(byte[] number) {
		for (int ii = 0; ii < number.length; ii++) {
			System.out.print(number[ii]);
		}
		System.out.println();
	}

	public static void printAll(int n) {
		if (n <= 0) {
			return;
		}
		byte[] number = new byte[n];
		for (int ii = 0; ii < number.length; ii++) {
			number[ii] = 0;
		}

		printNumber(number);

		while (! increment(number)) {
			printNumber(number);
		}
	}

	private static boolean increment(byte[] number) {
		boolean isOverflow = false;
		byte carry = 0;
		for (int ii = number.length - 1; ii >= 0; ii--) {
			byte sum = (byte) (number[ii] + carry);
			if (ii == number.length - 1) {
				sum++;
			}
			if (sum >= 10) {
				if (ii == 0) {
					isOverflow = true;
				} else {
					sum = (byte) (sum - 10);
					carry = 1;
					number[ii] = sum;
				}
			} else {
				number[ii] = sum;
				break;
			}
		}
		return isOverflow;
	}

	public static void main(String[] args) {
		printAll(3);
	}

}

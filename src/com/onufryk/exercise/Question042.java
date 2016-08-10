package com.onufryk.exercise;

import java.lang.Math;

public class Question042 {
	private byte[] number1;
	private byte[] number2;

	private void printNumbers() {
		for (int ii = 0; ii < this.number1.length; ii++) {
			System.out.print(this.number1[ii]);
		}
		System.out.println();
		for (int ii = 0; ii < this.number2.length; ii++) {
			System.out.print(this.number2[ii]);
		}
		System.out.println();
	}

	private void printResult(byte[] number) {
		for (int ii = 0; ii < number.length; ii++) {
			System.out.print(number[ii]);
		}
		System.out.println();
	}

	public void setFirst(int number) {
		this.number1 = new byte[(int) (Math.floor(Math.log10(number)) + 1)];
		for (int ii = 0; ii < this.number1.length; ii++) {
			this.number1[ii] = 0;
		}
		int cursor = this.number1.length - 1;
		while (number != 0 && cursor >= 0) {
			this.number1[cursor] = (byte) (number % 10);
			number = number / 10;
			cursor--;
		}
	}

	public void setSecond(int number) {
		this.number2 = new byte[(int) (Math.floor(Math.log10(number)) + 1)];
		for (int ii = 0; ii < this.number2.length; ii++) {
			this.number2[ii] = 0;
		}
		int cursor = this.number2.length - 1;
		while (number != 0 && cursor >= 0) {
			this.number2[cursor] = (byte) (number % 10);
			number = number / 10;
			cursor--;
		}
	}

	public void add() {
		byte[] result = new byte[Math.max(this.number1.length, this.number2.length) + 1];
		for (int ii = 0; ii < result.length; ii++) {
			result[ii] = 0;
		}

		int indexFirst = this.number1.length - 1;
		int indexSecond = this.number2.length - 1;
		int indexResult = result.length - 1;

		byte carry = 0;
		while (indexFirst >= 0 && indexSecond >= 0) {
			byte digit1 = this.number1[indexFirst];
			byte digit2 = this.number2[indexSecond];
			
			byte sum = (byte)(digit1 + digit2 + carry);
			
			if (sum >= 10) {
				carry = 1;
				sum = (byte)(sum - 10);
				result[indexResult] = sum;
			} else {
				carry = 0;
				result[indexResult] = sum;
			}


			indexFirst--;
			indexSecond--;
			indexResult--;
		}
		if (indexFirst > indexSecond) {
			while (indexFirst >=0) {
				byte digit1 = this.number1[indexFirst];
				byte sum = (byte)(digit1 + carry);
				if (sum >= 10) {
					carry = 1;
					sum = (byte)(sum - 10);
					result[indexResult] = sum;
				} else {
					carry = 0;
					result[indexResult] = sum;
				}
				indexFirst--;
				indexResult--;
			}
		} else {
			while (indexSecond >=0) {
				byte digit2 = this.number2[indexSecond];
				byte sum = (byte)(digit2 + carry);
				if (sum >= 10) {
					carry = 1;
					sum = (byte)(sum - 10);
					result[indexResult] = sum;
				} else {
					carry = 0;
					result[indexResult] = sum;
				}
				indexSecond--;
				indexResult--;
			}
		}
		if (carry == 1) {
			result[indexResult] = carry;
			carry = 0;
		}

		printResult(result);
	}

	public static void main(String[] args) {
		Question042 app = new Question042();
		app.setFirst(1);
		app.setSecond(1);
		app.printNumbers();
		app.add();
	}

}

package com.onufryk.exercise;

public class Question023 {
	public static class Matrix {
		public Integer m00;
		public Integer m01;
		public Integer m10;
		public Integer m11;
	}

	public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
		Matrix result = new Matrix();

		result.m00 = matrix1.m00 * matrix2.m00 + matrix1.m01 * matrix2.m10;
		result.m01 = matrix1.m00 * matrix2.m01 + matrix1.m01 * matrix2.m11;
		result.m10 = matrix1.m10 * matrix2.m00 + matrix1.m11 * matrix2.m10;
		result.m11 = matrix1.m10 * matrix2.m01 + matrix1.m11 * matrix2.m11;

		return result;
	}

	public static Matrix power(Integer n) {
		if (n < 1) {
			return null;
		}
		Matrix result = new Matrix();
		Matrix unit = new Matrix();
		unit.m00 = 1;
		unit.m01 = 1;
		unit.m10 = 1;
		unit.m11 = 0;

		if (n == 1) {
			return unit;
		}

		if (n % 2 == 0) {
			result = power(n / 2);
			return multiply(result, result);
		}
		if (n % 2 == 1) {
			result = power((n - 1) / 2);
			result = multiply(result, result);
			return multiply(result, unit);
		}
		return result;
	}

	public static Integer fibonacci(Integer n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static Integer fibonacci2(Integer n) {
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

	public static Integer fibonacci3(Integer n) {
		Integer[] result = { 0, 1 };
		if (n < 2) {
			return result[n];
		}
		Matrix powerNMinus2 = power(n - 1);
		return powerNMinus2.m00;
	}

	public static void main(String[] args) {
		for (int ii = 0; ii < 10; ii++) {
			System.out.println(fibonacci3(ii + 1));
		}
	}

}

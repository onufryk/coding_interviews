package com.onufryk.exercise;

public class Question040 {
	public static double power(double base, int exponent) throws Exception {
		double result = 0;
		if (base == 0 && exponent < 0) {
			throw new Exception();
		}

		int absExponent = Math.abs(exponent);
		
		return powerSafe(base, absExponent);
	}

	private static double powerSafe(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;

		double result = powerSafe(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1)
			result *= base;
		return result;
	}

	public static void main(String[] args) {
		try {
			System.out.println(power(3, 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

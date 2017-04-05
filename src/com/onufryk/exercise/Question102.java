package com.onufryk.exercise;

public class Question102 {
	
	public static Integer add(Integer a, Integer b) {
		int sum, carry;
		do {
			sum = a ^ b;
			carry = (a & b) << 1;
			a = sum;
			b = carry;
		} while (b != 0);
		
		return a;
	}
	
	public static Integer subtract(Integer a, Integer b) {
		b = add(~b, 1);
		return add(a, b);
	}
	
	public static Integer multiply(Integer a, Integer b) {
		boolean minus = false;
		if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
			minus = true;
		}
		if (a < 0) {
			a = add(~a, 1);
		}
		if (b < 0) {
			b = add(~b, 1);
		}
		
		int result = 0;
		while (a > 0) {
			if ((a & 0x1) != 0) {
				result = add(result, b);
			}
			b = b << 1;
			a = a >> 1;
		}
		if (minus) {
			result = add(~result, 1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(multiply(-5, 3));
	}

}

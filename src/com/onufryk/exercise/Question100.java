package com.onufryk.exercise;

public class Question100 {
	
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

	public static void main(String[] args) {
		System.out.println(add(5,-7));

	}

}

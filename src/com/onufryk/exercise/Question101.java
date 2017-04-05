package com.onufryk.exercise;

public class Question101 {
	
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

	public static void main(String[] args) {
		System.out.println(subtract(5, 2));

	}

}

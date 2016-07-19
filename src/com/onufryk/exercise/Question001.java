package com.onufryk.exercise;

public class Question001 {
	public static void main(String[] args) {
		Integer original = 54245;
		Integer copy = original;
		Integer reversed = 0;
		
		while (copy != 0) {
			reversed = reversed * 10 + copy % 10;
			copy = copy / 10;
		}
		
		System.out.println(original);
		System.out.println(reversed);
		
		if (original.equals(reversed)) {
			System.out.println("This is a palindrome");
		} else {
			System.out.println("This is not a palindrome");
		}
	}

}

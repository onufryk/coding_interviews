package com.onufryk.exercise;

public class Question009 {

	public static void main(String[] args) {
		/*
		 * This exercise is related to null-terminated string and memory allocation, 
		 * so it doesn't really make sense in Java.
		 */
		String input = "We are happy.";
		
		int blanks = 0;
		int length = 0;
		
		for (int ii = 0; ii < input.length(); ii++) {
			length++;
			if (input.charAt(ii) == ' ') {
				blanks++;
			}
		}
		int newLength = length + blanks * 2;
		
		char newString[] = new char[newLength];
		
		int originalIndex = length - 1;
		int newIndex = newLength - 1;
		
		while (originalIndex >= 0) {
			if (input.charAt(originalIndex) == ' ') {
				newString[newIndex--] = '0';
				newString[newIndex--] = '2';
				newString[newIndex--] = '%';
			} else {
				newString[newIndex--] = input.charAt(originalIndex);
			}
			--originalIndex;
		}
		
		
		System.out.println(newString);
	}

}

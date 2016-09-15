package com.onufryk.exercise;

public class Question065 {

	public static void permutations(String str) {
		if (str == null) {
			return;
		}
		System.out.println("All permutations of string " + str);
		Character[] chars = new Character[str.length()];
		for (int ii = 0; ii < str.length(); ii++) {
			chars[ii] = str.charAt(ii);
		}
		permutations(chars, 0);
	}
	
	private static void permutations(Character[] str, Integer index) {
		if (index == str.length) {
			for (int ii = 0; ii < str.length; ii++) {
				System.out.print(str[ii]);
			}
			System.out.println();
		} else {
			for (int ii = index; ii < str.length; ii++) {
				Character temp = str[ii];
				str[ii] = str[index];
				str[index] = temp;
				permutations(str, index + 1);
				Character temp1 = str[ii];
				str[ii] = str[index];
				str[index] = temp1;
			}
		}
	}

	public static void main(String[] args) {

		String input = "abc";

		permutations(input);

	}

}

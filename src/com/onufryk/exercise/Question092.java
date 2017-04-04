package com.onufryk.exercise;
public class Question092 {

	public static String reverse(String str) {
		Integer begin = 0;
		Integer end = str.length() - 1;
		return reverse(str, begin, end);
	}
	
	public static String reverse(String str, Integer begin, Integer end) {
		Character chars[] = new Character[str.length()];
		for (int ii = 0; ii < chars.length; ii++) {
			chars[ii] = str.charAt(ii);
		}
		
		while (begin < end) {
			Character temp = chars[begin];
			chars[begin] = chars[end];
			chars[end] = temp;
			begin++;
			end--;
		}
		
		String result = new String();
		for (int ii = 0; ii < chars.length; ii++) {
			result = result + chars[ii];
		}
		return result;
	}
	
	public static String reverse(String str, Integer num) {
		String result = reverse(str, 0, num - 1);
		result = reverse(result, num, result.length() - 1);
		result = reverse(result);
		return result;
	}

	public static void main(String[] args) {
		String input = "abcdefg";
		Integer num = 2;
		
		System.out.println(reverse(input));
		System.out.println(reverse(input, num));
	}

}

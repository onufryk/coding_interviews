package com.onufryk.exercise;

public class Question091 {
	
	public static String reverse(String str, String buff) {
		Integer pos = str.indexOf(" ");
		if (pos < 0) {
			return str;
		}
		String word = str.substring(0, pos);
		String rest = str.substring(pos + 1);
		return reverse(rest, buff) + " "+ word;
	}
	
	public static String reverse(String str) {
		String buff = new String();
		return reverse(str, buff);
	}
	
	public static void main (String args[]) {
		String input = "I am a student.";
		System.out.println(reverse(input));
		
		
	}

}

package com.onufryk.exercise;

public class Question080 {

	public static void main(String[] args) {
		String word1 = "silent";
		String word2 = "listen";
		
		if (word1.length() != word2.length()) {
			System.out.println("Not anagrams.");
		}
		
		for (int ii = 0; ii < word1.length(); ii++) {
			Character c = word1.charAt(ii);
			if (!word2.contains(c.toString())) {
				System.out.println("Not anagrams.");
				break;
			}
		}
		for (int ii = 0; ii < word2.length(); ii++) {
			Character c = word2.charAt(ii);
			if (!word1.contains(c.toString())) {
				System.out.println("Not anagrams.");
				break;
			}
		}
			
	}

}

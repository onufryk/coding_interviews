package com.onufryk.exercise;

public class Question011 {
	private String string;
	private String pattern;
	
	private boolean matchChar(int stringIndex, int patternIndex) {
		if (stringIndex == string.length() && patternIndex == pattern.length()) {
			return true;
		}
		if (stringIndex != string.length() && patternIndex == pattern.length()) {
			return false;
		}
		
		if ((patternIndex + 1 < pattern.length()) && pattern.charAt(patternIndex + 1) == '*') {
			if (string.charAt(stringIndex) == pattern.charAt(patternIndex) || (pattern.charAt(patternIndex) == '.' && stringIndex != string.length())) {
				return matchChar(stringIndex + 1, patternIndex + 2) || matchChar(stringIndex + 1, patternIndex) || matchChar(stringIndex, patternIndex + 2);
			} else {
				return matchChar(stringIndex, patternIndex + 2);
			}
		}
		
		if ((stringIndex < string.length() && patternIndex < pattern.length() && string.charAt(stringIndex) == pattern.charAt(patternIndex)) || (pattern.charAt(patternIndex) == '.' && stringIndex != string.length())) {
			return matchChar(stringIndex + 1, patternIndex + 1);
		}
		
		return false;
	}
	
	public boolean match(String string, String pattern) {
		if (string == null || pattern == null) {
			return false;
		}
		this.string = string;
		this.pattern = pattern;
		return matchChar(0, 0);
	}

	public static void main(String[] args) {
		Question011 app = new Question011();
		String original = "aaa";
		
		System.out.println(app.match(original, "a.a") ? "Match" : "No match");
		System.out.println(app.match(original, "ab*ac*a") ? "Match" : "No match");
		System.out.println(app.match(original, "aa.a") ? "Match" : "No match");
		System.out.println(app.match(original, "ab*a") ? "Match" : "No match");

	}

}

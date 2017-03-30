package com.onufryk.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

public class Question077 {

	private static Character getFirstSingleChar(Map<Character, Integer> hash) {
		for (Character c : hash.keySet()) {
			if (hash.get(c) >= 0) {
				return c;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		String input = "google";
		Map<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
		
		for (int ii = 0; ii < input.length(); ii++) {
			Character ch = input.charAt(ii);
			if (!hash.containsKey(ch)) {
				hash.put(ch, ii);
			} else {
				hash.put(ch, -1);
			}
			System.out.println(getFirstSingleChar(hash));
		}
	}

}

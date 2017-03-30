package com.onufryk.exercise;

import java.util.HashMap;
import java.util.Map;

public class Question078 {

	public static void main(String[] args) {
		String input = "We are students.";
		String delete = "aeiou";
		
		Map<Character, Boolean> hash = new HashMap<Character, Boolean>();
		for (int ii = 0; ii < delete.length(); ii++) {
			hash.put(delete.charAt(ii), true);
		}
		
		StringBuffer result = new StringBuffer();
		for (int ii = 0; ii < input.length(); ii++) {
			if (!hash.containsKey(input.charAt(ii)) || !hash.get(input.charAt(ii))) {
				result.append(input.charAt(ii));
			}
		}
		System.out.println(result);
	}

}

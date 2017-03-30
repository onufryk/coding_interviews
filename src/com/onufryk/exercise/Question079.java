package com.onufryk.exercise;

import java.util.HashMap;
import java.util.Map;

public class Question079 {

	public static void main(String[] args) {
		String input = "google";
		StringBuffer output = new StringBuffer();
		
		Map<Character, Boolean> hash = new HashMap<Character, Boolean>();
		
		for (int ii = 0; ii < input.length(); ii++) {
			Character ch = input.charAt(ii);
			if (!hash.containsKey(ch)) {
				output.append(ch);
				hash.put(ch, true);
			}
		}
		System.out.println(output);
	}

}

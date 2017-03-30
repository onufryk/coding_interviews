package com.onufryk.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

public class Question076 {

	public static void main(String[] args) {
		String input = "google";
		Map<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
		
		for (int ii = 0; ii < input.length(); ii++) {
			if (!hash.containsKey(input.charAt(ii))) {
				hash.put(input.charAt(ii), 1);
			} else {
				hash.put(input.charAt(ii), hash.get(input.charAt(ii)) + 1);
			}
		}
		
		for (Character c : hash.keySet()) {
			if (hash.get(c) == 1) {
				System.out.println(c);
				break;
			}
		}
		
		for (int ii = 0; ii < input.length(); ii++) {
			if (hash.get(input.charAt(ii)) == 1) {
				System.out.println(input.charAt(ii));
				break;
			}
		}

	}

}

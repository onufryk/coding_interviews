package com.onufryk.exercise;

public class Question096 {
	
	public static void main(String[] args) {
		Integer n = 5;
		Integer m = 3;
		
		int last = 0;
		
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		
		System.out.println(last);
		
	}

}

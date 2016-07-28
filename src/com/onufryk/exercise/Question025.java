package com.onufryk.exercise;

public class Question025 {
	
	public static Integer numberOfApproaches(Integer numberOfSteps) {
		return 1 << (numberOfSteps - 1);
	}

	public static void main(String[] args) {
		System.out.println(numberOfApproaches(3));
	}

}

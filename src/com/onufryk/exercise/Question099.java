package com.onufryk.exercise;

public class Question099 {
	private static Integer N;
	private static Integer Sum;
	
	public Question099() {
		System.out.println(N);
		++Question099.N;
		Question099.Sum += Question099.N;
	}
	
	public static void reset() {
		Question099.N = 0;
		Question099.Sum = 0;
	}
	
	public static int getSum() {
		return Question099.Sum;
	}

	public static void main(String[] args) {
		Question099.reset();
		Question099 apps[] = new Question099[10];
		System.out.println(Question099.getSum());
	}

}

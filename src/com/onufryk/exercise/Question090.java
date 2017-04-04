package com.onufryk.exercise;

public class Question090 {

	public static void bruteforce(Integer num) {
		for (int ii = 1; ii < num; ii++) {
			for (int jj = ii + 1; jj <= num; jj++) {
				Integer sum = (jj - ii + 1) * (jj + ii) / 2;
				if (sum == num) {
					System.out.println("(" + ii + " .. " + jj + ").");
				}
			}

		}
	}
	
	public static void smarter(Integer num) {
		Integer small = 1;
		Integer big = 2;
		Integer middle = (1 + num) / 2;
		Integer sum = small + big;

		while (small < middle) {
			if (sum == num) {
				System.out.println("(" + small + " .. " + big + ").");
			}
			
			while (sum > num && small < middle) {
				sum -= small;
				++small;
				
				if (sum == num) {
					System.out.println("(" + small + " .. " + big + ").");
				}
			}
			
			big++;
			sum += big;
			
		}
	}

	public static void main(String[] args) {
		Integer s = 15;
		bruteforce(s);
		System.out.println();
		smarter(s);
	}

}

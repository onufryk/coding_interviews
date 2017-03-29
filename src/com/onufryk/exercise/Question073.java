package com.onufryk.exercise;

public class Question073 {
	
	private static Integer numberOfOnes(Integer n) {
		Integer count = 0;
		while (n > 0) {
			Integer mod = n % 10;
			if (mod == 1) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}
	
	public static Integer totalNumberOfOnes(Integer n) {
		Integer count = 0;
		for (int ii = 1; ii <= n; ii++) {
			count += numberOfOnes(ii);
		}
		return count;
	}

	public static void main(String[] args) {
		Integer n = 12;
		
		Integer numberOfOnes = totalNumberOfOnes(n);
		System.out.println(numberOfOnes);
	}

}

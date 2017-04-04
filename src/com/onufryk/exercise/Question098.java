package com.onufryk.exercise;

public class Question098 {

	public static void main(String[] args) {
		int[] prices = {9, 11, 5, 7, 16, 1, 4, 2};
		
		int min = prices[0];
		int maxDiff = prices[1] - min;
		
		for (int i = 2; i < prices.length; i++) {
			if (prices[i - 1] < min) {
				min = prices[i - 1];
			}
			
			int currentDiff = prices[i] - min;
			if (currentDiff > maxDiff) {
				maxDiff = currentDiff;
			}
		}
		System.out.println(maxDiff);
	}

}

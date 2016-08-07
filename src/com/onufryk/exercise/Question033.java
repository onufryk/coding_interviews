package com.onufryk.exercise;

public class Question033 {
	private int[] coins = {1, 3, 9, 10};
	
	public int getMinimalNumberOfCoins(int total) {
		int[] counts = new int[total + 1];
		counts[0] = 0;
		
		for (int i = 1; i <= total; ++i) {
			int count = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; ++j) {
				if (i - coins[j] >= 0 && count > counts[i - coins[j]]) {
					count = counts[i - coins[j]];
				}
			}
			if (count < Integer.MAX_VALUE)
				counts[i] = count + 1;
				else
				counts[i] = Integer.MAX_VALUE;
		}
		return counts[total];
	}

	public static void main(String[] args) {
		Question033 app = new Question033();
		
		System.out.println(app.getMinimalNumberOfCoins(18));
	}

}

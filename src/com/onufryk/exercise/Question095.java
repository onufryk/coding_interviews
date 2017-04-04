package com.onufryk.exercise;

public class Question095 {

	public static void main(String[] args) {
		Integer num = 2;
		Integer max = 6;
		
		Integer probabilities[][] = new Integer[2][max * num + 1];
		
		for (int i = 0; i < max * num + 1; i++) {
			probabilities[0][i] = 0;
			probabilities[1][i] = 0;
		}
		
		int flag = 0;
		for (int i = 1; i <= max; i++) {
			probabilities[flag][i] = 1;
		}

		for (int k = 2; k <= num; k++) {
			for (int i = 0; i < k; i++) {
				probabilities[1-flag][i] = 0;
			}
			for (int i = k; i <= max * k; i++) {
				probabilities[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= max; j++) {
					probabilities[1 - flag][i] += probabilities[flag][i - j];
				}
			}
			flag = 1 - flag;
		}
		Double total = Math.pow(max, num);
		
		for (int i = num; i <= max * num; i++) {
			Double ratio = probabilities[flag][i] / total;
			System.out.printf("%d: %e\n", i, ratio);
		}
	}
	

}

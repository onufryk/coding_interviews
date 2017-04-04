package com.onufryk.exercise;

import java.util.Arrays;

public class Question088 {
	public static Boolean hasPairWithSum(Integer arr[], Integer sum, Integer skip) {
		Boolean found = false;
		
		int ahead = arr.length - 1;
		int behind = 0;
		
		while (ahead > behind) {
			if (ahead == skip) {
				ahead--;
			}
			if (behind == skip) {
				behind++;
			}
			int currentSum = arr[ahead] + arr[behind];
			
			if (currentSum == sum) {
				return true;
			}
			
			if (currentSum > sum) {
				ahead --;
			} else {
				behind ++;
			}
		}
		
		return found;
	}


	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 43, 4, 7, -12, -44, 11, 15 };
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++){
			int sum = arr[i] * -1;
			if (hasPairWithSum(arr, sum, i)) {
				System.out.println("YES");
				break;
			}
		}
	}

}

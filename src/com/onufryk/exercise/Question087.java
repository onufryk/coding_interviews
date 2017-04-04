package com.onufryk.exercise;

public class Question087 {
	
	public static Boolean hasPairWithSum(Integer arr[], Integer sum) {
		Boolean found = false;
		
		int ahead = arr.length - 1;
		int behind = 0;
		
		while (ahead > behind) {
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
		Integer arr[] = { 1, 2, 4, 7, 11, 15 };
		Integer num = 26;

		for (int ii = 0; ii < arr.length - 1; ii++) {
			for (int jj = ii + 1; jj < arr.length; jj++) {
				System.out.println(arr[ii] + ", " + arr[jj]);
				if (arr[ii] + arr[jj] == num) {
					System.out.println("true");
				}
			}
		}
		System.out.println(hasPairWithSum(arr, num));
	}

}

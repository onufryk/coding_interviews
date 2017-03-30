package com.onufryk.exercise;

public class Question081 {

	public static void main(String[] args) {
		Integer arr[] = {7, 5, 6, 4};
		
		for (int ii = 0; ii < arr.length - 1; ii++) {
			for (int jj = ii + 1; jj < arr.length; jj++) {
				if (arr[ii] > arr[jj]) {
					System.out.println("(" + arr[ii] + ", " + arr[jj] + ")");
				}
			}
		}
	}

}

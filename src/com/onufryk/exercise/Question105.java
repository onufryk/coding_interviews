package com.onufryk.exercise;

public class Question105 {
	
	public static void multiply(double arr1[], double arr2[]) {
		if (arr1.length == arr2.length && arr1.length != 0) {
			arr2[0] = 1;
			for (int i = 1; i < arr1.length; i++) {
				arr2[i] = arr2[i - 1] * arr1[i = 1];
			}
			int temp = 1;
			for (int i = arr1.length - 2; i >= 0; i--) {
				temp *= arr1[i + 1];
				arr2[i] *= temp;
			}
		}
	}

	public static void main(String[] args) {

	}

}

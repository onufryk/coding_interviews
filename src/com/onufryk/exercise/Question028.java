package com.onufryk.exercise;

public class Question028 {

	public static Integer findPeak(Integer[] numbers) {
		if (numbers.length < 3) {
			return null;
		}
		Integer left = 0;
		Integer right = numbers.length - 1;
		
		while (left + 1 < right) {
			Integer middle = (left + right) / 2;
			if (middle == 0 || middle == numbers.length - 1 ) {
				return null;
			}
			if (numbers[middle] > numbers[middle - 1] && numbers[middle] > numbers[middle + 1]) {
				return numbers[middle];
			} else if (numbers[middle] > numbers[middle - 1] && numbers[middle] < numbers[middle + 1]) {
				left = middle;
			} else {
				right = middle;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Integer numbers[] = { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6 };
		System.out.print(findPeak(numbers));
	}

}

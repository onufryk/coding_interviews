package com.onufryk.exercise;

public class Question027 {

	public static void main(String[] args) {
		Integer[] numbers = { 14, 15, 16, 6, 9 };

		Integer p1 = 0;
		Integer p2 = numbers.length - 1;

		Integer middle = numbers.length / 2;
		while (numbers[p1] >= numbers[p2]) {
			if (p2 - p1 == 1) {
				break;
			}
			middle = (p1 + p2) / 2;

			if (numbers[middle] == numbers[p1] && numbers[p1] == numbers[p2]) {
				Integer result = numbers[p1];
				for (int ii = p1 + 1; ii <= p2; ii++) {
					if (result > numbers[ii]) {
						result = numbers[ii];
					}
				}
				System.out.println(result);
				break;
			}

			if (numbers[middle] >= numbers[p1]) {
				p1 = middle;
			} else if (numbers[middle] <= numbers[p2]) {
				p2 = middle;
			}

		}
		System.out.println(numbers[middle]);
	}

}

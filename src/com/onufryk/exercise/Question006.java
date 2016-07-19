package com.onufryk.exercise;

public class Question006 {

	public static void main(String[] args) {
		Integer numbers[] = { 2, 3, 1, 0, 2, 5, 3 };
		
		for (int ii = 0; ii < numbers.length; ++ii) {
			while (numbers[ii] != ii) {
				if (numbers[ii] == numbers[numbers[ii]]) {
					System.out.println(numbers[ii]);
					break;
				}
				Integer temp = numbers[ii];
				numbers[ii] = numbers[temp];
				numbers[temp] = temp;
			}

		}
	}

}

package com.onufryk.exercise;

import java.util.Random;

public class Question029 {
	private Integer[] numbers;

	public Question029(Integer[] numbers) {
		this.numbers = numbers;
	}
	
	private void swap(Integer index1, Integer index2) {
		Integer temp = this.numbers[index1];
		this.numbers[index1] = this.numbers[index2];
		this.numbers[index2] = temp;
	}

	private Integer partition(Integer start, Integer end) {
		Random random = new Random();
		int pivot = random.nextInt(end - start + 1) + start;

		this.swap(pivot, end);
		
		int small = start - 1;
		for (int i = start; i <= end; ++i) {
			if (this.numbers[i] < this.numbers[end]) {
				++small;
				if (i != small) {
					this.swap(small, i);
				}
			}
		}
		++small;
		if (small != end) {
			this.swap(end, small);
		}
		return small;
	}

	private Boolean checkMajorityExistence(Integer number) {
		int times = 0;
		for (int i = 0; i < this.numbers.length; ++i) {
			if (this.numbers[i] == number)
				times++;
		}
		return (times * 2 > this.numbers.length);
	}

	public Integer getMajority() {
		Integer middle = this.numbers.length / 2;
		Integer start = 0;
		Integer end = this.numbers.length - 1;

		Integer index = partition(start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = partition(start, end);
			} else {
				start = index + 1;
				index = partition(start, end);
			}
		}

		Integer result = this.numbers[middle];
		if (!checkMajorityExistence(result)) {
			return null;
		}

		return result;
	}

	public static void main(String[] args) {
		Integer[] numbers = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		Question029 app = new Question029(numbers);
		System.out.println(app.getMajority());
	}

}

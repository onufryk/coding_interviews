package com.onufryk.exercise;

public class Question045 {
	public int[] numbers = null;

	public interface Criterion {
		public boolean check(int number);
	}

	public Question045(int[] numbers) {
		this.numbers = numbers;
	}

	public void reorder(Criterion criterion) {
		int begin = 0;
		int end = this.numbers.length - 1;
		while (begin < end) {
			while (begin < end && !criterion.check(this.numbers[begin])) {
				begin++;
			}
			while (begin < end && criterion.check(this.numbers[end])) {
				end--;
			}
			if (begin < end) {
				int temp = this.numbers[begin];
				this.numbers[begin] = this.numbers[end];
				this.numbers[end] = temp;
			}

		}
	}

	public void print() {
		if (this.numbers == null) {
			System.out.println();
			return;
		}
		for (int ii = 0; ii < this.numbers.length; ii++) {
			System.out.print(this.numbers[ii]);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		Question045 app = new Question045(numbers);
		app.print();
		Criterion isEven = new Criterion() {
			public boolean check(int num) {
				if ((num & 0x1) == 0)
					return true;
				return false;
			}
		};
		app.reorder(isEven);
		app.print();
	}

}

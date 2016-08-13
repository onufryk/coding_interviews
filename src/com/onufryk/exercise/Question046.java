package com.onufryk.exercise;

public class Question046 {
	public int[] numbers = null;
	
	
	public Question046(int[] numbers) {
		this.numbers = numbers;
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
	
	public void remove(int number) {
		int begin = 0;
		int end = this.numbers.length - 1;
		while (this.numbers[begin] != number && begin < end) {
			begin++;
		}
		while (begin < end) {
			while (this.numbers[begin] != number && begin < end) {
				begin++;
			}
			while (this.numbers[end] == number && begin < end) {
				end--;
			}
			if (begin < end) {
				numbers[begin] = numbers[end];
				numbers[end] = number;
			}
			
		}
	}

	public static void main(String[] args) {
		int[] numbers = {4, 3, 2, 1, 2, 3, 6};
		Question046 app = new Question046(numbers);
		app.print();
		app.remove(2);
		app.print();
	}

}

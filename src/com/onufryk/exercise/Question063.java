package com.onufryk.exercise;

public class Question063 {
	private int[] sequence = {5, 7, 6, 9, 11, 10, 8};
	
	public void run() {
		if (isBST()) { 
			System.out.println("BINARY SEARCH TREE");
		} else {
			System.out.println("NOT A BINARY SEARCH TREE");
		}
	}

	public boolean isBST() {
		return isBST(0, this.sequence.length - 1);
	}

	private boolean isBST(int startIndex, int endIndex) {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Function called with bounds %d - %d\n", startIndex, endIndex);

		int rootValue = sequence[endIndex];
		System.out.printf("Subtree root value is %d\n", rootValue);
		System.out.printf("Values are %d, %d\n", this.sequence[startIndex], this.sequence[endIndex - 1]);


		int ii = 0;
		for (ii = startIndex; ii < endIndex - 1; ++ii) {
			if (this.sequence[ii] > rootValue) {
				break;
			}
		}
		
		int jj = 0;
		for (jj = ii; jj < endIndex - 1; jj++) {
			if (this.sequence[jj] < rootValue) {
				return false;
			}
		}
		
		boolean left = true;
		if (ii > 0) {
			left = isBST(0, ii);
		}
		
		boolean right = true;
		
		if (ii < endIndex - 1) {
			right = isBST(ii, endIndex - ii - 1);
		}
		
		return left && right;
	}

	public static void main(String[] args) {
		Question063 app = new Question063();
		app.run();
	}

}

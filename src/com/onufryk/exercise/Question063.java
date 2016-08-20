package com.onufryk.exercise;

public class Question063 {

	public static boolean isBST(int[] postOrder) {
		return isBST(postOrder, 0, postOrder.length - 1);

	}

	private static boolean isBST(int[] sequence, int start, int end) {
		int rootValue = sequence[end];
		System.out.println("Bounds:" + start + ", " + end);

		int ii = start;
		while (ii < end && sequence[ii] < rootValue) {
			ii++;
		}

		int jj = end - 1;
		while (jj > start && sequence[ii] > rootValue) {
			jj--;
		}

		System.out.println("Indexes:" + ii + ", " + jj);

		if (jj - ii > 1) {
			return false;
		}
		return isBST(sequence, start, ii) && isBST(sequence, jj, end - 1);
	}

	public static void main(String[] args) {
		int[] postOrder = { 5, 7, 6, 9, 11, 10, 8 };
		System.out.println(isBST(postOrder));
	}

}

package com.onufryk.exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Question072 {
	public static List<Integer> subArrayWithMaxSum(Integer arr[]) {
		List<Integer> result = new ArrayList<Integer>();
		Integer maxSum = arr[0];
		Integer maxI = 0;
		Integer maxJ = 0;
		
		for (int ii = 0; ii < arr.length; ii++) {
			for (int jj = ii; jj < arr.length; jj++) {
				Integer sum = 0;
				System.out.println();
				for (int kk = ii; kk <= jj; kk++) {
					System.out.print(arr[kk] + " ");
					sum += arr[kk];
				}
				System.out.print(" = " + sum);
				if (sum > maxSum) {
					maxSum = sum;
					maxI = ii;
					maxJ = jj;
				}
			}
		}
		
		for (int kk = maxI; kk <= maxJ; kk++) {
			result.add(arr[kk]);
		}
		
		return result;
	}
	
	public static Integer getMaxSumOfSubArray(Integer arr[]) {
		Integer curSum = 0;
		Integer maxSum = Integer.MIN_VALUE;
		
		for (int ii = 0; ii < arr.length; ii++) {
			if (curSum <= 0) {
				curSum = arr[ii];
			} else {
				curSum += arr[ii];
			}
			if (curSum > maxSum) {
				maxSum = curSum;
			}
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		Integer input[] = {1, -2, 3, 10, -4, 7, 2, -5};
		
		List<Integer> sub = subArrayWithMaxSum(input);
		
		System.out.println();
		System.out.println("Sub-array with maximum sum:");
		Integer sum = 0;
		for (Integer item : sub) {
			System.out.print(item);
			System.out.print(' ');
			sum += item;
		}
		System.out.println();
		System.out.println("Maximum sum is: "+ sum);
		
		System.out.println(getMaxSumOfSubArray(input));
	}

}

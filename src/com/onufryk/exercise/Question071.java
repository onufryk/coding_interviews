package com.onufryk.exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Question071 {

	public static void main(String[] args) {
		Integer arr1[] = {1, 4, 7, 10, 13}; 
		Integer arr2[] = {1, 3, 5, 7, 9, 17, 18, 19, 20};
		
		List<Integer> result = intersection(arr1, arr2);
		
		System.out.println("Result 1");
		Iterator<Integer> iter = result.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println();
		
		System.out.println("Result 2");
		List<Integer> result2 = intersection2(arr1, arr2);

		Iterator<Integer> iter2 = result2.iterator();
		while (iter2.hasNext()) {
			System.out.print(iter2.next());
		}
		System.out.println();

	}
	
	public static List<Integer> intersection(Integer arr1[], Integer arr2[]) {
		List<Integer> result = new ArrayList<Integer>();
		

		int ind1 = 0;
		int ind2 = 0;
		
		while (ind1 < arr1.length && ind2 < arr2.length) {
			if (arr1[ind1] == arr2[ind2]) {
				result.add(arr1[ind1]);
				ind1++;
				ind2++;
			} else if (arr1[ind1] > arr2[ind2]) {
				ind2++;
			} else {
				ind1++;
			}
		}
				
		return result;
	}

	public static List<Integer> intersection2(Integer arr1[], Integer arr2[]) {
		List<Integer> result = new ArrayList<Integer>();
		for (int ii = 0; ii < arr1.length; ii++) {
			Integer in2 = binarySearch(arr2, arr1[ii]);
			if (in2 != null) {
				result.add(in2);
			}
		}
		return result;
	}
	
	public static Integer binarySearch(Integer arr[], Integer val) {
		Integer result = null;
		
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = (right + left) / 2;
			if (arr[mid] == val) {
				return val;
			} else if (arr[mid] > val) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}
}

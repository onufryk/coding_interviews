package com.onufryk.exercise;

public class Question083 {
	
	public static Integer first(Integer arr[], Integer k, Integer start, Integer end) {
		if (start > end) {
			return null;
		}
		Integer mid = (start + end) / 2;
		if (arr[mid] == k) {
			if ((mid == 0) || arr[mid - 1] != k) {
				return mid;
			}
			end = mid - 1;
		} else if (arr[mid] > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return first(arr, k, start, end);
	}
	
	public static Integer last(Integer arr[], Integer k, Integer start, Integer end) {
		if (start > end) {
			return null;
		}
		Integer mid = (start + end) / 2;
		if (arr[mid] == k) {
			if ((mid == arr.length - 1) || arr[mid + 1] != k) {
				return mid;
			}
			start = mid + 1;
		} else if (arr[mid] > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return last(arr, k, start, end);
	}

	public static void main(String[] args) {
		Integer input[] = { 1, 2, 3, 3, 3, 3, 4, 5 };
		Integer num = 3;
		
		Integer first = first(input, num, 0, input.length);
		Integer last = last(input, num, 0, input.length);
		System.out.println(last - first + 1);
	}

}

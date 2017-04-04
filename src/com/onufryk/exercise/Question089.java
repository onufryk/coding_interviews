package com.onufryk.exercise;

import java.util.Arrays;
import java.util.BitSet;

public class Question089 {
	
	public static Boolean increment(BitSet bits, Integer length) {
		Integer index = length - 1;
		while (index >= 0 && bits.get(index)) {
			bits.clear(index);
			index--;
		}
		if (index < 0) {
			return false;
		}
		bits.set(index);
		return true;
	}

	public static Boolean hasSubsetWithZeroSum(Integer arr[]) {
		BitSet bits = new BitSet(arr.length);
		while (increment(bits, arr.length)) {
			int sum = 0;
			boolean oneBitAtLeast = false;
			for (int i = 0; i < arr.length; i++) {
				if (bits.get(i)) {
					if (!oneBitAtLeast) {
						oneBitAtLeast = true;
					}
					sum += arr[i];
				}
			}
			if (oneBitAtLeast && sum == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 43, 4, 7, -12, -44, 11, 15 };
		Arrays.sort(arr);
		System.out.println(hasSubsetWithZeroSum(arr));
	}

}

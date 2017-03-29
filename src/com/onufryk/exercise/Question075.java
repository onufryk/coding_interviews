package com.onufryk.exercise;

import java.util.ArrayList;
import java.util.List;

public class Question075 {
	public static Boolean isUgly(Integer n) {
		while (n % 2 == 0) {
			n = n / 2;
		}
		while (n % 3 == 0) {
			n = n / 3;
		}
		while (n % 5 == 0) {
			n = n / 5;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		List<Integer> uglyNumbers = new ArrayList<Integer>();
		uglyNumbers.add(1);
		int nextUglyIndex = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		
		while (nextUglyIndex < 100) {
			Integer min = Math.min(uglyNumbers.get(index2) * 2, uglyNumbers.get(index3) * 3);
			min = Math.min(min, uglyNumbers.get(index5) * 5);
			uglyNumbers.add(nextUglyIndex, min);
			
			while (uglyNumbers.get(index2) * 2 <= uglyNumbers.get(nextUglyIndex)) {
				index2++;
			}
			while (uglyNumbers.get(index3) * 3 <= uglyNumbers.get(nextUglyIndex)) {
				index3++;
			}
			while (uglyNumbers.get(index5) * 5 <= uglyNumbers.get(nextUglyIndex)) {
				index5++;
			}
			
			nextUglyIndex++;
		}
		System.out.println(uglyNumbers.get(nextUglyIndex - 1));
	}

}

package com.onufryk.exercise;

import com.onufryk.exercise.struct.Stack;

public class Question056 {
	
	public static boolean canBe(int[] pushed, int[] popped) {
		boolean result = false;
		if (pushed == null || popped == null) {
			return false;
		}
		
		int popLength = popped.length;
		int pushLength = pushed.length;
		
		int ipush = 0;
		int ipop = 0;
		
		Stack stack = new Stack();
		
		while (ipop < popLength) {
			while (stack.isEmpty() || stack.top.getValue() != popped[ipop]) {
				if (ipush == pushLength) {
					break;
				}
				stack.push(pushed[ipush]);
				ipush++;
			}
			
			if (stack.top.getValue() != popped[ipop]) {
				break;
			}
			stack.pop();
			ipop++;
		}
		
		if (stack.isEmpty() || ipop == popLength) {
			result = true;
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		
		int[] pushed = {1, 2, 3, 4, 5, 6};
		int[] popped1 = {4, 5, 3, 2, 1};
		int[] popped2 = {4, 3, 5, 1, 2};
		
		System.out.println(canBe(pushed, popped1));
		System.out.println(canBe(pushed, popped2));

	}

}

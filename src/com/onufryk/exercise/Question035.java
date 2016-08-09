package com.onufryk.exercise;

public class Question035 {
	
	public static Integer numberOfOnes(int decimal) {
		int count = 0;
		int flag = 1;
		while (flag >= 0) {
			if ((decimal & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	public static void main(String[] args) {
		for (int ii = 0; ii <= 16; ii++) {
			System.out.println(ii+"="+Integer.toBinaryString(ii)+" - " +numberOfOnes(ii));
		}
	}

}

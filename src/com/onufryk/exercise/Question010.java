package com.onufryk.exercise;

import java.util.Random;
import java.util.Arrays;

public class Question010 {

	public static void main(String[] args) {
		int array1[] = new int[10];
		int array2[] = new int[10];
		Random randomizer = new Random();
		
		for (int ii = 0; ii < array1.length; ii++) {
			array1[ii] = randomizer.nextInt(100);
			array2[ii] = randomizer.nextInt(100);
		}
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		for (int ii = 0; ii < array1.length; ii++) {
			System.out.print(array1[ii]);
			System.out.print(' ');
		}
		System.out.println();
		for (int ii = 0; ii < array2.length; ii++) {
			System.out.print(array2[ii]);
			System.out.print(' ');
		}
		System.out.println();
		
		int arrayMerged [] = new int[20];
		
		int index1 = array1.length - 1;
		int index2 = array1.length - 1;
		int indexMerged = array1.length + array1.length - 1;
		
		while (index1 >= 0 && index2 >= 0) {
			if (array1[index1] < array2[index2]) {
				arrayMerged[indexMerged--] = array2[index2--];
			} else {
				arrayMerged[indexMerged--] = array1[index1--];
			}
		}
		
		while (index1 >= 0) {
			arrayMerged[indexMerged--] = array1[index1--];
		}
		while (index2 >= 0) {
			arrayMerged[indexMerged--] = array2[index2--];
		}

		for (int ii = 0; ii < arrayMerged.length; ii++) {
			System.out.print(arrayMerged[ii]);
			System.out.print(' ');
		}
	}

}

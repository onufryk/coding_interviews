package com.onufryk.exercise;

public class Question003 {

	public static class TheOnly {
		private static TheOnly theOnly = null;

		private TheOnly() {

		}

		public static TheOnly getTheOnlyOne() {
			if (theOnly == null) {
				synchronized (TheOnly.class) {
					if (theOnly == null) {
						theOnly = new TheOnly();
					}
				}
			}
			return theOnly;
		}
	}

	public static void main(String[] args) {
		TheOnly.getTheOnlyOne();
	}

}

package com.onufryk.exercise;

public class Question012 {
	String string;
	
	private int scanDigits(int index) {
		while (index != string.length() && string.charAt(index) >= '0' && string.charAt(index) <= '9') {
			index++;
		}
		return index;
	}
	
	private boolean isExponential(int index) {
		if (index == string.length()) {
			return false;
		}
		if (string.charAt(index) != 'E' && string.charAt(index) != 'e') {
			return false;
		}
		index++;
		if (index == string.length()) {
			return false;
		}
		if (string.charAt(index) == '+' || string.charAt(index) == '-') {
			index++;
		}
		if (index == string.length()) {
			return false;
		}
		
		index = scanDigits(index);
		return index == string.length();
	}
	
	private boolean isNumeric(int index) {
		if (index == string.length()) {
			return false;
		}
		if (string.charAt(index) == '+' || string.charAt(index) == '-') {
			index++;
		}
		if (index == string.length()) {
			return false;
		}
		boolean numeric = true;
		
		index = scanDigits(index);
		if (index != string.length()) {
			if (string.charAt(index) == '.') {
				++index;
				index = scanDigits(index);
				if (index == string.length()) {
					return true;
				}
				if (string.charAt(index) == 'E' || string.charAt(index) == 'e') {
					numeric = isExponential(index);
				}
				if (index != string.length()) {
					return false;
				}
			} else if (string.charAt(index) == 'E' || string.charAt(index) == 'e') {
				numeric = isExponential(index);
			} else {
				numeric = false;
			}
		}
		return numeric;
	}
	
	public boolean isNumeric(String string) {
		if (string == null) {
			return false;
		}
		
		this.string = string;
		return isNumeric(0);
	}

	public static void main(String[] args) {
		Question012 app = new Question012();
		
		System.out.println(app.isNumeric("+100."));
		System.out.println(app.isNumeric("5e2"));
		System.out.println(app.isNumeric("-.123"));
		System.out.println(app.isNumeric("3.1416"));
		System.out.println(app.isNumeric("-1E-16"));
		
		System.out.println(app.isNumeric("12e"));
		System.out.println(app.isNumeric("1a3.14"));
		System.out.println(app.isNumeric("1.2.3"));
		System.out.println(app.isNumeric("+-5"));
		System.out.println(app.isNumeric("12e+5.4"));

	}

}

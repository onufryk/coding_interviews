package com.onufryk.exercise;

import java.util.BitSet;

public class Question068 {
	private String str = "abc";
	private BitSet bits = null;
	
	public void permutation() {
		this.bits = new BitSet(this.str.length());
		while (this.increment(this.str.length())) {
			this.print();
		}
	}
	
	public Boolean increment(Integer length) {
		Integer index = length - 1;
		while (index >= 0 && this.bits.get(index)) {
			this.bits.clear(index);
			index--;
		}
		if (index < 0) {
			return false;
		}
		bits.set(index);
		return true;
	}
	
	public void print() {
		if (this.str == null || this.bits == null) {
			return;
		}
		for (int ii = 0; ii < this.str.length(); ii++) {
			if (this.bits.get(ii)) {
				System.out.print(str.charAt(ii));
			}
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		Question068 app = new Question068();
		
		app.permutation();
	}

}

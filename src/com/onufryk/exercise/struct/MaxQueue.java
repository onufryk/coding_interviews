package com.onufryk.exercise.struct;

public class MaxQueue extends Queue {
	public void enqueue(Integer value) {
		super.enqueue(value);
	}
	
	public Integer dequeue() {
		return super.dequeue();
	}
	
	public Integer max() {
		if (this.first == null) {
			return null;
		}
		
	}
	
}

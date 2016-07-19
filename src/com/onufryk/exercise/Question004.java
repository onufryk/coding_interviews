package com.onufryk.exercise;

public class Question004 {
	public static class SimpleThread extends Thread {
		private Integer value = null;

		public SimpleThread(Integer value) {
			this.value = value;
			this.start();
		}

		public void run() {
			while (true) {
				synchronized (this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				System.out.println(this.value);
			}
		}
	}

	public static void main(String[] args) {
		SimpleThread threads[] = new SimpleThread[3];
		for (int i = 0; i < 3; i++) {
			threads[i] = new SimpleThread(i + 1);
		}
		int index = 0;
		while (true) {
			synchronized (threads[index]) {
				threads[index].notify();
			}
			try {
				Thread.sleep(37);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			index = (++index) % 3;
		}
	}

}

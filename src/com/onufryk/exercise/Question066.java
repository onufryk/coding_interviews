package com.onufryk.exercise;

public class Question066 {
	private Integer[] columnIndex = {0, 1, 2, 3, 4, 5, 6, 7};
	private Integer count = 0;

	public void run() {
		permutation(0);
		System.out.println(this.count);
	}
	
	private void permutation(Integer index) {
		if (index == this.columnIndex.length) {
			if (this.check()) {
				this.count++;
			}
		} else {
			for (int ii = index; ii < this.columnIndex.length; ii++) {
				Integer temp1 = this.columnIndex[ii];
				this.columnIndex[ii] = this.columnIndex[index];
				this.columnIndex[index] = temp1;
				
				this.permutation(index + 1);
				
				Integer temp2 = this.columnIndex[ii];
				this.columnIndex[ii] = this.columnIndex[index];
				this.columnIndex[index] = temp2;
			}
		}
	}
	
	private Boolean check() {
		Boolean result = true;
		for (int ii = 0; ii < this.columnIndex.length; ii++) {
			for (int jj = ii + 1; jj < this.columnIndex.length; jj++) {
				if ((ii - jj == this.columnIndex[ii] - this.columnIndex[jj]) || (jj - ii == this.columnIndex[ii] - this.columnIndex[jj])) {
					return false;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		Question066 app = new Question066();
		app.run();
	}

}

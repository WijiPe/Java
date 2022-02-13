package com.wiji.calculator2;


public class Calculator implements java.io.Serializable {
	private String operation;
	private double operrandOne;
	private double operrandTwo;
	private boolean state1 = false;
	public Calculator() {

	}

	public void performOperation(Object r) {
		if(r instanceof String) {
			if(this.state1 == false) {
				this.operation = (String) r;
				this.state1 = true;
			}else {
				if(this.operation == "+") {
					this.operrandOne = this.operrandOne + this.operrandTwo;
				}else if(this.operation == "-") {
					this.operrandOne = this.operrandOne - this.operrandTwo;
				}else if(this.operation == "/") {
					this.operrandOne = this.operrandOne / this.operrandTwo;
				}else if(this.operation == "*") {
					this.operrandOne = this.operrandOne * this.operrandTwo;
				}
				this.operation = (String) r;
			}
				
		}else if (r instanceof Double) {
			if(this.state1 == false) {
				this.operrandOne = (double) r;
			}else if(this.state1 == true){
				this.operrandTwo = (double) r;
			}
		}

	}
	
	public double getResult() {
		return this.operrandOne;
	}
}

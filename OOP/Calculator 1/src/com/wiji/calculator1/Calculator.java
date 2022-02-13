package com.wiji.calculator1;

public class Calculator implements java.io.Serializable {
	private String operation;
	private double operrandOne;
	private double operrandTwo;
	private double result;
	
	public Calculator() {
		this.operation = "";
		this.operrandOne = 0;
		this.operrandTwo = 0;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getOperrandOne() {
		return operrandOne;
	}
	public void setOperrandOne(double operrandOne) {
		this.operrandOne = operrandOne;
	}
	public double getOperrandTwo() {
		return operrandTwo;
	}
	public void setOperrandTwo(double operrandTwo) {
		this.operrandTwo = operrandTwo;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	public void performOperation() {
		if(this.operation == "+") {
			this.setResult(this.operrandOne + this.operrandTwo);
		}else if (this.operation == "-") {
			this.setResult(this.operrandOne - this.operrandTwo);
		}
	}
}

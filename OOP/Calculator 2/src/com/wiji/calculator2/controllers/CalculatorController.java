package com.wiji.calculator2.controllers;

import com.wiji.calculator2.Calculator;

public class CalculatorController {
	public static void main(String[] args){
		
		Calculator test = new Calculator();
			test.performOperation(10.8);
			test.performOperation("+");
			test.performOperation(5.2);
			test.performOperation("-");
			test.performOperation(10.0);
			test.performOperation("*");
			test.performOperation(2.0);
			test.performOperation("=");
			test.getResult();
			
			System.out.println(test.getResult());
	}
}

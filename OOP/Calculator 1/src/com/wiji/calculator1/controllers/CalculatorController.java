package com.wiji.calculator1.controllers;

import com.wiji.calculator1.Calculator;

public class CalculatorController {
	public static void main(String[] args){
		
		Calculator test = new Calculator();
			test.setOperrandOne(10.5);
			test.setOperation("+");
			test.setOperrandTwo(5.2);
			test.performOperation();
			test.getResult();
			
			System.out.println(test.getResult());
	}
}

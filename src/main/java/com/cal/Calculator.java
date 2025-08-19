package com.cal;

public class Calculator {

	public double add(double a, double b) {
		double result = a + b;
		return result;
	}

	public double sub(double a, double b) {
		double result = a - b;
		return result;
	}

	public double mul(double a, double b) {
		double result = a * b;
		return result;
	}

	public double div(double a, double b) {
		double result = 0;
		try {
			result = a / b;

		}

		catch (ArithmeticException e) {
			System.err.println("Cannot divide number with 0");
		}

		return result;
	}

}
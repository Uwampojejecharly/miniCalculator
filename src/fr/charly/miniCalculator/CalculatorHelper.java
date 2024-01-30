package fr.charly.miniCalculator;

/**
 * This class provides helper methods for performing basic arithmetic
 * operations.
 */
public class CalculatorHelper {

	public static double add(double operand1, double operand2) {
		return operand1 + operand2;
	}

	public static double subtract(double operand1, double operand2) {
		return operand1 - operand2;
	}

	public static double multiply(double operand1, double operand2) {
		return operand1 * operand2;
	}

	public static double divide(double operand1, double operand2) {
		if (operand2 != 0) {
			return operand1 / operand2;
		} else {
			throw new ArithmeticException("Division by zero error");
		}
	}

	public static double calculate(double operand1, String operator, double operand2) {
		switch (operator) {
		case "+":
			return add(operand1, operand2);
		case "-":
			return subtract(operand1, operand2);
		case "*":
			return multiply(operand1, operand2);
		case "/":
			return divide(operand1, operand2);
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}

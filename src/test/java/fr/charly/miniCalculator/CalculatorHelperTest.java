package fr.charly.miniCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.charly.miniCalculator.CalculatorHelper;

public class CalculatorHelperTest {

	@Test
	public void testAdd() {
		assertEquals(4.0, CalculatorHelper.add(2.0, 2.0));
	}

	@Test
	public void testSubtract() {
		assertEquals(1.0, CalculatorHelper.subtract(3.0, 2.0));
	}

	@Test
	public void testMultiply() {
		assertEquals(6.0, CalculatorHelper.multiply(2.0, 3.0));
	}

	@Test
	public void testDivide() {
		assertEquals(2.0, CalculatorHelper.divide(6.0, 3.0));
	}

	@Test
	public void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> CalculatorHelper.divide(6.0, 0.0));
	}

	@Test
	public void testCalculate() {
		assertEquals(5.0, CalculatorHelper.calculate(2.0, "+", 3.0));
		assertEquals(-1.0, CalculatorHelper.calculate(2.0, "-", 3.0));
		assertEquals(6.0, CalculatorHelper.calculate(2.0, "*", 3.0));
		assertEquals(2.0, CalculatorHelper.calculate(6.0, "/", 3.0));
	}

	@Test
	public void testInvalidOperator() {
		assertThrows(IllegalArgumentException.class, () -> CalculatorHelper.calculate(2.0, "%", 3.0));
	}

	@Test
	public void testNegativeNumbers() {
		assertEquals(-1.0, CalculatorHelper.add(-2.0, 1.0));
		assertEquals(-6.0, CalculatorHelper.multiply(-2.0, 3.0));
	}

	@Test
	public void testDecimalNumbers() {
		assertEquals(0.5, CalculatorHelper.divide(1.0, 2.0));
	}

	@Test
	public void testLargeNumbers() {
		assertEquals(20000000000.0, CalculatorHelper.multiply(10000000000.0, 2.0));
	}
}
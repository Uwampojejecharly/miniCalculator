package fr.charly.miniCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * This class represents a listener for the calculator buttons.
 */
public class ButtonClickListener implements ActionListener {
	private JTextField display;
	private String numberString = "";

	public ButtonClickListener(JTextField display) {
		this.display = display;
	}

	public void actionPerformed(ActionEvent e) {
		String command = ((JButton) e.getSource()).getText();
		if (command.matches("[0-9]")) {
			numberString += command;
			display.setText(numberString);
		} else if (command.matches("[/*+-]")) {
			if (!numberString.isEmpty() && !isOperator(numberString.charAt(numberString.length() - 1))) {
				numberString += " " + command + " ";
				display.setText(numberString);
			}
		} else if (command.equals("=")) {
			if (!numberString.isEmpty() && !isOperator(numberString.charAt(numberString.length() - 1))) {
				String[] tokens = numberString.split(" ");
				double result = Double.parseDouble(tokens[0]);
				String operator = "";
				for (int i = 1; i < tokens.length; i++) {
					if (i % 2 == 1) {
						operator = tokens[i];
					} else {
						double operand = Double.parseDouble(tokens[i]);
						// Using the CalculatorHelper class to perform the calculation
						result = CalculatorHelper.calculate(result, operator, operand);
					}
				}
				numberString += " = " + Double.toString(result);
				display.setText(numberString);
			}
		}
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	public static void main(String[] args) {

	}

}

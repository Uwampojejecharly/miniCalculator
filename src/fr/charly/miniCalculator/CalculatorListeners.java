package fr.charly.miniCalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class CalculatorListeners extends JFrame {

	private JPanel panel;
	private JTextField display;
	private String numberString = "";
	private double number1 = 0;
	private double number2 = 0;
	private String operator = "";

	public CalculatorListeners() {
		super("Calculator");

		setLayout(new BorderLayout());

		display = new JTextField();
		add(display, BorderLayout.NORTH);
		panel = new JPanel(new GridLayout(4, 4));

		String[] labels = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "", "0", "=", "/" };
		for (String label : labels) {
			JButton button = new JButton(label);
			button.addActionListener(new ButtonClickListener());
			panel.add(button);
		}

		this.add(panel, BorderLayout.CENTER);

		display = new JTextField();
		display.setPreferredSize(new Dimension(400, 100));
		display.setHorizontalAlignment(JTextField.RIGHT);
		this.add(display, BorderLayout.NORTH);
		this.setTitle("Calculator");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);F
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = ((JButton) e.getSource()).getText();
			if (command.matches("[0-1-2-3-4-5-6-7-8-9-*-=-+]")) {
				numberString += command;
				display.setText(numberString);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		CalculatorListeners frame = new CalculatorListeners();
		frame.setVisible(true);
	}
}
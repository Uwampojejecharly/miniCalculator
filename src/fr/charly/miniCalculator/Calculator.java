package fr.charly.miniCalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Calculator extends JFrame {

	private JPanel panel;
	private JTextField textField;

	public Calculator() {
		super("Calculator");

		setLayout(new BorderLayout());

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(400, 100));
		add(textField, BorderLayout.NORTH);

		panel = new JPanel(new GridLayout(4, 4));

		String[] labels = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "", "0", "=", "/" };
		for (String label : labels) {
			JButton button = new JButton(label);
			panel.add(button);
		}

		this.add(panel);
		this.setTitle("Calculator");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}
}
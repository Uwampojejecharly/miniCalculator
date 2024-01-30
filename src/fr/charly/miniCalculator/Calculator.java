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

/**
 * This class represents a simple calculator GUI application.
 */
public class Calculator extends JFrame {

	private static final long serialVersionUID = 6646703771457169932L;
	private JPanel panel;
	private JTextField display;

	public Calculator() {
		super("Calculator");

		setLayout(new BorderLayout());

		display = new JTextField();
		add(display, BorderLayout.NORTH);

		panel = new JPanel(new GridLayout(4, 4));

		String[] labels = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "", "0", "/", "=" };
		ButtonClickListener buttonClickListener = new ButtonClickListener(display);
		for (String label : labels) {
			JButton button = new JButton(label);
			button.addActionListener(buttonClickListener);
			panel.add(button);
		}

		add(panel, BorderLayout.CENTER);
		display.setPreferredSize(new Dimension(400, 100));
		display.setHorizontalAlignment(JTextField.RIGHT);
		setTitle("Calculator");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}
}

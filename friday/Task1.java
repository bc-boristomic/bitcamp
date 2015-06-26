package ba.bitcamp.exercises.friday;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task1 extends JFrame {

	private static final long serialVersionUID = 1092357942475015030L;


	private JButton[] buttons = new JButton[9];
	private int sum = 0;
	private int counter = 0;

	public Task1() {
		setLayout(new GridLayout(3, 3));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(String.valueOf(1 + i));
			add(buttons[i]);
			buttons[i].addActionListener(new Action());
		}

		pack();
		setTitle("Calculator");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // mora biti na kraju
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (counter < 2) {
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						sum += i + 1;
					}
				}
			}
			counter++;

			if (counter == 2) {
				JOptionPane.showMessageDialog(null, "Sum of numbers = "
						+ String.valueOf(sum));
				sum = 0;
				counter = 0;
			}
		}

	}

	public static void main(String[] args) {
		new Task1();
	}
}

package ba.bitcamp.exercises.day3.task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7616962588519657925L;
	private JLabel text = new JLabel("Choose one");
	private JButton top = new JButton("Do not exit");
	private JButton button = new JButton("Exit");

	public Main () {
		
		text.setHorizontalAlignment(NORMAL);
		button.addActionListener(new Action());
		top.addActionListener(new Action());

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(button, BorderLayout.SOUTH);
		panel.add(top, BorderLayout.NORTH);

		JFrame window = new JFrame();
		window.setContentPane(panel);
		window.setLocation(300, 200);
		window.setSize(250, 200);
		window.setVisible(true);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button) {
				System.exit(0);
			}
			if (e.getSource() == top) {
				text.setText("It did not exit!.");
			}

		}

	}

	public static void main(String[] args) {
		new Main();
		
	}

}

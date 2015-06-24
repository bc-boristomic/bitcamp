package ba.bitcamp.exercises.day3.task1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 7693845619498266809L;

	private static class Action implements ActionListener {

		JButton button;
		
		public Action(JButton button) {
			this.button = button;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button){
				JOptionPane.showMessageDialog(null, "Hello");
				System.exit(0);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		JLabel text = new JLabel("Hello world!");
		text.setHorizontalAlignment(NORMAL);
		
		JButton button = new JButton("hello");
		button.addActionListener(new Action(button));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(button, BorderLayout.SOUTH);
		
		JFrame window = new JFrame();
		window.setContentPane(panel);
		window.setLocation(300, 200);
		window.setSize(250, 200);
		window.setVisible(true);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}

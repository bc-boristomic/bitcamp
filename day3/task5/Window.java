package ba.bitcamp.exercises.day3.task5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = -5583486838232605446L;
	private JLabel text = new JLabel("Example Sentence");
	private JButton left = new JButton("<");
	private JButton right = new JButton(">");
	private JButton bottom = new JButton("Remove");
	private int counter = 0;
	
	
	public Window(){
		
		Font f = new Font("Courier New", Font.BOLD, 22);
		text.setHorizontalAlignment(NORMAL);
		text.setFont(f);
		left.addActionListener(new Action());
		right.addActionListener(new Action());
		bottom.addActionListener(new Action());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(left, BorderLayout.WEST);
		panel.add(right, BorderLayout.EAST);
		panel.add(bottom, BorderLayout.SOUTH);

		JFrame window = new JFrame();
		window.setContentPane(panel);
		window.setLocation(550, 300);
		window.setSize(500, 250);
		window.setVisible(true);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = text.getText();
			
			if (e.getSource() == right){
				s = "_" + s.substring(counter, s.length());
				text.setText(s);
				counter++;
			} 
			
		}
		
	}
	
	public static void main(String[] args) {
		new Window();
	}

}

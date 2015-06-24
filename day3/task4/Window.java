package ba.bitcamp.exercises.day3.task4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window extends JFrame {

	private static final long serialVersionUID = -1603396732037037998L;
	private JLabel text = new JLabel("Don't press!");
	private JButton top = new JButton("Button");
	private int counter = 0;
	public Window(){
		
		text.setHorizontalAlignment(NORMAL);

		top.addActionListener(new Action());

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(top, BorderLayout.SOUTH);

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
			String[] s = {"I told you not to press it!", "Don't press the button!", "No more clicks!", "Don't press!"};
			
			if (e.getSource() == top) {
					text.setText(s[counter]);
					counter++;
				
					if (counter == s.length) {
						counter = 0;
					}
			}
			
		}	
			
		
		
	}
	
	public static void main(String[] args) {
		new Window();
	}

}

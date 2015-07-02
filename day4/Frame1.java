package ba.bitcamp.exercises.day4;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame1 extends JFrame {
	private static final long serialVersionUID = -2017366439041107941L;
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JLabel label1 = new JLabel("Label 1");
	private JLabel label2 = new JLabel("Label 2");
	private JTextArea text = new JTextArea("Text area");
	private JButton[] buttons = new JButton[9];
		
	public Frame1() {
		
		setLayout(new GridLayout(1, 0));
		add(panel1);
		add(panel2);
		panel1.setBorder(BorderFactory.createTitledBorder("Panel 1"));
		panel2.setBorder(BorderFactory.createTitledBorder("Panel 2"));
		
		panel1.setLayout(new BorderLayout());
		panel1.add(label2, BorderLayout.NORTH);
		panel1.add(text, BorderLayout.CENTER);
		panel1.add(label1, BorderLayout.SOUTH);
		
		panel2.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("Button " + (1+i));
			panel2.add(buttons[i]);
		}
		
		
		setTitle("Frame 1");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}

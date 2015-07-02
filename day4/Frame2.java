package ba.bitcamp.exercises.day4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame2 extends JFrame {
	private static final long serialVersionUID = 1808242103036826276L;

	private JPanel center = new JPanel();
	private JPanel south = new JPanel();

	private JLabel[] labels = new JLabel[4];
	private JButton[] buttons = new JButton[4];
	
	private JLabel label1 = new JLabel("Label 1");
	private JButton button1 = new JButton("Button 1");
	
	
	public Frame2() {

		setLayout(new BorderLayout());
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		center.setBorder(BorderFactory.createTitledBorder("Center panel"));
		south.setBorder(BorderFactory.createTitledBorder("South panel"));
		
		center.setLayout(new GridLayout(4, 4));
		
		for (int i = 0; i < buttons.length; i++) {
			labels[i] = new JLabel("Label " + (1+i));
			buttons[i] = new JButton("Button " + (1+i));
			center.add(labels[i]);
			center.add(buttons[i]);
		}
		
		
		south.setLayout(new FlowLayout());
		south.add(label1);
		south.add(button1);
		
		setTitle("Frame 2");
		setSize(600, 400);
		setLocation(620, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}

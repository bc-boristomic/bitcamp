package ba.bitcamp.exercises.day4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame3 extends JFrame {
	private static final long serialVersionUID = 3787145556963052058L;

	private JPanel center = new JPanel();
	private JPanel east = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JTextArea text = new JTextArea("Text area");
	private JLabel[] labels = new JLabel[3];
	private JButton button1 = new JButton("Button 1");
	private JButton button2 = new JButton("Button 2");

	public Frame3() {

		setLayout(new BorderLayout());
		add(east, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);
		
		center.setLayout(new FlowLayout(FlowLayout.LEFT));
		center.add(text);
		
		east.setBorder(BorderFactory.createTitledBorder("East panel"));
		center.setBorder(BorderFactory.createTitledBorder("Center panel"));
		panel1.setBorder(BorderFactory.createTitledBorder("Panel 1"));
		panel2.setBorder(BorderFactory.createTitledBorder("Panel 2"));
		
		east.setLayout(new GridLayout(0, 1));
		east.add(panel1);
		east.add(panel2);
		panel2.setLayout(new FlowLayout());
		panel2.add(button1);
		panel2.add(button2);
		
		panel1.setLayout(new GridLayout(0, 1));
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel("This seems to be label " + (1+i));
			panel1.add(labels[i]);
		}
		
		setTitle("Frame 1");
		setSize(600, 400);
		setLocation(300, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}

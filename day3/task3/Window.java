package ba.bitcamp.exercises.day3.task3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7078097421513108116L;
	private JLabel text = new JLabel("Press one to disable other");
	private JButton top = new JButton("Button 1");
	private JButton button = new JButton("Button 2");
	private int counter = 0;
	
	public Window(){
		
		Font f = new Font("Cambria", Font.BOLD, 18);
		text.setFont(f);
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
		if(e.getSource() == button){
			button.setEnabled(false);
			top.setEnabled(true);
			counter++;
		} else if(e.getSource() == top) {
			button.setEnabled(true);
			top.setEnabled(false);
			counter++;
		}
		if (counter > 5) {
			System.exit(0);
		}
		
	}
	
}

public static void main(String[] args) {
	new Window();
}
}

package ba.bitcamp.exercises.friday;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame{
	private static final long serialVersionUID = -1109173352618444521L;

//	private JButton button1 = new JButton("OK");
//	private JButton button2 = new JButton("Cancel");
//	private JButton button3 = new JButton("Close");
//	private JButton button4 = new JButton("Exit");

	private JButton[] buttons = new JButton[6];
	private String[] textONButtons = {"OK", "Close", "Exit", "Cancel", "Quit", "Java"};
	
	
	public Main(){
		setLayout(new GridLayout(2,3));
	
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(textONButtons[i]);
			add(buttons[i]);
			buttons[i].addActionListener(new Action());
		}
		
//		add(button1);
//		add(button2);
//		add(button3);
//		add(button4);
		
		//setSize(400, 300);
		pack(); // sam odredi velicinu 
		setTitle("Grid");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					System.out.println(textONButtons[i]);
				}
			}			
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}

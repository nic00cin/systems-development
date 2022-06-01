package Maexchen;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


	public class UI implements ActionListener {
		public JFrame window;
		public JPanel bgpanel[] = new JPanel[3];
		public JLabel bgLabel[] = new JLabel[3];
		public JTextField n_players;
		public int input_players;
		
		public UI(){
			// TODO Auto-generated method stub
			createMainField();
			createBackground();
			window.setVisible(true);
		}
		
		public void createMainField() {
			window = new JFrame();
			window.setSize(800,530);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().setBackground(Color.white);
			window.setTitle("Mäxchen");
		}
		
		public void createBackground() {
			bgpanel[1] = new JPanel();
			bgpanel[1].setBounds(50,50,700,350);
	
			
			bgLabel[1] = new JLabel();
			bgLabel[1].setBounds(50,50,700,350);
			
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("Wuerfel.jpeg"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(800,450,Image.SCALE_DEFAULT)); 
			bgLabel[1].setIcon(bgIcon);
			
			n_players = new JTextField("Players", 4);
			
			JButton button = new JButton("Click here to start the game!");
			button.addActionListener(this);
			
			bgpanel[1].add(bgLabel[1]);
			bgpanel[1].add(n_players);
			bgpanel[1].add(button);
			window.add(bgpanel[1]);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				input_players = Integer.parseInt(n_players.getText());
				System.out.println(input_players);
			}
	        	catch (NumberFormatException ex){
	        		System.out.println("No input or no integer!");
	        	}
		}

	}

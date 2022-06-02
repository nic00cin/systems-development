package Maexchen;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


	public class UI {
		public JFrame window;
		public JPanel bgpanel[] = new JPanel[3];
		public JLabel bgLabel[] = new JLabel[3];
		
		public UI(){
			// TODO Auto-generated method stub
			createMainField();
			createBackground();
			window.setVisible(true);
		}
		
		public void createMainField() {
			window = new JFrame();
			window.setSize(800,600);
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
			
			bgpanel[1].add(bgLabel[1]);
			window.add(bgpanel[1]);
			
		}

	}



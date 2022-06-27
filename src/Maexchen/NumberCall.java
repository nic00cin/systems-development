package Maexchen;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class NumberCall implements ActionListener, WindowListener {
	public JFrame window;
	public JPanel bgpanel[] = new JPanel[5];
	public JLabel bgLabel[] = new JLabel[5];
	public JTextField number_called;
	public int input_number;
	
	public NumberCall() {
		createFirstMainField();
		createBackground();
		window.setVisible(true);
	}
	
	/**
	 * shows the rolled number
	 */
	public void createFirstMainField() {
		window = new JFrame();
		window.setSize(400,85);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.addWindowListener(this);
		window.setTitle(PlayerInfoUI.Players[PlayerInfoUI.player_order].getName()+" - Your Rolled Number?");
	}
	
	/**
	 * lets you input the number you want to tell
	 */
	public void createBackground() {
		bgpanel[1] = new JPanel();
		bgpanel[1].setBounds(50,50,300,250);

		
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(50,50,300,250);
		
		number_called = new JTextField("Number", 4);
		JButton button = new JButton("Submit!");
		button.addActionListener(this);
		
		bgpanel[1].add(bgLabel[1]);
		bgpanel[1].add(number_called);
		bgpanel[1].add(button);
		window.add(bgpanel[1]);
		
	}
	
	/**
	 * checks if the input makes sense
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			try {
				input_number = Integer.parseInt(number_called.getText());	
				if(CheckerMaexchen.NumberisIn(input_number)== true) {
					if(PlayerInfoUI.first_round == true) {	
						PlayerInfoUI.Players[PlayerInfoUI.player_order].setCalled(input_number);
						PlayerInfoUI.highest_number = input_number; 
						window.dispose();
						PlayerInfoUI.first_round = false;
						Trust trust = new Trust();
					}else {
						if(CheckerMaexchen.checkhigher(input_number) == true) {
							PlayerInfoUI.Players[PlayerInfoUI.player_order].setCalled(input_number);
							PlayerInfoUI.highest_number = input_number; 
							window.dispose();
							Trust trust = new Trust();
						}else {
							PlayerInfoUI.Players[PlayerInfoUI.player_order].decreasepoints();
							JFrame jFrame = new JFrame();
				            JOptionPane.showMessageDialog(jFrame, "You lost a point, because you entered a lower number as before. Try again.");
						}
					}
				}else {
					JFrame jFrame = new JFrame();
		            JOptionPane.showMessageDialog(jFrame, "This number doesn't exist in this game!");
				}
			}catch(NumberFormatException ex) {
				JFrame jFrame = new JFrame();
	            JOptionPane.showMessageDialog(jFrame, "Wrong or empty input!");
			}
			
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method asks the user if he wants to exits the game and if yes shows the Points table
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int antwort = JOptionPane.showConfirmDialog(window, "Do you really want to exit the game?", "Exit", JOptionPane.YES_NO_OPTION);
		if( antwort == JOptionPane.YES_OPTION) {
			window.dispose();
			PointsTable points_tb = new PointsTable();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

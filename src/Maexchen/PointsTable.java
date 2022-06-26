package Maexchen;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PointsTable {
	public JFrame window;
	public JPanel bgpanel[] = new JPanel[5];
	public JLabel bgLabel[] = new JLabel[UI.input_players];
	public static int highestpoints = 0;
	public static int highestp_index = 0;
	
	public PointsTable(){
		// TODO Auto-generated method stub
		createFirstMainField();
		createBackground();
		window.setVisible(true);
	}
	
	public void createFirstMainField() {
		window = new JFrame();
		window.setSize(200,150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setTitle("The Winner is " +PlayerInfoUI.Players[getWinner()].getName());
	}
	
	public void createBackground() {
		bgpanel[1] = new JPanel();
		bgpanel[1].setBounds(50,50,200,150);

		for(int i = 0; i < UI.input_players; i++) {
			bgLabel[i] = new JLabel(PlayerInfoUI.Players[i].getName() + " has " + PlayerInfoUI.Players[i].getPoints() + " Points " );
			bgLabel[i].setBounds(50,50,200,150);
			bgpanel[1].add(bgLabel[i]);
		}
		
		window.add(bgpanel[1]);
		
		
	}
	
	public static int getWinner() {
		
		for(int i = 0; i < UI.input_players ; i++) {
				if(PlayerInfoUI.Players[i].getPoints() == highestpoints) {
					if(PlayerInfoUI.Players[i].getAge() < PlayerInfoUI.Players[highestp_index].getAge()) {
						highestp_index = i;
					}
				}else if(PlayerInfoUI.Players[i].getPoints() > highestpoints) {
					highestpoints =  PlayerInfoUI.Players[i].getPoints();
					highestp_index = i;
				}
			}
		return highestp_index;
		}
	}
	


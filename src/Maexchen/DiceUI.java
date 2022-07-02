package Maexchen;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class DiceUI implements ActionListener, WindowListener {
	public JFrame window;
	public JPanel bgpanel[] = new JPanel[5];
	public JLabel bgLabel[] = new JLabel[5];
	public boolean showed = false;
	public int youngest;
	public int youngest_player;
	public int number1;
	public int number2;
	public int number;
	
	

	
	public DiceUI(){
		setYoungestPlayer();
		createFirstMainField();
		createBackground();
	}
	

	public void createFirstMainField() {
		window = new JFrame();
		window.setSize(500,500);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.addWindowListener(this);
		window.setTitle(PlayerInfoUI.Players[PlayerInfoUI.player_order].getName());
		window.setVisible(true);
	}
	
	/**
	 * show the numbers of your dice throw
	 */
	public void createBackground() {
		bgpanel[1] = new JPanel();
		bgpanel[1].setBounds(50,50,200,200);

		
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(50,50,200,200);
		
		JButton button = new JButton("Show numbers!");
		button.addActionListener(this);
		
		bgpanel[1].add(bgLabel[1]);
		bgpanel[1].add(button);
		window.add(bgpanel[1]);
		
	}
	
	/**
	 * determines who the youngest player is and lets him start
	 */
	public void setYoungestPlayer() {
		if(PlayerInfoUI.done == false) {
			youngest = PlayerInfoUI.Players[0].getAge();
			for(int i = 0;i < UI.input_players; i++) {
				if(youngest > PlayerInfoUI.Players[i].getAge()) {
					youngest = PlayerInfoUI.Players[i].getAge();
					youngest_player = i;
				}
			}
			PlayerInfoUI.done = true;
			PlayerInfoUI.player_order = youngest_player;
		}
	}
	
	/**
	 * shows the picture of the first dice with the thrown number
	 * @param n_dice - dice number
	 */
	public void addpicture1(int n_dice) {
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(50,50,200,200);
		if(n_dice == 1) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("eins.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 2){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("zwei.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 3){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("drei.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 4){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("vier.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 5){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("fuenf.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 6){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("sechs.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}
		bgpanel[1].add(bgLabel[1]);
		window.add(bgpanel[1]);
	}
	
	/**
	 * shows the picture of the second dice with the thrown number + continue button
	 * @param n_dice - dice number
	 */
	public void addpicture2(int n_dice) {
		bgLabel[2] = new JLabel();
		bgLabel[2].setBounds(50,50,200,200);
		if(n_dice == 1) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("eins.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[2].setIcon(bgIcon);
			bgLabel[2].setLocation(300, 100);
		}else if(n_dice == 2){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("zwei.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[2].setIcon(bgIcon);
			bgLabel[2].setLocation(300, 100);
		}else if(n_dice == 3){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("drei.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[2].setIcon(bgIcon);
			bgLabel[2].setLocation(300, 100);
		}else if(n_dice == 4){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("vier.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[2].setIcon(bgIcon);
			bgLabel[2].setLocation(300, 100);
		}else if(n_dice == 5){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("fuenf.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[2].setIcon(bgIcon);
			bgLabel[2].setLocation(300, 100);
		}else if(n_dice == 6){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("sechs.png"));
			bgIcon.setImage(bgIcon.getImage());
			bgLabel[2].setIcon(bgIcon);
			bgLabel[2].setLocation(300, 100);
		}
		JButton button = new JButton("Continue");
		button.addActionListener(this);;
		bgpanel[1].add(bgLabel[2]);
		bgpanel[1].add(button);
		window.add(bgpanel[1]);
		window.setSize(500,500);
		window.setVisible(true);
	}
	
	/**
	 * determines two random numbers and puts them together (higher number first)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(showed == false){	
				number1 = Random.getRandomNumber();
				number2 = Random.getRandomNumber();
				window.dispose();
				bgpanel[1].removeAll();
				if(number1 > number2) {
					number = Integer.parseInt(Integer.toString(number1) + Integer.toString(number2));
					addpicture1(number1);
					addpicture2(number2);
				}else {
					number = Integer.parseInt(Integer.toString(number2) + Integer.toString(number1));
					addpicture1(number2);
					addpicture2(number1);
				}
				PlayerInfoUI.Players[PlayerInfoUI.player_order].setRolled(number);
				showed = true;
			}else {
				window.dispose();
				showed = false;
				if(PlayerInfoUI.highest_number != 21) {
					NumberCall n_call = new NumberCall();
				}else {
					PlayerInfoUI.Players[PlayerInfoUI.player_order].setCalled(PlayerInfoUI.highest_number);
					Trust trust_ui = new Trust();
				}
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

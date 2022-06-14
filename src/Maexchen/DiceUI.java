package Maexchen;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiceUI implements ActionListener {
	public JFrame window;
	public JPanel bgpanel[] = new JPanel[5];
	public JLabel bgLabel[] = new JLabel[5];
	public int youngest;
	public int youngest_player;
	public int number1;
	public int number2;
	

	
	public DiceUI(){
		// TODO Auto-generated method stub
		setYoungestPlayer();
		createFirstMainField();
		createBackground();
		window.setVisible(true);
	}
	
	public void createFirstMainField() {
		window = new JFrame();
		window.setSize(400,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setTitle(PlayerInfoUI.Players[youngest_player].getName());
	}
	
	public void createBackground() {
		bgpanel[1] = new JPanel();
		bgpanel[1].setBounds(50,50,300,250);

		
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(50,50,300,250);
		
		JButton button = new JButton("Show numbers!");
		button.addActionListener(this);
		
		bgpanel[1].add(bgLabel[1]);
		bgpanel[1].add(button);
		window.add(bgpanel[1]);
		
	}
	
	public void setYoungestPlayer() {
		youngest = PlayerInfoUI.Players[0].getAge();
		for(int i = 0;i < UI.input_players; i++) {
			if(youngest > PlayerInfoUI.Players[i].getAge()) {
				youngest = PlayerInfoUI.Players[i].getAge();
				youngest_player = i;
			}
		}
	}
	
	public void addpicture1(int n_dice) {
		if(n_dice == 1) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("eins.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 2){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("zwei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 3){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("drei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 4){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("vier.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 5){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("fuenf.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}else if(n_dice == 6){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("sechs.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(100, 100);
		}
	}
	
	public void addpicture2(int n_dice) {
		if(n_dice == 1) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("eins.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(200, 100);
		}else if(n_dice == 2){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("zwei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(200, 100);
		}else if(n_dice == 3){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("drei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(200, 100);
		}else if(n_dice == 4){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("vier.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(200, 100);
		}else if(n_dice == 5){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("fuenf.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(200, 100);
		}else if(n_dice == 6){
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("sechs.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(100,50,Image.SCALE_DEFAULT));
			bgLabel[1].setIcon(bgIcon);
			bgLabel[1].setLocation(200, 100);
		}
		bgpanel[1].add(bgLabel[1]);
		window.add(bgpanel[1]);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				number1 = Random.getRandomNumber();
				number2 = Random.getRandomNumber();
				addpicture1(number1);
				addpicture2(number2);
				window.setVisible(true);
			
	}

}

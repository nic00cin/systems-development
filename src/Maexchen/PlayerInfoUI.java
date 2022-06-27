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

public class PlayerInfoUI implements ActionListener {

	public JFrame window;
	public JPanel bgpanel[] = new JPanel[4];
	public JLabel bgLabel[] = new JLabel[4];
	public int player_count = 1;
	public JTextField name_players;
	public String input_nameplayers;
	public JTextField age_players;
	public int input_age;
	public static Player Players[] = new Player[UI.input_players];
	public static int player_order;
	public static boolean done = false;
	public static int highest_number;
	public static boolean first_round = true;
	
	public PlayerInfoUI(){
		// TODO Auto-generated method stub
		createMainField();
		createBackground();
		window.setVisible(true);
	}
	
	/**
	 * creates window player information
	 */
	public void createMainField() {
		window = new JFrame();
		window.setSize(400,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setTitle("Player Information");
	}
	
	/**
	 * creates buttons/text fields for the player info
	 */
	public void createBackground() {
		bgpanel[1] = new JPanel();
		bgpanel[1].setBounds(50,50,400,100);

		
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(50,50,400,100);
		
		
		name_players = new JTextField("Name", 4);
		age_players = new JTextField("Age", 4);
		
		JButton button = new JButton("Submit");
		button.addActionListener(this);
		
		bgpanel[1].add(bgLabel[1]);
		bgpanel[1].add(name_players);
		bgpanel[1].add(age_players);
		bgpanel[1].add(button);
		window.add(bgpanel[1]);
		
	}
	

	/**
	 * adds player
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
		input_nameplayers = name_players.getText();
		input_age = Integer.parseInt(age_players.getText());
		window.setVisible(false);
		Player player = new Player(input_nameplayers, input_age);
		Players[player_count - 1 ] = player;
		if(player_count != UI.input_players)  {
			createMainField();
			createBackground();
			window.setVisible(true);
			player_count = player_count + 1;
			}else {
				window.dispose();
				DiceUI dice_ui = new DiceUI();
			}
		}
        catch (NumberFormatException ex){
        //	 System.out.println("No input or no integer!");
        	JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Wrong or empty input!");
        }
	}

}

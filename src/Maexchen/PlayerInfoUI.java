package Maexchen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Maexchen.UI.MyComboBoxRenderer;

public class PlayerInfoUI implements ActionListener {

	public JFrame window;
	public JPanel titlePanel;
	public JPanel inputPanel;
	public JPanel imagePanel;
	public JLabel titleLabel;
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
		createTitlePanel();
		createInputPanel();
		createImagePanel();
		createMainField();
	}
	
	/**
	 * creates window player information
	 */
	public void createMainField() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setLayout(new BorderLayout());
		window.add(titlePanel, BorderLayout.NORTH);
		window.add(imagePanel, BorderLayout.CENTER);
		window.add(inputPanel, BorderLayout.SOUTH);
		window.setTitle("Mäxchen");
		window.setVisible(true);
	}
	
	public void createTitlePanel() {
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titleLabel = new JLabel("Add Player");
		
		titlePanel.add(titleLabel, BorderLayout.CENTER);
	}
	
	/**
	 * creates buttons/text fields for the player info
	 */
	public void createInputPanel() {
		inputPanel = new JPanel();
		inputPanel.setBounds(50,50,400,100);
		
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(50,50,400,100);
		
		
		name_players = new JTextField("Name", 4);
		name_players.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name_players.setText("");
			}
		});
		age_players = new JTextField("Age", 4);
		age_players.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				age_players.setText("");
			}
		});
		
		JButton button = new JButton("Submit");
		button.addActionListener(this);
		
		inputPanel.add(bgLabel[1]);
		inputPanel.add(name_players);
		inputPanel.add(age_players);
		inputPanel.add(button);
	}
	
	public void createImagePanel() {
		imagePanel = new JPanel() {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("Wuerfel.jpeg"));
			Image bgImage = bgIcon.getImage();
			
			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(390, 390);
            }
		};
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
			createTitlePanel();
			createInputPanel();
			createImagePanel();
			createMainField();
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

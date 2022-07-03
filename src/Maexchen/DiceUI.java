package Maexchen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DiceUI implements ActionListener, WindowListener {
	public JFrame window;
	public JPanel titlePanel;
	public JPanel imagePanel;
	public JPanel inputPanel;
	public JLabel titleLabel;
	public JLabel firstDiceLabel;
	public JLabel secondDiceLabel;
	public boolean showed = false;
	public int youngest;
	public int youngest_player;
	public int number1;
	public int number2;
	public int number;

	public DiceUI() {
		setYoungestPlayer();
		createTitlePanel();
		createImagePanel();
		createInputPanel();
		createMainField();
	}

	/**
	 * Create Main Field with title
	 */
	public void createMainField() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.setSize(500, 500);
		window.setLayout(new BorderLayout());
		window.add(titlePanel, BorderLayout.NORTH);
		window.add(imagePanel, BorderLayout.CENTER);
		window.add(inputPanel, BorderLayout.SOUTH);
		window.addWindowListener(this);
		window.setTitle("Mäxchen");
		window.setVisible(true);
	}

	/**
	 * Create panel for the page title and game manual
	 */
	public void createTitlePanel() {
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		String name = PlayerInfoUI.Players[PlayerInfoUI.player_order].getName();
		titleLabel = new JLabel("It's your turn " + name + ". Only you are allowed to see your dice result!");

		titlePanel.add(titleLabel, BorderLayout.CENTER);
	}

	/**
	 * Create panel for the player label and the show numbers button
	 */
	public void createInputPanel() {
		inputPanel = new JPanel();
		inputPanel.setBounds(50, 50, 200, 200);

		JButton button = new JButton("Show numbers!");
		button.addActionListener(this);

		inputPanel.add(button);
	}

	/**
	 * Create panel for main image view
	 */
	public void createImagePanel() {
		imagePanel = new JPanel();
		JLabel imageLabel = new JLabel();

		ImageIcon dice = new ImageIcon(getClass().getClassLoader().getResource("roll-the-dice.gif"));
		dice.getImage();
		imageLabel.setIcon(dice);

		imagePanel.add(imageLabel);
	}

	/**
	 * determines who the youngest player is and lets him start
	 */
	public void setYoungestPlayer() {
		if (PlayerInfoUI.done == false) {
			youngest = PlayerInfoUI.Players[0].getAge();
			for (int i = 0; i < UI.input_players; i++) {
				if (youngest > PlayerInfoUI.Players[i].getAge()) {
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
	 * 
	 * @param n_dice - dice number
	 */
	public void addpicture1(int n_dice) {
		firstDiceLabel = new JLabel();
		if (n_dice == 1) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("eins.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			firstDiceLabel.setIcon(bgIcon);
			firstDiceLabel.setLocation(100, 100);
		} else if (n_dice == 2) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("zwei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			firstDiceLabel.setIcon(bgIcon);
			firstDiceLabel.setLocation(100, 100);
		} else if (n_dice == 3) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("drei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			firstDiceLabel.setIcon(bgIcon);
			firstDiceLabel.setLocation(100, 100);
		} else if (n_dice == 4) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("vier.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			firstDiceLabel.setIcon(bgIcon);
			firstDiceLabel.setLocation(100, 100);
		} else if (n_dice == 5) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("fuenf.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			firstDiceLabel.setIcon(bgIcon);
			firstDiceLabel.setLocation(100, 100);
		} else if (n_dice == 6) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("sechs.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			firstDiceLabel.setIcon(bgIcon);
			firstDiceLabel.setLocation(100, 100);
		}
	}

	/**
	 * shows the picture of the second dice with the thrown number + continue button
	 * 
	 * @param n_dice - dice number
	 */
	public void addpicture2(int n_dice) {
		secondDiceLabel = new JLabel();
		if (n_dice == 1) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("eins.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			secondDiceLabel.setIcon(bgIcon);
			secondDiceLabel.setLocation(300, 100);
		} else if (n_dice == 2) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("zwei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			secondDiceLabel.setIcon(bgIcon);
			secondDiceLabel.setLocation(300, 100);
		} else if (n_dice == 3) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("drei.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			secondDiceLabel.setIcon(bgIcon);
			secondDiceLabel.setLocation(300, 100);
		} else if (n_dice == 4) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("vier.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			secondDiceLabel.setIcon(bgIcon);
			secondDiceLabel.setLocation(300, 100);
		} else if (n_dice == 5) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("fuenf.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			secondDiceLabel.setIcon(bgIcon);
			secondDiceLabel.setLocation(300, 100);
		} else if (n_dice == 6) {
			ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("sechs.png"));
			bgIcon.setImage(bgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			secondDiceLabel.setIcon(bgIcon);
			secondDiceLabel.setLocation(300, 100);
		}
	}

	/**
	 * determines two random numbers and puts them together (higher number first)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (showed == false) {
			number1 = Random.getRandomNumber();
			number2 = Random.getRandomNumber();
			window.dispose();
			titlePanel.removeAll();
			imagePanel.removeAll();
			inputPanel.removeAll();
			if (number1 > number2) {
				number = Integer.parseInt(Integer.toString(number1) + Integer.toString(number2));
				addpicture1(number1);
				addpicture2(number2);
			} else {
				number = Integer.parseInt(Integer.toString(number2) + Integer.toString(number1));
				addpicture1(number2);
				addpicture2(number1);
			}

			JButton button = new JButton("Continue");
			button.addActionListener(this);
			imagePanel.add(firstDiceLabel);
			imagePanel.add(secondDiceLabel);
			inputPanel.add(button);

			window.add(imagePanel, BorderLayout.CENTER);
			window.add(inputPanel, BorderLayout.SOUTH);
			window.setSize(500, 500);
			window.setVisible(true);

			PlayerInfoUI.Players[PlayerInfoUI.player_order].setRolled(number);
			showed = true;
		} else {
			window.dispose();
			showed = false;
			if (PlayerInfoUI.highest_number == 66) {
				window.dispose();
				PlayerInfoUI.Players[PlayerInfoUI.player_order].setCalled(66);
				Trust trust_ui = new Trust();
			} else if (number != 21) {
				NumberCall n_call = new NumberCall();
			} else {
				PlayerInfoUI.Players[PlayerInfoUI.player_order].increasePoints();
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, PlayerInfoUI.Players[PlayerInfoUI.player_order].getName() + " got a Mäxchen! Congratulations, you win a point!");
				window.dispose();
				DiceUI dice_ui = new DiceUI();
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	/**
	 * This method asks the user if he wants to exits the game and if yes shows the
	 * Points table
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		int antwort = JOptionPane.showConfirmDialog(window, "Do you really want to exit the game?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (antwort == JOptionPane.YES_OPTION) {
			window.dispose();
			PointsTable points_tb = new PointsTable();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}

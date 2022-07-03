package Maexchen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PointsTable {
	public JFrame window;
	public JPanel titlePanel;
	public JPanel imagePanel;
	public JPanel winnerPanel;
	public JLabel bgLabel[] = new JLabel[UI.input_players];
	public JLabel winnerLabel;
	public static int highestpoints = -100000;
	public static int highestp_index = 0;

	public PointsTable() {
		createTitlePanel();
		createImagePanel();
		createWinnerPanel();
		createFirstMainField();
	}

	/**
	 * shows the name of the winner in the title
	 */
	public void createFirstMainField() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setLayout(new BorderLayout());
		window.add(titlePanel, BorderLayout.NORTH);
		window.add(imagePanel, BorderLayout.CENTER);
		window.add(winnerPanel, BorderLayout.SOUTH);
		window.setTitle("Mäxchen");
		window.setVisible(true);
	}

	/**
	 * shows all players and their points in the user interface
	 */
	public void createTitlePanel() {
		titlePanel = new JPanel();
		titlePanel.setBounds(50, 50, 200, 150);

		for (int i = 0; i < UI.input_players; i++) {
			bgLabel[i] = new JLabel(
					PlayerInfoUI.Players[i].getName() + " has " + PlayerInfoUI.Players[i].getPoints() + " Points ");
			bgLabel[i].setBounds(50, 50, 200, 150);
			titlePanel.add(bgLabel[i]);
		}
	}

	/**
	 * This method creates the trust user interface
	 */
	public void createWinnerPanel() {
		winnerPanel = new JPanel();
		String winner = "Congratulations " + PlayerInfoUI.Players[getWinner()].getName() + ", you are the Winner!";
		winnerLabel = new JLabel(winner);

		winnerPanel.add(winnerLabel);
	}

	/**
	 * Create panel for main image view
	 */
	public void createImagePanel() {
		imagePanel = new JPanel();
		imagePanel.setBackground(Color.WHITE);
		JLabel imageLabel = new JLabel();

		ImageIcon dice = new ImageIcon(getClass().getClassLoader().getResource("trophy.gif"));
		dice.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		imageLabel.setIcon(dice);

		imagePanel.add(imageLabel);
	}

	/**
	 * Checks which player has the most points
	 * 
	 * @return the winner
	 */
	public static int getWinner() {

		for (int i = 0; i < UI.input_players; i++) {
			
			if (PlayerInfoUI.Players[i].getPoints() > highestpoints) {
				highestpoints = PlayerInfoUI.Players[i].getPoints();
				highestp_index = i;
			} else if (PlayerInfoUI.Players[i].getPoints() == highestpoints) {
				if (PlayerInfoUI.Players[i].getAge() < PlayerInfoUI.Players[highestp_index].getAge()) {
					highestp_index = i;
				}
			}
			/*if (PlayerInfoUI.Players[i].getPoints() == highestpoints) {
				if (PlayerInfoUI.Players[i].getAge() < PlayerInfoUI.Players[highestp_index].getAge()) {
					highestp_index = i;
				}
			} else if (PlayerInfoUI.Players[i].getPoints() > highestpoints) {
				highestpoints = PlayerInfoUI.Players[i].getPoints();
				highestp_index = i;
			}*/
		}
		System.out.println(highestp_index);
		return highestp_index;
	}
}

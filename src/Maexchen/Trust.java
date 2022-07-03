package Maexchen;

import java.awt.*;
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
import javax.swing.JTextField;

public class Trust implements ActionListener, WindowListener {
	private enum Actions {
		TRUST, LIE
	}

	public JFrame window;
	public JPanel titlePanel;
	public JPanel imagePanel;
	public JPanel inputPanel;
	public JLabel bgLabel[] = new JLabel[5];
	public JLabel titleLabel;
	public JTextField number_called;
	public int input_number;

	public Trust() {
		createTitlePanel();
		createImagePanel();
		createInputPanel();
		createMainField();
	}

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
		String name;
		String otherName = PlayerInfoUI.Players[PlayerInfoUI.player_order].getName();
		if (PlayerInfoUI.player_order + 1 >= UI.input_players) {
			name = PlayerInfoUI.Players[0].getName();
		} else {
			name = PlayerInfoUI.Players[PlayerInfoUI.player_order + 1].getName();
		}
		titleLabel = new JLabel("It's your turn " + name + ". Do you believe what " + otherName + " said?");

		titlePanel.add(titleLabel, BorderLayout.CENTER);
	}

	/**
	 * This method creates the trust user interface
	 */
	public void createInputPanel() {
		inputPanel = new JPanel();
		inputPanel.setBounds(50, 50, 300, 250);

		bgLabel[1] = new JLabel(PlayerInfoUI.Players[PlayerInfoUI.player_order].getName() + " rolled: "
				+ PlayerInfoUI.Players[PlayerInfoUI.player_order].getCalled());
		bgLabel[1].setBounds(50, 50, 300, 250);

		JButton trust = new JButton("Trust!");
		trust.setActionCommand(Actions.TRUST.name());
		trust.addActionListener(this);

		JButton lie = new JButton("Lie!");
		lie.setActionCommand(Actions.LIE.name());
		lie.addActionListener(this);

		inputPanel.add(bgLabel[1]);
		inputPanel.add(trust);
		inputPanel.add(lie);
	}
	
	/**
	 * Create panel for main image view
	 */
	public void createImagePanel() {
		imagePanel = new JPanel();
		imagePanel.setBackground(Color.WHITE);
		JLabel imageLabel = new JLabel();

		ImageIcon dice = new ImageIcon(getClass().getClassLoader().getResource("question.png"));
		dice.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		imageLabel.setIcon(dice);

		imagePanel.add(imageLabel);
	}

	/**
	 * this method checks if the previous user lied if trust is chosen
	 * It also adds/subtracts points depending on the situation
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == Actions.TRUST.name()) {
			if (PlayerInfoUI.player_order + 1 >= UI.input_players) {
				PlayerInfoUI.player_order = 0;
				window.dispose();

				DiceUI dice_ui = new DiceUI();
			} else {
				PlayerInfoUI.player_order += 1;
				window.dispose();

				DiceUI dice_ui = new DiceUI();
			}
		} else if (e.getActionCommand() == Actions.LIE.name()) {
			PlayerInfoUI.first_round = true;

			if (CheckerMaexchen.check() == true) {
				if (PlayerInfoUI.player_order + 1 >= UI.input_players) {
					PlayerInfoUI.Players[0].decreasePoints();

					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, PlayerInfoUI.Players[PlayerInfoUI.player_order].getName()
							+ " said the truth! So you loose a point!");
				} else {
					PlayerInfoUI.Players[PlayerInfoUI.player_order + 1].decreasePoints();

					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, PlayerInfoUI.Players[PlayerInfoUI.player_order].getName()
							+ " said the truth! So you loose a point!");
				}
			} else {
				PlayerInfoUI.Players[PlayerInfoUI.player_order].decreasePoints();

				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame,
						PlayerInfoUI.Players[PlayerInfoUI.player_order].getName() + " lied to you! So "
								+ PlayerInfoUI.Players[PlayerInfoUI.player_order].getName() + " looses a point!");

				if (PlayerInfoUI.player_order + 1 >= UI.input_players) {
					PlayerInfoUI.player_order = 0;
				} else {
					PlayerInfoUI.player_order += 1;
				}
			}
			PlayerInfoUI.highest_number = 0;
			window.dispose();
			DiceUI dice_ui = new DiceUI();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}
	/**
	 * This method asks the user if he wants to exits the game and if yes shows the Points table
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
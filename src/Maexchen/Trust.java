package Maexchen;

import java.awt.Color;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
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

public class Trust implements ActionListener, WindowListener {
	private enum Actions {
		TRUST, LIE
	}

	public JFrame window;
	public JPanel bgpanel[] = new JPanel[5];
	public JLabel bgLabel[] = new JLabel[5];
	public JTextField number_called;
	public int input_number;

	public Trust() {
		createFirstMainField();
		createBackground();
		window.setVisible(true);
	}

	public void createFirstMainField() {
		window = new JFrame();
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.addWindowListener(this);
		if (PlayerInfoUI.player_order + 1 >= UI.input_players) {
			window.setTitle(PlayerInfoUI.Players[0].getName());
		} else {
			window.setTitle(PlayerInfoUI.Players[PlayerInfoUI.player_order + 1].getName());
		}
	}

	/**
	 * This method creates the trust user interface
	 */
	public void createBackground() {
		bgpanel[1] = new JPanel();
		bgpanel[1].setBounds(50, 50, 300, 250);

		bgLabel[1] = new JLabel(PlayerInfoUI.Players[PlayerInfoUI.player_order].getName() + " rolled: "
				+ PlayerInfoUI.Players[PlayerInfoUI.player_order].getCalled());
		bgLabel[1].setBounds(50, 50, 300, 250);

		JButton trust = new JButton("Trust!");
		trust.setActionCommand(Actions.TRUST.name());
		trust.addActionListener(this);

		JButton lie = new JButton("Lie!");
		lie.setActionCommand(Actions.LIE.name());
		lie.addActionListener(this);

		bgpanel[1].add(bgLabel[1]);
		bgpanel[1].add(trust);
		bgpanel[1].add(lie);
		window.add(bgpanel[1]);
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

			window.dispose();
			DiceUI dice_ui = new DiceUI();
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
		int antwort = JOptionPane.showConfirmDialog(window, "Do you really want to exit the game?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (antwort == JOptionPane.YES_OPTION) {
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
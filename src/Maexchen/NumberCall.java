package Maexchen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class NumberCall implements ActionListener, WindowListener {
	public JFrame window;
	public JPanel titlePanel;
	public JPanel inputPanel;
	public JPanel imagePanel;
	public JLabel bgLabel[] = new JLabel[5];
	public JLabel titleLabel;
	public JTextField number_called;
	public int input_number;

	public NumberCall() {
		createTitlePanel();
		createImagePanel();
		createInputPanel();
		createMainField();
	}

	/**
	 * shows the rolled number
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
		titleLabel = new JLabel(name + ", please input the number you say you rolled");

		titlePanel.add(titleLabel, BorderLayout.CENTER);
	}

	/**
	 * lets you input the number you want to tell
	 */
	public void createInputPanel() {
		inputPanel = new JPanel();
		inputPanel.setBounds(50, 50, 300, 250);

		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(50, 50, 300, 250);

		number_called = new JTextField("Number", 4);
		number_called.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				number_called.setText("");
			}
		});
		JButton button = new JButton("Submit!");
		button.addActionListener(this);

		inputPanel.add(bgLabel[1]);
		inputPanel.add(number_called);
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
	 * checks if the input makes sense
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			input_number = Integer.parseInt(number_called.getText());
			if (CheckerMaexchen.NumberisIn(input_number) == true) {
				if (PlayerInfoUI.first_round == true) {
					PlayerInfoUI.Players[PlayerInfoUI.player_order].setCalled(input_number);
					PlayerInfoUI.highest_number = input_number;
					window.dispose();
					PlayerInfoUI.first_round = false;
					Trust trust = new Trust();
				} else {
					if (CheckerMaexchen.checkhigher(input_number) == true) {
						PlayerInfoUI.Players[PlayerInfoUI.player_order].setCalled(input_number);
						PlayerInfoUI.highest_number = input_number;
						window.dispose();
						Trust trust = new Trust();
					} else {
						PlayerInfoUI.Players[PlayerInfoUI.player_order].decreasePoints();
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "You lost a point, because you entered a lower number as before. Try again.");
					}
				}
			} else {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "You can't enter this number!");
			}
		} catch (NumberFormatException ex) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "Wrong or empty input!");
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

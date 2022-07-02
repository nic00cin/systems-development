package Maexchen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;


	public class UI implements ActionListener {
		public JFrame window;
		public JPanel titlePanel;
		public JPanel imagePanel;
		public JPanel inputPanel;
		public JTextField n_players;
		public JButton startButton;
		public JComboBox instructionsMenu;
		public JMenuItem german;
		public JMenuItem english;
		public JLabel titleLabel;
		public static int input_players;
		public PlayerInfoUI playerinfo_ui;
		
		public UI(){
			createTitlePanel();
			createImagePanel();
			createInputPanel();
			createMainField();
		}
		
		/**
		 *  Create Main Field with title
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
		
		/**
		 *  Create start window + number of players can be added + button start game
		 */
		
		public void createTitlePanel() {
			titlePanel = new JPanel();
			titlePanel.setLayout(new BorderLayout());
			titleLabel = new JLabel("Start Menu");
			
			String[] items = {"German", "English"};
			instructionsMenu = new JComboBox(items);
			instructionsMenu.setRenderer(new MyComboBoxRenderer("Manual"));
			instructionsMenu.setSelectedIndex(-1);
			instructionsMenu.addActionListener(this);
			
			titlePanel.add(titleLabel, BorderLayout.CENTER);
			titlePanel.add(instructionsMenu, BorderLayout.EAST);
		}
		
		public void createInputPanel() {
			inputPanel = new JPanel();
			
			n_players = new JTextField("Players", 4);
			n_players.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					n_players.setText("");
				}
			});
			
			startButton = new JButton("New Game");
			startButton.addActionListener(this);
			
			inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
	        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
			
			inputPanel.add(n_players);
			inputPanel.add(startButton);
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
		 * Checks if the players input makes sense
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == startButton) {
				try{
					input_players = Integer.parseInt(n_players.getText());
					if(input_players > 1) {
						window.setVisible(false);
						window.dispose();
						PlayerInfoUI playerinfo_ui = new PlayerInfoUI();
					}else {
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "Go out and get you a friend to play with haha!");
					}
				}
		        catch (NumberFormatException ex){
		        	JFrame jFrame = new JFrame();
		            JOptionPane.showMessageDialog(jFrame, "No input or no integer!");
		        }
			} else if (e.getSource() == instructionsMenu) {
				int index = instructionsMenu.getSelectedIndex();
				
				if (index == 0) {
					try {
				        Desktop.getDesktop().browse(new URL("https://www.spielewiki.org/wiki/M%C3%A4xchen").toURI());
				    } catch (Exception ex) {
				        ex.printStackTrace();
				    }
				} else if (index == 1) {
					try {
				        Desktop.getDesktop().browse(new URL("http://www.games-wiki.org/wiki/Mia/").toURI());
				    } catch (Exception ex) {
				        ex.printStackTrace();
				    }
				}
				
			}
		}
		
		class MyComboBoxRenderer extends JLabel implements ListCellRenderer
	    {
	        private String _title;

	        public MyComboBoxRenderer(String title)
	        {
	            _title = title;
	        }

			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				if (index == -1 && value == null) setText(_title);
	            else setText(value.toString());
	            return this;
			}

	        
	    }

	}


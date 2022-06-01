import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


	public class UI {
		static JFrame window;
		public static JPanel bgpanel[] = new JPanel[3];
		public static JLabel bgLabel[] = new JLabel[3];
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			createMainField();
			createBackground();
			window.setVisible(true);
		}
		
		public static void createMainField() {
			window = new JFrame();
			window.setSize(800,600);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().setBackground(Color.white);
			window.setTitle("Mäxchen");
		}
		
		public static void createBackground() {
			bgpanel[1] = new JPanel();
			bgpanel[1].setBounds(50,50,700,350);
		
			
			bgLabel[1] = new JLabel();
			bgLabel[1].setBounds(50,50,700,350);
			
			ImageIcon bgIcon = new ImageIcon("Wuerfel.png");
			bgLabel[1].setIcon(bgIcon);
			
			bgpanel[1].add(bgLabel[1]);
			window.add(bgpanel[1]);
			
		}

	}



package projectMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class StartScreen extends JFrame {
	
	public StartScreen() {
		// 기본 frame 설정
		JFrame frame = new JFrame("시작 화면");
		frame.setLayout(null);

		// JPanel

		JPanel poster = new JPanel();
		
		JButton ss_btn = new JButton();
		ss_btn.setBorderPainted(false);
		ss_btn.setContentAreaFilled(false);
		ss_btn.setFocusPainted(false);
		ss_btn.setOpaque(false);
		ss_btn.setBounds(0, 0, 450, 800);
		
		ss_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기에 Main 생성자 호출하기
				new MainScreen();
				frame.setVisible(false);
			}
		});
		

		pic = new JLabel();
		pic.setBounds(0, 0, 450, 800);

		// Call The Function SetImageSize
		SetImageSize(6);
		// set a timer
		tm = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				x += 1;
				if (x >= list.length)
					x = 0;
			}
		});

		poster.add(pic);
		tm.start();
		poster.setBounds(0, 0, 450, 800);
		poster.setBackground(Color.white);
		
		// poster 누르면 메인으로
		// MainScreen
		
//		poster.addActionListener

		// 기본 프레임 설정
		frame.setBounds(700, 200, 450, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		
		frame.add(poster);
		frame.add(ss_btn);
	}

	static JLabel pic;
	static Timer tm;
	static int x = 0;
	// Images Path In Array
	static String[] list = { ".\\img\\CGVposter1.jpg", // 0
			".\\img\\CGVposter2.jpg", // 1
			".\\img\\CGVposter3.jpg", // 2
			".\\img\\CGVposter4.jpg", // 3
			".\\img\\CGVposter5.jpg", // 4
			".\\img\\CGVposter6.jpg", // 5
			".\\img\\CGVposter7.jpg"// 6
	};
	
	public static void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		pic.setIcon(newImc);
	}

}

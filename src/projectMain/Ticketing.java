package projectMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import projectMain.StartScreen;
import projectMain.Screen;

import javax.swing.JOptionPane;

public class Ticketing extends JFrame {

	static String cgv_loc;
	static String movie_time;
	static char adult_num;
	static char kid_num;
	static char elder_num;
	static JLabel pic;
	static Timer tm;
	static int x = 0;
	// Images Path In Array
	static String[] list = { ".\\img\\CGVchange1.jpg", // 0
			".\\img\\CGVchange2.png", // 1
			".\\img\\CGVchange3.jpg", // 2
			".\\img\\CGVchange4.jpg", // 3
			".\\img\\CGVchange5.jpg", // 4
			".\\img\\CGVchange6.jpg", // 5
			".\\img\\CGVchange7.jpg"// 6
	};

	public Ticketing() {

		// 기본 frame 설정
		JFrame frame = new JFrame("예매 화면");
		frame.setLayout(null);

		Font rhelr = new Font("맑은 고딕", Font.BOLD, 20);
		Font rhelr2 = new Font("맑은 고딕", Font.BOLD, 15);
		Font rhelr3 = new Font("맑은 고딕", Font.BOLD, 13);

		// CGV 버튼 (cgvImg를 버튼에 넣음)
		ImageIcon cgvImg = new ImageIcon(".\\img\\CGV.png");

		JToggleButton cgv = new JToggleButton(new ImageIcon(".\\img\\CGV.png"));
		cgv.setBounds(130, 10, 200, 100);

		cgv.setBorderPainted(false);
		cgv.setContentAreaFilled(false);
		cgv.setFocusPainted(false);
		cgv.setOpaque(false);

		cgv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainScreen();
				frame.setVisible(false);
			}
		});

		// JPanel

		JPanel red = new JPanel();

		pic = new JLabel();
		pic.setBounds(0, 0, 450, 190);

		SetImageSize(6);
		// 타이머 세팅
		tm = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				x += 1;
				if (x >= list.length)
					x = 0;
			}
		});

		red.add(pic);
		tm.start();
		red.setBounds(-10, 130, 450, 190);
		red.setBackground(Color.white);

		// 극장선택
		String[] cgv_loc_c = { "부평", "남주안", "계양" };
		JComboBox<String> tc = new JComboBox<String>(cgv_loc_c);
		tc.setFont(rhelr);
		tc.setBounds(40, 345, 90, 40);

		// 2D 라벨
		JLabel label_2d = new JLabel("2D");
		label_2d.setBounds(40, 400, 80, 30);
		label_2d.setFont(rhelr);

		// 시간대 선택
		ButtonGroup movieTime = new ButtonGroup();

		JRadioButton[] time = new JRadioButton[6];
		for (int i = 0; i < time.length; i++) {
			time[i] = new JRadioButton((9 + (i * 2)) + ":30 " + "~" + (11 + (i * 2)) + " : 42", true);
			time[i].setFont(rhelr3);
			time[i].setBackground(Color.white);
			movieTime.add(time[i]);
			for (int j = 0; j < time.length; j++) {
				time[i].setBounds(40 + (i * 120), 430, 120, 30);
				if (i >= 3) {
					time[i].setBounds(40 + ((i - 3) * 120), 460, 120, 30);
				}
			}
		}

		// 인원선택
		JLabel people = new JLabel("인원선택");
		people.setBounds(40, 500, 80, 30);
		people.setFont(rhelr);

		// 인원선택 - 어른
		JLabel adult = new JLabel("일반");
		adult.setBounds(40, 540, 50, 30);
		adult.setFont(rhelr2);

		ButtonGroup num_adult = new ButtonGroup();
		JRadioButton[] adult_btn = new JRadioButton[6];

		for (int i = 0; i < adult_btn.length; i++) {
			adult_btn[i] = new JRadioButton(i + "명", true);
			adult_btn[i].setFont(rhelr2);
			adult_btn[i].setBackground(Color.white);
			for (int j = 0; j < adult_btn.length; j++) {
				adult_btn[i].setBounds(90 + (i * 50), 540, 50, 30);
			}
			num_adult.add(adult_btn[i]);
			// adult_num = adult_btn[i].getText().charAt(0);
		}

		// 인원선택 - 청소년
		JLabel kid = new JLabel("청소년");
		kid.setBounds(40, 570, 50, 30);
		kid.setFont(rhelr2);

		ButtonGroup num_kid = new ButtonGroup();
		JRadioButton[] kid_btn = new JRadioButton[6];

		for (int i = 0; i < kid_btn.length; i++) {
			kid_btn[i] = new JRadioButton(i + "명", true);
			kid_btn[i].setFont(rhelr2);
			kid_btn[i].setBackground(Color.white);
			for (int j = 0; j < kid_btn.length; j++) {
				kid_btn[i].setBounds(90 + (i * 50), 570, 50, 30);
			}
			num_kid.add(kid_btn[i]);
		}

		// 인원선택 - 경로
		JLabel elder = new JLabel("경로");
		elder.setBounds(40, 600, 50, 30);
		elder.setFont(rhelr2);

		ButtonGroup num_elder = new ButtonGroup();
		JRadioButton[] elder_btn = new JRadioButton[6];

		for (int i = 0; i < elder_btn.length; i++) {
			elder_btn[i] = new JRadioButton(i + "명", true);
			elder_btn[i].setFont(rhelr2);
			elder_btn[i].setBackground(Color.white);
			for (int j = 0; j < elder_btn.length; j++) {
				elder_btn[i].setBounds(90 + (i * 50), 600, 50, 30);
			}
			num_elder.add(elder_btn[i]);
		}

		// 좌석선택 버튼

		JToggleButton btn_seat = new JToggleButton(new ImageIcon(".\\img\\seat.png"));

		// 좌석 선택 페이지로 넘어가게...
		btn_seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 선택된 라디오버튼 데이터 가져오기
				for (int i = 0; i < 6; i++) {
					if (adult_btn[i].isSelected()) {
						adult_num = adult_btn[i].getText().charAt(0);
					}
					if (kid_btn[i].isSelected()) {
						kid_num = kid_btn[i].getText().charAt(0);
					}
					if (elder_btn[i].isSelected()) {
						elder_num = elder_btn[i].getText().charAt(0);
					}
					if (time[i].isSelected()) {
						movie_time = time[i].getText();
					}
				}
				cgv_loc = tc.getSelectedItem().toString();

				// 선택한 인원 확인 메세지

				if (Character.getNumericValue(adult_num) + Character.getNumericValue(kid_num)
						+ Character.getNumericValue(elder_num) == 0) {
					JOptionPane.showMessageDialog(null, "인원을 선택해 주세요.");
				}

				else if (Character.getNumericValue(adult_num) + Character.getNumericValue(kid_num)
						+ Character.getNumericValue(elder_num) <= 8) {
					String msg = String.format("CGV %s점\n영화 시간 : %s\n어른 %c명 / 어린이 %c명 / 경로 %c명\n으로 틀림 없습니까?", cgv_loc,
							movie_time, adult_num, kid_num, elder_num);
					// 설명 OK일시에만 넘어가게!
					JPanel yesno = new JPanel();

					int dialogButton = JOptionPane.showConfirmDialog(null, msg, "WARNING", JOptionPane.YES_NO_OPTION);
					if (dialogButton == JOptionPane.YES_OPTION) {
						new Screen();
						frame.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "예매 가능한 인원수는 최대 8명까지 입니다.");
				}
			}

		});

//		JButton btn_seat = new JButton("좌석선택");
		btn_seat.setBounds(-10, 670, 450, 50);

		btn_seat.setBorderPainted(false);
		btn_seat.setContentAreaFilled(false);
		btn_seat.setFocusPainted(false);
		btn_seat.setOpaque(false);

		// 프레임에 요소 추가
		frame.add(label_2d);
		frame.add(tc);
		frame.add(cgv);
		frame.add(red);
		frame.add(people);
		frame.add(adult);
		frame.add(kid);
		frame.add(elder);
		frame.add(btn_seat);

		frame.add(time[0]);
		frame.add(time[1]);
		frame.add(time[2]);
		frame.add(time[3]);
		frame.add(time[4]);
		frame.add(time[5]);

		frame.add(adult_btn[0]);
		frame.add(adult_btn[1]);
		frame.add(adult_btn[2]);
		frame.add(adult_btn[3]);
		frame.add(adult_btn[4]);
		frame.add(adult_btn[5]);

		frame.add(kid_btn[0]);
		frame.add(kid_btn[1]);
		frame.add(kid_btn[2]);
		frame.add(kid_btn[3]);
		frame.add(kid_btn[4]);
		frame.add(kid_btn[5]);

		frame.add(elder_btn[0]);
		frame.add(elder_btn[1]);
		frame.add(elder_btn[2]);
		frame.add(elder_btn[3]);
		frame.add(elder_btn[4]);
		frame.add(elder_btn[5]);

		// 기본 프레임 설정
		frame.setBounds(700, 200, 450, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
	}

	public static void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		pic.setIcon(newImc);
	}

}
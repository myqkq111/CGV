package projectMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import projectMain.LoginView;

public class MainScreen {

	static String movieName;

	public MainScreen() {
		movieName = null;

		JFrame f = new JFrame();
		f.setLayout(null);

		// cgv로고
		ImageIcon ii1 = new ImageIcon(".\\img\\logoRed.png");
		Image img1 = ii1.getImage();
		Image changeImg1 = img1.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
		ImageIcon changeii1 = new ImageIcon(changeImg1);
		JButton b1 = new JButton(new ImageIcon(changeImg1));
		b1.setBorderPainted(false);// 선택되지 않은 상태에서 외곽선을 없애준다
		b1.setContentAreaFilled(false);// 내용영역 채우기를 없애준다
		b1.setFocusPainted(false);// 선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
		b1.setBounds(10, 5, 80, 40);
		f.add(b1);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainScreen();
				f.setVisible(false);

			}
		});

		// 장르선택
		// 액션
		ImageIcon genreIi1 = new ImageIcon(".\\img\\14genre01.png");
		Image genreImg1 = genreIi1.getImage();
		Image changeGenre1 = genreImg1.getScaledInstance(90, 35, Image.SCALE_SMOOTH);
		// ImageIcon changeGenreIi1 = new ImageIcon(changeGenre1);
		JButton genre1 = new JButton(new ImageIcon(changeGenre1));
		genre1.setBounds(0, 50, 90, 35);
		genre1.setBorderPainted(false);
		genre1.setFocusPainted(false);
		f.add(genre1);
		genre1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ActionScreen();
				f.setVisible(false);

			}
		});
		// 코미디
		ImageIcon genreIi2 = new ImageIcon(".\\img\\14genre02.png");
		Image genreImg2 = genreIi2.getImage();
		Image changeGenre2 = genreImg2.getScaledInstance(90, 35, Image.SCALE_SMOOTH);
		// ImageIcon changeGenreIi2 = new ImageIcon(changeGenre2);
		JButton genre2 = new JButton(new ImageIcon(changeGenre2));
		genre2.setBounds(90, 50, 90, 35);
		genre2.setBorderPainted(false);
		genre2.setFocusPainted(false);
		f.add(genre2);
		genre2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ComedyScreen();
				f.setVisible(false);

			}
		});
		// 범죄
		ImageIcon genreIi3 = new ImageIcon(".\\img\\14.5genre03.png");
		Image genreImg3 = genreIi3.getImage();
		Image changeGenre3 = genreImg3.getScaledInstance(90, 35, Image.SCALE_SMOOTH);
		// ImageIcon changeGenreIi3 = new ImageIcon(changeGenre3);
		JButton genre3 = new JButton(new ImageIcon(changeGenre3));
		genre3.setBounds(180, 50, 90, 35);
		genre3.setBorderPainted(false);
		genre3.setFocusPainted(false);
		f.add(genre3);
		genre3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CrimeScreen();
				f.setVisible(false);

			}
		});
		// 멜로,로맨스
		ImageIcon genreIi4 = new ImageIcon(".\\img\\14genre04.png");
		Image genreImg4 = genreIi4.getImage();
		Image changeGenre4 = genreImg4.getScaledInstance(170, 35, Image.SCALE_SMOOTH);
		// ImageIcon changeGenreIi4 = new ImageIcon(changeGenre4);
		JButton genre4 = new JButton(new ImageIcon(changeGenre4));
		genre4.setBounds(270, 50, 170, 35);
		genre4.setBorderPainted(false);
		genre4.setFocusPainted(false);
		f.add(genre4);
		genre4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RomanceScreen();
				f.setVisible(false);

			}
		});

		if (LoginService.ifLogin == 1) {
			// 로그아웃
			ImageIcon ii11 = new ImageIcon(".\\img\\로그인.png");
			Image img11 = ii11.getImage();
			Image changeImg11 = img11.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
			ImageIcon changeii11 = new ImageIcon(changeImg11);
			JButton b5 = new JButton(new ImageIcon(changeImg11));
			b5.setBorderPainted(false);// 선택되지 않은 상태에서 외곽선을 없애준다
			b5.setContentAreaFilled(false);// 내용영역 채우기를 없애준다
			b5.setFocusPainted(false);// 선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
			b5.setBounds(345, 5, 35, 35);
			f.add(b5);
			JLabel audiences10 = new JLabel("로그아웃");
			audiences10.setBounds(342, 33, 40, 20);
			audiences10.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			audiences10.setForeground(Color.gray);
			f.add(audiences10);
			b5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LoginService.ifLogin = 0;
					new MainScreen();
					f.setVisible(false);
				}
			});

		} else {
			// 로그인
			ImageIcon ii8 = new ImageIcon(".\\img\\로그인.png");
			Image img8 = ii8.getImage();
			Image changeImg8 = img8.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
			ImageIcon changeii8 = new ImageIcon(changeImg8);
			JButton b2 = new JButton(new ImageIcon(changeImg8));
			b2.setBorderPainted(false);// 선택되지 않은 상태에서 외곽선을 없애준다
			b2.setContentAreaFilled(false);// 내용영역 채우기를 없애준다
			b2.setFocusPainted(false);// 선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
			b2.setBounds(300, 5, 35, 35);
			f.add(b2);
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LoginView lo = new LoginView();
					lo.login();
					f.setVisible(false);

				}
			});
			JLabel audiences7 = new JLabel("로그인");
			audiences7.setBounds(303, 33, 30, 20);
			audiences7.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			audiences7.setForeground(Color.gray);
			f.add(audiences7);

			// 회원가입
			ImageIcon ii9 = new ImageIcon(".\\img\\회원가입.png");
			Image img9 = ii9.getImage();
			Image changeImg9 = img9.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
			ImageIcon changeii9 = new ImageIcon(changeImg9);
			JButton b3 = new JButton(new ImageIcon(changeImg9));
			b3.setBorderPainted(false);// 선택되지 않은 상태에서 외곽선을 없애준다
			b3.setContentAreaFilled(false);// 내용영역 채우기를 없애준다
			b3.setFocusPainted(false);// 선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
			b3.setBounds(345, 5, 35, 35);
			f.add(b3);
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new MemberInfo();
					f.setVisible(false);
				}
			});
			JLabel audiences8 = new JLabel("회원가입");
			audiences8.setBounds(342, 33, 40, 20);
			audiences8.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			audiences8.setForeground(Color.gray);
			f.add(audiences8);

		}

		// 마이페이지
		ImageIcon ii10 = new ImageIcon(".\\img\\마이페이지.png");
		Image img10 = ii10.getImage();
		Image changeImg10 = img10.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon changeii10 = new ImageIcon(changeImg10);
		JButton b4 = new JButton(new ImageIcon(changeImg10));
		b4.setBorderPainted(false);// 선택되지 않은 상태에서 외곽선을 없애준다
		b4.setContentAreaFilled(false);// 내용영역 채우기를 없애준다
		b4.setFocusPainted(false);// 선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
		b4.setBounds(390, 6, 35, 35);
		f.add(b4);
		JLabel audiences9 = new JLabel("MY CGV");
		audiences9.setBounds(387, 33, 40, 20);
		audiences9.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		audiences9.setForeground(Color.gray);
		f.add(audiences9);
		
		if (LoginService.ifLogin == 1) {
			b4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new MyPage();
					f.setVisible(false);
				}
			});
		} else {
			b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 알림창~
					JOptionPane.showMessageDialog(null, "로그인 한 상태로 클릭해 주세요.");
					
				}
			});
			

		}

		// 범죄도시2
		ImageIcon ii2 = new ImageIcon(".\\img\\범죄도시2.jpg");
		Image img2 = ii2.getImage();
		Image changeImg2 = img2.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
		ImageIcon changeii2 = new ImageIcon(changeImg2);
		JLabel jl2 = new JLabel(changeii2);
		jl2.setBounds(27, 1, 110, 140);
		// 제목
		JLabel moviename1 = new JLabel("범죄도시2");
		moviename1.setBounds(44, 140, 80, 30);
		moviename1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		// 별
		ImageIcon star1 = new ImageIcon(".\\img\\별.png");
		Image strImg1 = star1.getImage();
		Image changeStarImg1 = strImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon changeStart1 = new ImageIcon(changeStarImg1);
		JLabel staJl1 = new JLabel(changeStart1);
		staJl1.setBounds(16, 168, 15, 15);
		// 평점
		JLabel rating1 = new JLabel("9.0");
		rating1.setBounds(31, 164, 20, 20);
		rating1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rating1.setForeground(Color.gray);
		// 누적관객수
		JLabel audiences1 = new JLabel("누적관객1,269만");
		audiences1.setBounds(53, 149, 120, 50);
		audiences1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		audiences1.setForeground(Color.gray);
		// 예매버튼	
		JToggleButton bt1 = new JToggleButton(new ImageIcon(".\\img\\reserve.png"));
		bt1.setBounds(37, 184, 90, 23);
		bt1.setBorderPainted(false);
		bt1.setContentAreaFilled(false);
		bt1.setFocusPainted(false);
		bt1.setOpaque(false);
		if (LoginService.ifLogin == 1) {
			bt1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					movieName = "범죄도시2";
					new Ticketing();
					f.setVisible(false);
				}
			});
		} else {
			bt1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 알림창~
					JOptionPane.showMessageDialog(null, "로그인 한 상태로 클릭해 주세요.");
					
				}
			});
			

		}
		// 패널
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(50, 100, 160, 205);
		panel1.setBackground(Color.white);
		panel1.add(jl2);
		panel1.add(moviename1);
		panel1.add(staJl1);
		panel1.add(rating1);
		panel1.add(audiences1);
		panel1.add(bt1);
		f.add(panel1);

		// 트루먼쇼
		ImageIcon ii3 = new ImageIcon(".\\img\\트루먼쇼.jfif");
		Image img3 = ii3.getImage();
		Image changeImg3 = img3.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
		ImageIcon changeii3 = new ImageIcon(changeImg3);
		JLabel jl3 = new JLabel(changeii3);
		jl3.setBounds(27, 1, 110, 140);
		// 제목
		JLabel moviename2 = new JLabel("트루먼쇼");
		moviename2.setBounds(50, 140, 80, 30);
		moviename2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		// 별
		ImageIcon star2 = new ImageIcon(".\\img\\별.png");
		Image strImg2 = star2.getImage();
		Image changeStarImg2 = strImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon changeStart2 = new ImageIcon(changeStarImg2);
		JLabel staJl2 = new JLabel(changeStart2);
		staJl2.setBounds(21, 168, 15, 15);
		// 평점
		JLabel rating2 = new JLabel("9.5");
		rating2.setBounds(36, 164, 20, 20);
		rating2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rating2.setForeground(Color.gray);
		// 누적관객수
		JLabel audiences2 = new JLabel("누적관객500만");
		audiences2.setBounds(58, 149, 120, 50);
		audiences2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		audiences2.setForeground(Color.gray);
		// 예매버튼
		JToggleButton bt2 = new JToggleButton(new ImageIcon(".\\img\\reserve.png"));
		bt2.setBounds(39, 184, 90, 23);
		bt2.setBorderPainted(false);
		bt2.setContentAreaFilled(false);
		bt2.setFocusPainted(false);
		bt2.setOpaque(false);
		if (LoginService.ifLogin == 1) {
			bt2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					movieName = "트루먼쇼";
					new Ticketing();
					f.setVisible(false);
				}
			});
		} else {
			bt2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 알림창~
					JOptionPane.showMessageDialog(null, "로그인 한 상태로 클릭해 주세요.");
					
				}
			});
			

		}
		// 패널
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(220, 100, 160, 205);
		panel2.setBackground(Color.white);
		panel2.add(jl3);
		panel2.add(moviename2);
		panel2.add(staJl2);
		panel2.add(rating2);
		panel2.add(audiences2);
		panel2.add(bt2);
		f.add(panel2);

		// 아바타
		ImageIcon ii4 = new ImageIcon(".\\img\\아바타.jpg");
		Image img4 = ii4.getImage();
		Image changeImg4 = img4.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
		ImageIcon changeii4 = new ImageIcon(changeImg4);
		JLabel jl4 = new JLabel(changeii4);
		jl4.setBounds(27, 1, 110, 140);
		// 제목
		JLabel moviename3 = new JLabel("아바타");
		moviename3.setBounds(57, 140, 80, 30);
		moviename3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		// 별
		ImageIcon star3 = new ImageIcon(".\\img\\별.png");
		Image strImg3 = star3.getImage();
		Image changeStarImg3 = strImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon changeStart3 = new ImageIcon(changeStarImg3);
		JLabel staJl3 = new JLabel(changeStart3);
		staJl3.setBounds(16, 168, 15, 15);
		// 평점
		JLabel rating3 = new JLabel("8.8");
		rating3.setBounds(31, 164, 20, 20);
		rating3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rating3.setForeground(Color.gray);
		// 누적관객수
		JLabel audiences3 = new JLabel("누적관객1,079만");
		audiences3.setBounds(53, 149, 120, 50);
		audiences3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		audiences3.setForeground(Color.gray);
		// 예매버튼
		JToggleButton bt3 = new JToggleButton(new ImageIcon(".\\img\\reserve.png"));
		bt3.setBounds(39, 184, 90, 23);
		bt3.setBorderPainted(false);
		bt3.setContentAreaFilled(false);
		bt3.setFocusPainted(false);
		bt3.setOpaque(false);
		if (LoginService.ifLogin == 1) {
			bt3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					movieName = "아바타";
					new Ticketing();
					f.setVisible(false);
				}
			});
		} else {
			bt3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 알림창~
					JOptionPane.showMessageDialog(null, "로그인 한 상태로 클릭해 주세요.");
					
				}
			});
			

		}
		// 패널
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(50, 320, 160, 205);
		panel3.setBackground(Color.white);
		panel3.add(jl4);
		panel3.add(moviename3);
		panel3.add(staJl3);
		panel3.add(rating3);
		panel3.add(audiences3);
		panel3.add(bt3);
		f.add(panel3);

		// 어벤져스
		ImageIcon ii5 = new ImageIcon(".\\img\\어벤져스.jpg");
		Image img5 = ii5.getImage();
		Image changeImg5 = img5.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
		ImageIcon changeii5 = new ImageIcon(changeImg5);
		JLabel jl5 = new JLabel(changeii5);
		jl5.setBounds(27, 1, 110, 140);
		// 제목
		JLabel moviename4 = new JLabel("어벤져스");
		moviename4.setBounds(50, 140, 80, 30);
		moviename4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		// 별
		ImageIcon star4 = new ImageIcon(".\\img\\별.png");
		Image strImg4 = star4.getImage();
		Image changeStarImg4 = strImg4.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon changeStart4 = new ImageIcon(changeStarImg4);
		JLabel staJl4 = new JLabel(changeStart4);
		staJl4.setBounds(16, 168, 15, 15);
		// 평점
		JLabel rating4 = new JLabel("9.5");
		rating4.setBounds(31, 164, 20, 20);
		rating4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rating4.setForeground(Color.gray);
		// 누적관객수
		JLabel audiences4 = new JLabel("누적관객1,397만");
		audiences4.setBounds(53, 149, 120, 50);
		audiences4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		audiences4.setForeground(Color.gray);
		// 예매버튼
		JToggleButton bt4 = new JToggleButton(new ImageIcon(".\\img\\reserve.png"));
		bt4.setBounds(39, 184, 90, 23);
		bt4.setBorderPainted(false);
		bt4.setContentAreaFilled(false);
		bt4.setFocusPainted(false);
		bt4.setOpaque(false);
		if (LoginService.ifLogin == 1) {
			bt4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					movieName = "어벤져스";
					new Ticketing();
					f.setVisible(false);
				}
			});
		} else {
			bt4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 알림창~
					JOptionPane.showMessageDialog(null, "로그인 한 상태로 클릭해 주세요.");
					
				}
			});
			

		}
		// 패널
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(220, 320, 160, 205);
		panel4.setBackground(Color.white);
		panel4.add(jl5);
		panel4.add(moviename4);
		panel4.add(staJl4);
		panel4.add(rating4);
		panel4.add(audiences4);
		panel4.add(bt4);
		f.add(panel4);

		// 탑건
		ImageIcon ii6 = new ImageIcon(".\\img\\탑건.jfif");
		Image img6 = ii6.getImage();
		Image changeImg6 = img6.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
		ImageIcon changeii6 = new ImageIcon(changeImg6);
		JLabel jl6 = new JLabel(changeii6);
		jl6.setBounds(27, 1, 110, 140);
		// 제목
		JLabel moviename5 = new JLabel("탑건");
		moviename5.setBounds(65, 140, 80, 30);
		moviename5.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		// 별
		ImageIcon star5 = new ImageIcon(".\\img\\별.png");
		Image strImg5 = star5.getImage();
		Image changeStarImg5 = strImg5.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon changeStart5 = new ImageIcon(changeStarImg5);
		JLabel staJl5 = new JLabel(changeStart5);
		staJl5.setBounds(21, 168, 15, 15);
		// 평점
		JLabel rating5 = new JLabel("9.6");
		rating5.setBounds(36, 164, 20, 20);
		rating5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rating5.setForeground(Color.gray);
		// 누적관객수
		JLabel audiences5 = new JLabel("누적관객819만");
		audiences5.setBounds(58, 149, 120, 50);
		audiences5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		audiences5.setForeground(Color.gray);
		// 예매버튼
		JToggleButton bt5 = new JToggleButton(new ImageIcon(".\\img\\reserve.png"));
		bt5.setBounds(39, 184, 90, 23);
		bt5.setBorderPainted(false);
		bt5.setContentAreaFilled(false);
		bt5.setFocusPainted(false);
		bt5.setOpaque(false);
		if (LoginService.ifLogin == 1) {
			bt5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					movieName = "탑건";
					new Ticketing();
					f.setVisible(false);
				}
			});
		} else {
			bt5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 알림창~
					JOptionPane.showMessageDialog(null, "로그인 한 상태로 클릭해 주세요.");
					
				}
			});
			

		}
		// 패널
		JPanel panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setBounds(50, 540, 160, 205);
		panel5.setBackground(Color.white);
		panel5.add(jl6);
		panel5.add(moviename5);
		panel5.add(staJl5);
		panel5.add(rating5);
		panel5.add(audiences5);
		panel5.add(bt5);
		f.add(panel5);

		// 타이타닉
		ImageIcon ii7 = new ImageIcon(".\\img\\타이타닉.jpg");
		Image img7 = ii7.getImage();
		Image changeImg7 = img7.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
		ImageIcon changeii7 = new ImageIcon(changeImg7);
		JLabel jl7 = new JLabel(changeii7);
		jl7.setBounds(27, 1, 110, 140);
		// 제목
		JLabel moviename6 = new JLabel("타이타닉");
		moviename6.setBounds(48, 140, 80, 30);
		moviename6.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		// 별
		ImageIcon star6 = new ImageIcon(".\\img\\별.png");
		Image strImg6 = star6.getImage();
		Image changeStarImg6 = strImg6.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon changeStart6 = new ImageIcon(changeStarImg6);
		JLabel staJl6 = new JLabel(changeStart6);
		staJl6.setBounds(16, 168, 15, 15);
		// 평점
		JLabel rating6 = new JLabel("9.7");
		rating6.setBounds(31, 164, 20, 20);
		rating6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rating6.setForeground(Color.gray);
		// 누적관객수
		JLabel audiences6 = new JLabel("누적관객1,971만");
		audiences6.setBounds(53, 149, 120, 50);
		audiences6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		audiences6.setForeground(Color.gray);
		// 예매버튼
		JToggleButton bt6 = new JToggleButton(new ImageIcon(".\\img\\reserve.png"));
		bt6.setBounds(39, 184, 90, 23);
		bt6.setBorderPainted(false);
		bt6.setContentAreaFilled(false);
		bt6.setFocusPainted(false);
		bt6.setOpaque(false);
		if (LoginService.ifLogin == 1) {
			bt6.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					movieName = "타이타닉";
					new Ticketing();
					f.setVisible(false);
				}
			});
		} else {
			bt6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 알림창~
					JOptionPane.showMessageDialog(null, "로그인 한 상태로 클릭해 주세요.");
					
				}
			});
			

		}
		// 패널
		JPanel panel6 = new JPanel();
		panel6.setLayout(null);
		panel6.setBounds(220, 540, 160, 205);
		panel6.setBackground(Color.white);
		panel6.add(jl7);
		panel6.add(moviename6);
		panel6.add(staJl6);
		panel6.add(rating6);
		panel6.add(audiences6);
		panel6.add(bt6);
		f.add(panel6);

		f.getContentPane().setBackground(Color.WHITE);
		f.setBounds(700, 200, 450, 800);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
	}

}

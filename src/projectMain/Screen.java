package projectMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class Screen extends JFrame {

	String name;

	String[] allMovieName = { MainScreen.movieName, ActionScreen.movieName, ComedyScreen.movieName,
			CrimeScreen.movieName, RomanceScreen.movieName };

	public Screen() {
		MainScreen.movieName = null;
		ActionScreen.movieName = null;
		ComedyScreen.movieName = null;
		CrimeScreen.movieName = null;
		RomanceScreen.movieName = null;

		System.out.println();
		// 제목
		JFrame frame = new JFrame("스크린");

		// 배경 글꼴 색깔 크기
		Font font = new Font("맑은고딕", Font.BOLD, 16);
		frame.setBounds(700, 200, 450, 800);
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);// 수동배치

		// 스크린
		JButton screen = new JButton("스크린");
		screen.setBounds(135, 30, 170, 50);
		screen.setBackground(Color.LIGHT_GRAY);
		screen.setForeground(Color.black);

		// 결제하기 버튼

		JToggleButton payment = new JToggleButton(new ImageIcon(".\\img\\payment.png"));
		payment.setBounds(-10, 670, 450, 50);

		payment.setBorderPainted(false);
		payment.setContentAreaFilled(false);
		payment.setFocusPainted(false);
		payment.setOpaque(false);

		// 변경 버튼
		JButton change = new JButton("변경");
		change.setBounds(155, 545, 60, 30);
		change.setBackground(Color.PINK);
		change.setForeground(Color.RED);

//		// 영화제목 라벨
//		JLabel title = new JLabel();
//		title.setBounds(30, 510, 100, 100);

		// :영화제목

		w: while (true) {
			for (int i = 0; i < 5; i++) {
				if (allMovieName[i] != null) {
					name = allMovieName[i];
					break w;
				}
			}

		}

		JLabel movieName = new JLabel(name);
		movieName.setBounds(30, 510, 100, 100);

		// 극장정보 라벨
		JLabel info = new JLabel(Ticketing.cgv_loc + " " + Ticketing.movie_time);
		info.setBounds(30, 550, 200, 100);

		// :극장정보

		JLabel movieInfo = new JLabel();
		movieInfo.setBounds(100, 550, 100, 100);

		// 일반 라벨
		JLabel common = new JLabel("일반");
		common.setBounds(30, 590, 100, 100);

		// 일반라벨 카운트
		JLabel count1 = new JLabel(String.valueOf(Ticketing.adult_num));
		count1.setBounds(65, 590, 100, 100);

		// 슬래쉬
		JLabel slash = new JLabel("/");
		slash.setBounds(93, 590, 100, 100);

		// 청소년
		JLabel teenager = new JLabel("청소년");
		teenager.setBounds(102, 590, 100, 100);

		// :청소년 카운트
		JLabel count2 = new JLabel(String.valueOf(Ticketing.kid_num));
		count2.setBounds(151, 590, 100, 100);

		// 슬래쉬2
		JLabel slash2 = new JLabel("/");
		slash2.setBounds(174, 590, 100, 100);

		// 경로 라벨
		JLabel oldman = new JLabel("경로");
		oldman.setBounds(182, 590, 100, 100);

		// :경로 카운트
		JLabel count3 = new JLabel(String.valueOf(Ticketing.elder_num));
		count3.setBounds(217, 590, 100, 100);

		// 돈 라벨
		JLabel money = new JLabel();
		money.setBounds(350, 590, 100, 100);
		
		// 좌석 버튼
		JButton[][] seatList = new JButton[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				seatList[i][j] = new JButton(("" + (char) (i + 65)) + Integer.toString(j + 1));
				seatList[i][j].setBounds(30 + j * 75, 100 + i * 85, 75, 75);
				frame.add(seatList[i][j]);
				seatList[i][j].setBackground(Color.LIGHT_GRAY);
				seatList[i][j].setFont(font);
				seatList[i][j].setForeground(Color.black);

				// 파일 읽어오기
				try {
					File file = new File(".\\src\\projectMain\\SeatData.txt");
					if (file.exists()) {
						FileReader fr = new FileReader(file);
						BufferedReader inFile = new BufferedReader(new FileReader(file));
						
						String sLine = null;
						String[] sLineInfo = new String[5]; // '/'를 기준으로 정보 배열에 넣기
						
						while ((sLine = inFile.readLine()) != null) {
							
							// 영화,장소,시간 비교
							for (int k = 0; k < 5; k++) {
								sLineInfo[k] = sLine.split("/")[k];
							}
							
							if (
									sLineInfo[1].equals(name) && 
									sLineInfo[2].equals(Ticketing.cgv_loc) && 
									sLineInfo[3].equals(Ticketing.movie_time) && 
									sLineInfo[4].equals(seatList[i][j].getText())) {
								seatList[i][j].setBackground(Color.black);
								seatList[i][j].setEnabled(false);
							}
							
							// 좌석만 가져오기
//					if (sLine.equals(seatList[i][j].getText())) {
//						seatList[i][j].setBackground(Color.black);
//						seatList[i][j].setEnabled(false);
//					}
							
						} // while
						inFile.close();
						
					}
				} catch (Exception e) {
					
				}
				
				seatList[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton seatButton = (JButton) e.getSource();
						int countSum = Integer.parseInt(count1.getText()) + Integer.parseInt(count2.getText())
								+ Integer.parseInt(count3.getText());
						if (countSum == seatList.length * seatList[0].length) {
							seatButton.setEnabled(false);
						} else {
							seatButton.setBackground(seatButton.getBackground() == Color.LIGHT_GRAY ? Color.DARK_GRAY
									: Color.LIGHT_GRAY);
							// Update the selected seat count based on the seat selection state
							countSum = seatButton.getBackground() == Color.DARK_GRAY ? 1 : -1;
						}
					}
				});
			}
		}

		// 카운트 합
		int countSum = Integer.parseInt(count1.getText()) + Integer.parseInt(count2.getText())
				+ Integer.parseInt(count3.getText());

		// 폰트
		screen.setFont(font);
		payment.setFont(font);
		info.setFont(font);
		common.setFont(font);
		count1.setFont(font);
		count2.setFont(font);
		slash.setFont(font);
		money.setFont(font);
		teenager.setFont(font);
		movieName.setFont(font);
		movieInfo.setFont(font);
		oldman.setFont(font);
		count3.setFont(font);
		slash2.setFont(font);

		// 프레임
		frame.add(screen);
		frame.add(info);
		frame.add(change);
		frame.add(payment);
		frame.add(common);
		frame.add(count1);
		frame.add(slash);
		frame.add(teenager);
		frame.add(count2);
		frame.add(money);
		frame.add(movieName);
		frame.add(movieInfo);
		frame.add(oldman);
		frame.add(count3);
		frame.add(slash2);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		payment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object source = e.getSource();
				int countSum = Integer.parseInt(count1.getText()) + Integer.parseInt(count2.getText())
						+ Integer.parseInt(count3.getText());

				int seatCount = 0;
				// 인원수와 좌석수 비교
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (seatList[i][j].getBackground() == Color.DARK_GRAY) {
							seatCount += 1;
						}
					}
				}
				
				int adult_price = 10000;
				int kid_price = 6000;
				int elder_price = 8000;
				
				int price_total = ((Character.getNumericValue(Ticketing.adult_num) * adult_price) + (Character.getNumericValue(Ticketing.kid_num) * kid_price) + (Character.getNumericValue(Ticketing.elder_num) * elder_price));
				String price_total_str = Integer.toString(price_total);

				if (Character.getNumericValue(Ticketing.adult_num) + Character.getNumericValue(Ticketing.kid_num)
						+ Character.getNumericValue(Ticketing.elder_num) != seatCount) {
					JOptionPane.showMessageDialog(null, "선택한 좌석 수가 인원 수와 다릅니다.");
				} else {
					if (source == payment) {
						int result = JOptionPane.showConfirmDialog(frame, (price_total_str + "원 입니다.\n결제하시겠습니까?"), "결제 확인",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(frame, "결제가 완료되었습니다.", "결제 완료",
									JOptionPane.INFORMATION_MESSAGE);

							// 파일에 저장

							try {
								FileOutputStream file = new FileOutputStream(".\\src\\projectMain\\SeatData.txt", true);
//								File file = new File(".\\src\\projectMain\\SeatData.txt");
//									FileWriter fw = new FileWriter(file);
//								BufferedWriter writer = new BufferedWriter(fw);
								
								// 좌석 번호를 파일에 저장
								for (int i = 0; i < 5; i++) {
									for (int j = 0; j < 5; j++) {
										if (seatList[i][j].getBackground() == Color.DARK_GRAY) {
											String msg = LoginService.idInfo + "/" + name + "/" + Ticketing.cgv_loc + "/" + Ticketing.movie_time
													+ "/" + seatList[i][j].getText() + "\n";
											file.write(msg.getBytes());
										}
									}
								}
								file.close();


							} catch (Exception e1) {

							}

							new MainScreen();
							frame.setVisible(false);

						} // 여기까지 결제 완료일 때 벌어지는 이벤트

					}
				}

			}

		});

		change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainScreen();
				frame.setVisible(false);
			}
		});

		// 변수 이름 다시 설정

	}

}
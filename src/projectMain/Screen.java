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
		// ����
		JFrame frame = new JFrame("��ũ��");

		// ��� �۲� ���� ũ��
		Font font = new Font("�������", Font.BOLD, 16);
		frame.setBounds(700, 200, 450, 800);
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);// ������ġ

		// ��ũ��
		JButton screen = new JButton("��ũ��");
		screen.setBounds(135, 30, 170, 50);
		screen.setBackground(Color.LIGHT_GRAY);
		screen.setForeground(Color.black);

		// �����ϱ� ��ư

		JToggleButton payment = new JToggleButton(new ImageIcon(".\\img\\payment.png"));
		payment.setBounds(-10, 670, 450, 50);

		payment.setBorderPainted(false);
		payment.setContentAreaFilled(false);
		payment.setFocusPainted(false);
		payment.setOpaque(false);

		// ���� ��ư
		JButton change = new JButton("����");
		change.setBounds(155, 545, 60, 30);
		change.setBackground(Color.PINK);
		change.setForeground(Color.RED);

//		// ��ȭ���� ��
//		JLabel title = new JLabel();
//		title.setBounds(30, 510, 100, 100);

		// :��ȭ����

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

		// �������� ��
		JLabel info = new JLabel(Ticketing.cgv_loc + " " + Ticketing.movie_time);
		info.setBounds(30, 550, 200, 100);

		// :��������

		JLabel movieInfo = new JLabel();
		movieInfo.setBounds(100, 550, 100, 100);

		// �Ϲ� ��
		JLabel common = new JLabel("�Ϲ�");
		common.setBounds(30, 590, 100, 100);

		// �Ϲݶ� ī��Ʈ
		JLabel count1 = new JLabel(String.valueOf(Ticketing.adult_num));
		count1.setBounds(65, 590, 100, 100);

		// ������
		JLabel slash = new JLabel("/");
		slash.setBounds(93, 590, 100, 100);

		// û�ҳ�
		JLabel teenager = new JLabel("û�ҳ�");
		teenager.setBounds(102, 590, 100, 100);

		// :û�ҳ� ī��Ʈ
		JLabel count2 = new JLabel(String.valueOf(Ticketing.kid_num));
		count2.setBounds(151, 590, 100, 100);

		// ������2
		JLabel slash2 = new JLabel("/");
		slash2.setBounds(174, 590, 100, 100);

		// ��� ��
		JLabel oldman = new JLabel("���");
		oldman.setBounds(182, 590, 100, 100);

		// :��� ī��Ʈ
		JLabel count3 = new JLabel(String.valueOf(Ticketing.elder_num));
		count3.setBounds(217, 590, 100, 100);

		// �� ��
		JLabel money = new JLabel();
		money.setBounds(350, 590, 100, 100);
		
		// �¼� ��ư
		JButton[][] seatList = new JButton[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				seatList[i][j] = new JButton(("" + (char) (i + 65)) + Integer.toString(j + 1));
				seatList[i][j].setBounds(30 + j * 75, 100 + i * 85, 75, 75);
				frame.add(seatList[i][j]);
				seatList[i][j].setBackground(Color.LIGHT_GRAY);
				seatList[i][j].setFont(font);
				seatList[i][j].setForeground(Color.black);

				// ���� �о����
				try {
					File file = new File(".\\src\\projectMain\\SeatData.txt");
					if (file.exists()) {
						FileReader fr = new FileReader(file);
						BufferedReader inFile = new BufferedReader(new FileReader(file));
						
						String sLine = null;
						String[] sLineInfo = new String[5]; // '/'�� �������� ���� �迭�� �ֱ�
						
						while ((sLine = inFile.readLine()) != null) {
							
							// ��ȭ,���,�ð� ��
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
							
							// �¼��� ��������
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

		// ī��Ʈ ��
		int countSum = Integer.parseInt(count1.getText()) + Integer.parseInt(count2.getText())
				+ Integer.parseInt(count3.getText());

		// ��Ʈ
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

		// ������
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
				// �ο����� �¼��� ��
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
					JOptionPane.showMessageDialog(null, "������ �¼� ���� �ο� ���� �ٸ��ϴ�.");
				} else {
					if (source == payment) {
						int result = JOptionPane.showConfirmDialog(frame, (price_total_str + "�� �Դϴ�.\n�����Ͻðڽ��ϱ�?"), "���� Ȯ��",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(frame, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�",
									JOptionPane.INFORMATION_MESSAGE);

							// ���Ͽ� ����

							try {
								FileOutputStream file = new FileOutputStream(".\\src\\projectMain\\SeatData.txt", true);
//								File file = new File(".\\src\\projectMain\\SeatData.txt");
//									FileWriter fw = new FileWriter(file);
//								BufferedWriter writer = new BufferedWriter(fw);
								
								// �¼� ��ȣ�� ���Ͽ� ����
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

						} // ������� ���� �Ϸ��� �� �������� �̺�Ʈ

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

		// ���� �̸� �ٽ� ����

	}

}
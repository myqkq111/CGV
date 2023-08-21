package projectMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class MyPage extends JFrame {

	public MyPage() {

		JFrame frame = new JFrame("마이페이지");

		Font font1 = new Font("Serif", Font.BOLD, 50);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 15);

		// CGV 로고
		ImageIcon cgvImg = new ImageIcon(".\\img\\CGV.png");
		JToggleButton cgv = new JToggleButton(new ImageIcon(".\\img\\CGV.png"));
		cgv.setBounds(130, 60, 200, 100);

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

		frame.add(cgv); // 여기까지 로고

		// 아이디
		JLabel idLabel = new JLabel("아이디 : ");
		idLabel.setBounds(120, 200, 100, 20);
		idLabel.setFont(font2);
		frame.add(idLabel);

		JTextField idField = new JTextField();
		idField.setBounds(200, 200, 130, 30);
		idField.setText(LoginService.idInfo);
		idField.setEditable(false);
		frame.add(idField);

		// 이름
		JLabel nameLabel = new JLabel("이름 : ");
		nameLabel.setBounds(140, 245, 100, 20);
		nameLabel.setFont(font2);
		frame.add(nameLabel);

		JTextField nField = new JTextField();
		nField.setBounds(200, 245, 130, 30);
		nField.setText(LoginService.nameInfo);
		nField.setEditable(false);
		frame.add(nField);

		// 전화번호
		JLabel telLabel = new JLabel("전화번호 : ");
		telLabel.setBounds(100, 295, 100, 20);
		telLabel.setFont(font2);
		frame.add(telLabel);

		JTextField tField = new JTextField();
		tField.setBounds(200, 293, 130, 30);
		tField.setText(LoginService.telInfo);
		tField.setEditable(false);
		frame.add(tField);

		// 예매정보 파일 읽어오기
		try {
			File file = new File(".\\src\\projectMain\\SeatData.txt");
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader inFile = new BufferedReader(new FileReader(file));

				String sLine = null;
				String[] sLineInfo = new String[5]; // '/'를 기준으로 정보 배열에 넣기

				int plus = -25;
				int num_count = 0;

				while ((sLine = inFile.readLine()) != null) {

					// 저장되어있는 아이디와 현재 로그인 되어있는 아이디가 일치하는지 확인
					for (int k = 0; k < 5; k++) {
						sLineInfo[k] = sLine.split("/")[k];

					}

					// 저장되어있는 아이디와 현재 로그인 되어있는 아이디가 일치한다면 정보 출력
					if (sLineInfo[0].equals(LoginService.idInfo)) {

						JLabel TicketInfo = new JLabel("예매 정보");
						TicketInfo.setBounds(170, 350, 200, 20);
						TicketInfo.setFont(font2);
						frame.add(TicketInfo);

						plus += 25;
						num_count += 1;

						// 영화이름
						JLabel movieName = new JLabel();
						movieName.setBounds(70, 380 + plus, 300, 20);
						movieName.setFont(font3);
						movieName.setText(num_count + ". " + sLineInfo[1] + " / " + sLineInfo[2] + " / " + sLineInfo[3]
								+ " / " + sLineInfo[4]);
						frame.add(movieName);

					} else {

					}

				} // while
				inFile.close();

			}
		} catch (Exception e) {

		}

		JToggleButton btn_input = new JToggleButton(new ImageIcon(".\\img\\seat.png"));
		btn_input.setBounds(-10, 670, 450, 50);
		btn_input.setBorderPainted(false);
		btn_input.setContentAreaFilled(false);
		btn_input.setFocusPainted(false);
		btn_input.setOpaque(false);
		btn_input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainScreen();
				frame.setVisible(false);
			}
		});

		frame.add(btn_input);

		frame.setBounds(700, 200, 450, 800);
//		frame.setBounds(  x,  y, width, height);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);

		frame.setLocationRelativeTo(null); // 가운데 정렬

	}

}

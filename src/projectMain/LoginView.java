package projectMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginView {
	
	static JFrame frame;
	
	public void login() {
		
		// 로그인
		// 로그인창을 띄움 O
		// 아이디, 패스워드 입력 받음 O
		// 아이디 && 패스워드 일치하는지 확인
		// T: 아이디 값을 마이페이지에게 보냄
		// F: 다시 입력 안내문
		
		// 로그인 창
		JFrame frame = new JFrame("Login");
		
		// 폰트
		Font rhelr = new Font("맑은 고딕", Font.BOLD, 15);
		
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
		
//		JLabel logo = new JLabel("CGV");
//		logo.setBounds(201, 100, 60, 30);
//		logo.setForeground(Color.red); // 빨간글씨
//		logo.setFont(new Font("Serif", Font.BOLD, 11)); // 굵은 글씨
//		frame.add(logo);
		
		// 아이디
		JLabel idLabel = new JLabel(new ImageIcon(".\\img\\login.png"));
		idLabel.setBounds(40, 240, 80, 30); // 130, 200, 60, 30
		idLabel.setFont(rhelr);
		frame.add(idLabel);
		JTextField idBox = new JTextField(10);
		idBox.setBounds(105, 240, 240, 35); // 180, 200, 120, 30
		frame.add(idBox);
		
		// 비밀번호
		JLabel pwLabel = new JLabel(new ImageIcon(".\\img\\logout.png"));
		pwLabel.setBounds(40, 310, 80, 30); // 116, 300, 60, 30
		frame.add(pwLabel);
		JPasswordField pwBox = new JPasswordField(10);
		pwBox.setBounds(105, 310, 240, 35); // 180, 300, 120, 30
//		pwBox.setEchoChar('*');
//		pwBox.size(TextField.);
		frame.add(pwBox);
//		pwBox.setToolTipText("ㅁㄴㅇㄹ");
		
		// 로그인 버튼
		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(210, 450, 160, 60); // 160, 550, 120, 30
		loginBtn.setFont(rhelr);
		frame.add(loginBtn);
		
		JButton signBtn = new JButton("회원가입");
		signBtn.setBounds(40, 450, 160, 60); // 160, 550, 120, 30
		signBtn.setFont(rhelr);
		frame.add(signBtn);
		
		signBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	            new MemberInfo();
	            frame.setVisible(false);
				
			}
		});
		
		loginBtn.addActionListener(new LoginService(idBox, pwBox));  // 프레임에 입력된 값을 넘겨줌
		
		// 프레임
		frame.setBounds(700, 200, 450, 800);
//		frame.setBounds(  x,  y, width, height);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		

		frame.setLocationRelativeTo(null); // 가운데 정렬
		
		this.frame = frame;
	}
	
}
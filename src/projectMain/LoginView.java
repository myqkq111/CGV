package projectMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginView {
	
	static JFrame frame;
	
	public void login() {
		
		// �α���
		// �α���â�� ��� O
		// ���̵�, �н����� �Է� ���� O
		// ���̵� && �н����� ��ġ�ϴ��� Ȯ��
		// T: ���̵� ���� �������������� ����
		// F: �ٽ� �Է� �ȳ���
		
		// �α��� â
		JFrame frame = new JFrame("Login");
		
		// ��Ʈ
		Font rhelr = new Font("���� ���", Font.BOLD, 15);
		
		// CGV �ΰ�
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
		
		frame.add(cgv); // ������� �ΰ�
		
//		JLabel logo = new JLabel("CGV");
//		logo.setBounds(201, 100, 60, 30);
//		logo.setForeground(Color.red); // �����۾�
//		logo.setFont(new Font("Serif", Font.BOLD, 11)); // ���� �۾�
//		frame.add(logo);
		
		// ���̵�
		JLabel idLabel = new JLabel(new ImageIcon(".\\img\\login.png"));
		idLabel.setBounds(40, 240, 80, 30); // 130, 200, 60, 30
		idLabel.setFont(rhelr);
		frame.add(idLabel);
		JTextField idBox = new JTextField(10);
		idBox.setBounds(105, 240, 240, 35); // 180, 200, 120, 30
		frame.add(idBox);
		
		// ��й�ȣ
		JLabel pwLabel = new JLabel(new ImageIcon(".\\img\\logout.png"));
		pwLabel.setBounds(40, 310, 80, 30); // 116, 300, 60, 30
		frame.add(pwLabel);
		JPasswordField pwBox = new JPasswordField(10);
		pwBox.setBounds(105, 310, 240, 35); // 180, 300, 120, 30
//		pwBox.setEchoChar('*');
//		pwBox.size(TextField.);
		frame.add(pwBox);
//		pwBox.setToolTipText("��������");
		
		// �α��� ��ư
		JButton loginBtn = new JButton("�α���");
		loginBtn.setBounds(210, 450, 160, 60); // 160, 550, 120, 30
		loginBtn.setFont(rhelr);
		frame.add(loginBtn);
		
		JButton signBtn = new JButton("ȸ������");
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
		
		loginBtn.addActionListener(new LoginService(idBox, pwBox));  // �����ӿ� �Էµ� ���� �Ѱ���
		
		// ������
		frame.setBounds(700, 200, 450, 800);
//		frame.setBounds(  x,  y, width, height);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		

		frame.setLocationRelativeTo(null); // ��� ����
		
		this.frame = frame;
	}
	
}
package projectMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class MemberInfo extends JFrame{
	String choice = null;
	
	public MemberInfo() {
		
		// ����
		setTitle("ȸ�� ����");
		
		// ��Ʈ
		Font rhelr2 = new Font("���� ���", Font.BOLD, 15);
		
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
				setVisible(false);
			}
		});
		
		add(cgv); // ������� �ΰ�
		
		// ȸ�� ���� �� ��� ��ư ����
		JButton join = new JButton("ȸ�� ����");
		JButton cancel = new JButton("��\n��");
		
		// ���� ���� ���� �ڽ� ũ��
		JTextField id = new JTextField(15);
		JPasswordField pw = new JPasswordField(15);
		JTextField name = new JTextField(15);
		JTextField tel = new JTextField(15);
		JTextArea ta = new JTextArea();
		
		
		// form �г�
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("��  ��  ��   "));
		idPanel.add(id);
		idPanel.setBounds(350, 400, 180, 100);
		idPanel.setBackground(Color.WHITE);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(new JLabel("�� �� �� ȣ  "));
		pwPanel.add(pw);
		pwPanel.setBounds(350, 300, 180, 100);
		pwPanel.setBackground(Color.WHITE);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel(" ��      ��    "));
		namePanel.add(name);
		namePanel.setBounds(350, 200, 180, 100);
		namePanel.setBackground(Color.WHITE);
		
		JPanel telPanel = new JPanel();
		telPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		telPanel.add(new JLabel("��  ��  ó   "));
		telPanel.add(tel);
		telPanel.setBounds(350, 100, 180, 100);
		telPanel.setBackground(Color.WHITE);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 2));
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(namePanel);
		formPanel.add(telPanel);
		formPanel.setBounds(20,200,300,100);
		formPanel.setBackground(Color.WHITE);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.add(formPanel);
		contentPanel.setBackground(Color.WHITE);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.add(join);
		panel.add(cancel);
		
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(700, 200, 450, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null); // ��� ����
		
		
		// ȸ������ �̺�Ʈ ó��
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String myId = id.getText();
				String myPw = new String(pw.getPassword());
				String myName = name.getText();
				String myTel = tel.getText();
				
				//JOptionPane.showMessageDialog
				//(null, "���̵� : " + myId + ", ��й�ȣ : " + myPw + ", �� �� : " + myName + ", ����ó : " + myTel + " �� ������ �����Ǿ����ϴ�.");
				boolean idtest = true;
		        try {
		            File file = new File(".\\src\\projectMain\\UserData.txt");
		            
		            // ������ �����ϸ� �ش� ������ �о �̹� �����ϴ� ���̵� �Ǵ� �������� �˻�
		            if (file.exists()) {
		                FileReader fr = new FileReader(file);
		                BufferedReader br = new BufferedReader(fr);

		                String line;
		                
		                while ((line = br.readLine()) != null) {
			                String[] userInfo = new String[4];
			                String[] data = new String[4];
			                
			                // ���Ͽ��� �о�� ���̵�� �Էµ� ���̵� ��ġ�ϴ� ���
			                for (int i = 0; i < 4; i++) {
			                    data[i] = line.split("/")[i];
			                }

			                userInfo[0] = data[0]; // id
			                userInfo[1] = data[1]; // pw

			                if (myId.equals(userInfo[0])) {
			                	JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵��Դϴ�.");
		                        br.close();
		                        return;
			                }
			            } // while
		                
		            }
		            if(idtest) {
		            	// ������ �������� �ʰų�, ���Ͽ� �������� �ʴ� ���̵��� ��� �����͸� ���Ͽ� �߰�
		                FileWriter fw = new FileWriter(file, true);
		                
		                
		                if(!myId.isEmpty() && !myPw.isEmpty() &&!myName.isEmpty() && !myTel.isEmpty()) {
		                	fw.write("\n" + myId + "/" + myPw + "/" + myName + "/" + myTel);		                	
		                	JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
		                	
		                	new MainScreen();
		                	setVisible(false);
		       
		                } else {
		                	JOptionPane.showMessageDialog(null, "���� ���� �Է����ּ���");                	
		                }
		                
		                fw.close();
		            }
		            
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				
				
			}
		});
		
		// ��Ҹ� ���� �� �̺�Ʈ ó��
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new MainScreen();
	            setVisible(false);
			}
		});
	}
	
}
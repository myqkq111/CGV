package projectMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginService extends LoginView implements ActionListener {

	boolean idCheck = false;
	JTextField id;
	JPasswordField pw;
	// private String pwInfo;
	static String idInfo;
	static String nameInfo;
	static String telInfo;
	static int ifLogin;	

	public void getMembers() {

		try {
			File file = new File(".\\src\\projectMain\\UserData.txt");
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				String line;
				String[] info = new String[4]; // �޸��忡�� �о�� ȸ�������� �����ϴ� �迭

				while ((line = br.readLine()) != null) {

					for (int i = 0; i < 4; i++) {
						info[i] = line.split("/")[i];
//                    	System.out.println(info[i]);
					}

					if (info[0].equals(id.getText()) && info[1].equals(pw.getText())) {
						System.out.println("!");
						this.idCheck = true;
						this.idInfo = info[0]; // ���̵� Ű������ ����
						// pwInfo = memberInfo[1];
						this.nameInfo = info[2];
						this.telInfo = info[3];
						this.ifLogin = 1;
						break;
					}
				}
				if (this.idCheck != true) {
					System.out.println(id.getText());
					System.out.println(pw.getText());
					JOptionPane.showMessageDialog(null, "���̵� Ȥ�� ��й�ȣ�� �ٽ� �Է����ּ���!");
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public LoginService(JTextField id, JPasswordField pw) {
		this.id = id;
		this.pw = pw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMembers();
		new MainScreen();
		LoginView.frame.setVisible(false);
	}
}

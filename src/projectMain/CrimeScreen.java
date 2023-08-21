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

public class CrimeScreen {
	
	static String movieName;
	
	public CrimeScreen() {
		movieName = null;
	      
	      JFrame f = new JFrame();
	        f.setLayout(null);
	                             
	        //cgv로고
	        ImageIcon ii1 = new ImageIcon(".\\img\\logoRed.png");
	        Image img1 = ii1.getImage();
	        Image changeImg1 = img1.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
	        ImageIcon changeii1 = new ImageIcon(changeImg1);   
	        JButton b1 = new JButton(new ImageIcon(changeImg1));
	        b1.setBorderPainted(false);//선택되지 않은 상태에서 외곽선을 없애준다
	        b1.setContentAreaFilled(false);//내용영역 채우기를 없애준다
	        b1.setFocusPainted(false);//선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
	        b1.setBounds(10, 5, 80, 40);
	        f.add(b1);
	        b1.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            new   MainScreen();
	            f.setVisible(false);
	            
	         }
	      });
	        
	        //장르선택
	        //액션
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
	        //코미디
	        ImageIcon genreIi2 = new ImageIcon(".\\img\\14genre02.png");
	        Image genreImg2 = genreIi2.getImage();
	        Image changeGenre2 = genreImg2.getScaledInstance(90, 35, Image.SCALE_SMOOTH);
	        //ImageIcon changeGenreIi2 = new ImageIcon(changeGenre2);
	        JButton genre2 = new JButton(new ImageIcon(changeGenre2));
	        genre2.setBounds(90, 50, 90, 35);
	        genre2.setBorderPainted(false);
	        genre2.setFocusPainted(false);	       
	        f.add(genre2);
	        genre2.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            new   ComedyScreen();
	            f.setVisible(false);
	            
	         }
	      });
	        //범죄
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
	            new   CrimeScreen();
	            f.setVisible(false);
	            
	         }
	      });
	        //멜로,로맨스
	        ImageIcon genreIi4 = new ImageIcon(".\\img\\14genre04.png");
	        Image genreImg4 = genreIi4.getImage();
	        Image changeGenre4 = genreImg4.getScaledInstance(170, 35, Image.SCALE_SMOOTH);
	        //ImageIcon changeGenreIi4 = new ImageIcon(changeGenre4);
	        JButton genre4 = new JButton(new ImageIcon(changeGenre4));
	        genre4.setBounds(270, 50, 170, 35);
	        genre4.setBorderPainted(false);
	        genre4.setFocusPainted(false);
	        f.add(genre4);
	        genre4.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            new   RomanceScreen();
	            f.setVisible(false);
	            
	         }
	      });	        
	        
	        if(LoginService.ifLogin == 1){
		        //로그아웃
		        	ImageIcon ii11 = new ImageIcon(".\\img\\로그인.png");
		        	Image img11 = ii11.getImage();
		        	Image changeImg11 = img11.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		        	ImageIcon changeii11 = new ImageIcon(changeImg11);   
		        	JButton b5 = new JButton(new ImageIcon(changeImg11));
		        	b5.setBorderPainted(false);//선택되지 않은 상태에서 외곽선을 없애준다
		        	b5.setContentAreaFilled(false);//내용영역 채우기를 없애준다
		        	b5.setFocusPainted(false);//선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
		        	b5.setBounds(345, 5, 35, 35);
		        	f.add(b5);
		        	JLabel audiences10 = new JLabel("로그아웃");
		        	audiences10.setBounds(342, 33, 40, 20);
		        	audiences10.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		        	audiences10.setForeground(Color.gray);
		        	f.add(audiences10);

	        } else {
	        	 //로그인
	        	ImageIcon ii8 = new ImageIcon(".\\img\\로그인.png");
	        	Image img8 = ii8.getImage();
	        	Image changeImg8 = img8.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	        	ImageIcon changeii8 = new ImageIcon(changeImg8);   
	        	JButton b2 = new JButton(new ImageIcon(changeImg8));
	        	b2.setBorderPainted(false);//선택되지 않은 상태에서 외곽선을 없애준다
	        	b2.setContentAreaFilled(false);//내용영역 채우기를 없애준다
	        	b2.setFocusPainted(false);//선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
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
	        	
	        	 //회원가입
		        ImageIcon ii9 = new ImageIcon(".\\img\\회원가입.png");
		        Image img9 = ii9.getImage();
		        Image changeImg9 = img9.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		        ImageIcon changeii9 = new ImageIcon(changeImg9);   
		        JButton b3 = new JButton(new ImageIcon(changeImg9));
		        b3.setBorderPainted(false);//선택되지 않은 상태에서 외곽선을 없애준다
		        b3.setContentAreaFilled(false);//내용영역 채우기를 없애준다
		        b3.setFocusPainted(false);//선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
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
	         
	        //마이페이지
	        ImageIcon ii10 = new ImageIcon(".\\img\\마이페이지.png");
	        Image img10 = ii10.getImage();
	        Image changeImg10 = img10.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	        ImageIcon changeii10 = new ImageIcon(changeImg10);   
	        JButton b4 = new JButton(new ImageIcon(changeImg10));
	        b4.setBorderPainted(false);//선택되지 않은 상태에서 외곽선을 없애준다
	        b4.setContentAreaFilled(false);//내용영역 채우기를 없애준다
	        b4.setFocusPainted(false);//선택되었을때 생기는 얇은 점선 같은 테두리를 사용하지 않는다
	        b4.setBounds(390, 6, 35, 35);
	        f.add(b4);
	        JLabel audiences9 = new JLabel("MY CGV");
	        audiences9.setBounds(387, 33, 40, 20);
	        audiences9.setFont(new Font("맑은 고딕", Font.BOLD, 10));
	        audiences9.setForeground(Color.gray);
	        f.add(audiences9);
	        
	        b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new MyPage();
					f.setVisible(false);
					
				}
			});
	        
	        
	        
	      //범죄도시2
	        ImageIcon ii2 = new ImageIcon(".\\img\\범죄도시2.jpg");
	        Image img2 = ii2.getImage();
	        Image changeImg2 = img2.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
	        ImageIcon changeii2 = new ImageIcon(changeImg2);
	        JLabel jl2 = new JLabel(changeii2);
	        jl2.setBounds(27, 1, 110, 140);
	        //제목
	        JLabel moviename1 = new JLabel("범죄도시2");
	        moviename1.setBounds(44,140, 80, 30);
	        moviename1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
	        //별
	        ImageIcon star1 = new ImageIcon(".\\img\\별.png");
	        Image strImg1 = star1.getImage();
	        Image changeStarImg1 = strImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	        ImageIcon changeStart1 = new ImageIcon(changeStarImg1);
	        JLabel staJl1 = new JLabel(changeStart1);
	        staJl1.setBounds(16, 168, 15, 15);
	        //평점
	        JLabel rating1 = new JLabel("9.0");
	        rating1.setBounds(31, 164, 20, 20);
	        rating1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
	        rating1.setForeground(Color.gray);
	        //누적관객수
	        JLabel audiences1 = new JLabel("누적관객1,269만");
	        audiences1.setBounds(53, 149, 120, 50);
	        audiences1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
	        audiences1.setForeground(Color.gray);
	        //예매버튼
	        JToggleButton bt1 = new JToggleButton(new ImageIcon(".\\img\\reserve.png"));
			bt1.setBounds(39, 184, 90, 23);
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
	        //패널
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
	        
	        
	        
	        f.getContentPane().setBackground(Color.WHITE);
	        f.setBounds(700, 200, 450, 800);
	        f.setVisible(true);
	        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);	  
	        f.setLocationRelativeTo(null);
	   }

}

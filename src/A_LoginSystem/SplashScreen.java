package A_LoginSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	private Image Clogo = new ImageIcon
			("src/res/companyLogo.png")
			.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	
	private Image Glogo = new ImageIcon
			("src/res/LOGO-BLACK BACKROUND-fotor-bg-remover-202303201278.png")
			.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
	private static JProgressBar progressBar;
	private static JLabel lblvalue;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					
					int i;
					try {
						for(i = 0; i <= 100; i++) {
							progressBar.setValue(i);
							Thread.sleep(50);
							lblvalue.setText(Integer.toString(i)+ " %");
							
							if (i == 100) {
								
								FrameLogin login = new FrameLogin();
								login.setVisible(true);
								
								AttendanceLogin attendace = new AttendanceLogin();
								attendace.setVisible(true);
								frame.dispose();
							}
							
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 358);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBorder(null);
		progressBar.setBorderPainted(false);
		progressBar.setForeground(new Color(255, 0, 0));
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(26, 259, 512, 37);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("Loading plss wait.....");
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(26, 222, 293, 26);
		contentPane.add(lblNewLabel);
		
		lblvalue = new JLabel("");
		lblvalue.setHorizontalAlignment(SwingConstants.LEFT);
		lblvalue.setForeground(Color.WHITE);
		lblvalue.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblvalue.setBounds(468, 222, 70, 37);
		contentPane.add(lblvalue);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Samgy");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 40));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 0, 512, 56);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("by RISARE'S");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Nirmala UI", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(26, 38, 512, 56);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(210, 91, 156, 120);
		lblLogo.setIcon(new ImageIcon(Clogo));
		contentPane.add(lblLogo);
		
		JLabel lblCopyright = new JLabel("Copyright 2023 | All Rights Reserves by Manjaro");
		lblCopyright.setForeground(new Color(255, 255, 255));
		lblCopyright.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCopyright.setBounds(26, 307, 363, 28);
		contentPane.add(lblCopyright);
		
		JLabel lblGlogo = new JLabel("");
		lblGlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGlogo.setBounds(482, 293, 70, 65);
		lblGlogo.setIcon(new ImageIcon(Glogo));
		contentPane.add(lblGlogo);
		
		setLocationRelativeTo(null);
	}
}

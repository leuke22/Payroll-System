package B_DashBoardss;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import java.awt.Color; 
import javax.swing.border.LineBorder;

import A_LoginSystem.FrameLogin;
import C_PanelsDashboards.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants; 
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class UsersDashBoard extends JFrame { 
 
 private JPanel contentPane;


 private Image iconOnline = new ImageIcon
			("src/res/online.png")
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
 private Image iconHome = new ImageIcon
			("src/res/iconHome.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);

 private Image iconPayroll = new ImageIcon
			("src/res/iconPayroll.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 
 private Image iconPayslip = new ImageIcon
			("src/res/iconPayslip.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 private Image iconLogout = new ImageIcon
			("src/res/iconLogout.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 
 private G_ProfilePageUser panelProfile;
 private A_HomePage panelHome;
 private D_PayrollPageUser panelPayroll;
 private E_PayslipPageUser panelPayslip;
 
 private JLabel lblFirstname;
 private JLabel lblIdname;

 static int Id;
 static String firstname;
 static String lastname;
 static byte [] images;

 String timeOffline;
 /** 
  * Launch the application. 
  */ 
 	public static void main(String[] args) { 
		
 			UsersDashBoard frame = new UsersDashBoard(firstname,lastname, Id, images); 
			frame.setVisible(true); 
 	} 
 

	public UsersDashBoard(String firstname, String lastname, int Id, byte[] images) { 
	  setUndecorated(true); 
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  setBounds(100, 100, 1366, 768); 
	  contentPane = new JPanel(); 
	  contentPane.setBackground(new Color(21, 21, 21)); 
	  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
	 
	  setContentPane(contentPane);
	  contentPane.setLayout(null);
	  
	  panelProfile = new G_ProfilePageUser(Id, images);
	  panelProfile.setBounds(0, 0, 936, 660);
	  panelHome = new A_HomePage();
	  panelHome.setBounds(0, 0, 936, 660);

	  panelPayroll = new D_PayrollPageUser(firstname);
	  panelPayroll.setBounds(0, 0, 936, 660);
	  panelPayslip = new E_PayslipPageUser(firstname);
	  panelPayslip.setBounds(0, 0, 936, 660);
	  
	  JPanel panel = new JPanel(); 
	  panel.setBounds(420, 11, 936, 79);
	  panel.setForeground(new Color(255, 255, 255)); 
	  panel.setBorder(new LineBorder(new Color(0, 0, 0), 0)); 
	  panel.setBackground(new Color(51, 51, 51));
	  contentPane.add(panel);
	  panel.setLayout(null);
	   
	  JLabel lblNewLabel = new JLabel("Samgy Restaurant Payroll"); 
	  lblNewLabel.setBounds(0, 0, 934, 79);
	  lblNewLabel.setForeground(new Color(255, 255, 255)); 
	  lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 60)); 
	  lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
	  lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	  panel.add(lblNewLabel);
	  
	  JPanel paneldash = new JPanel();
	  paneldash.setBounds(10, 160, 400, 600);
	  paneldash.setBackground(new Color(51, 51, 51));
	  paneldash.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  contentPane.add(paneldash);
	  paneldash.setLayout(null);
	  
	  JPanel panelsHome = new JPanel();
	  panelsHome.setBounds(10, 10, 380, 60);
	  paneldash.add(panelsHome);
	  panelsHome.addMouseListener(new PanelButtonMouseAdapter(panelsHome){
		  public void mouseClicked(MouseEvent e) {
			  menuClicked(panelHome);
		  }
	  });
	  panelsHome.setBackground(new Color(51, 51, 51));
	  panelsHome.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsHome.setLayout(null);
	  
	  JLabel lblNewLabel_1 = new JLabel("Home");
	  lblNewLabel_1.setBackground(new Color(255, 255, 255));
	  lblNewLabel_1.setForeground(new Color(255, 255, 255));
	  lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
	  lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
	  lblNewLabel_1.setBounds(119, 0, 228, 60);
	  panelsHome.add(lblNewLabel_1);
	  
	  JLabel lblHomeicon = new JLabel("");
	  lblHomeicon.setHorizontalAlignment(SwingConstants.CENTER);
	  lblHomeicon.setBounds(23, 0, 70, 60);
	  lblHomeicon.setIcon(new ImageIcon(iconHome));
	  panelsHome.add(lblHomeicon);
	  
	  
	  JPanel panelsPayroll = new JPanel();
	  panelsPayroll.addMouseListener(new PanelButtonMouseAdapter(panelsPayroll){
		  public void mouseClicked(MouseEvent e) {
			  menuClicked(panelPayroll);
		  }
	  });
	  panelsPayroll.setLayout(null);
	  panelsPayroll.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsPayroll.setBackground(new Color(51, 51, 51));
	  panelsPayroll.setBounds(10, 80, 380, 60);
	  paneldash.add(panelsPayroll);
	  
	  JLabel lblNewLabel_1_1_1_1 = new JLabel("Payroll");
	  lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
	  lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
	  lblNewLabel_1_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
	  lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
	  lblNewLabel_1_1_1_1.setBounds(119, 0, 228, 60);
	  panelsPayroll.add(lblNewLabel_1_1_1_1);
	  
	  JLabel lblPayrollicon = new JLabel("");
	  lblPayrollicon.setHorizontalAlignment(SwingConstants.CENTER);
	  lblPayrollicon.setIcon(new ImageIcon(iconPayroll));
	  lblPayrollicon.setBounds(23, 0, 70, 60);
	  panelsPayroll.add(lblPayrollicon);
	  
	  JPanel panelsPayslip = new JPanel();
	  panelsPayslip.addMouseListener(new PanelButtonMouseAdapter(panelsPayslip){
		  public void mouseClicked(MouseEvent e) {
			  menuClicked(panelPayslip);
		  }
	  });
	  panelsPayslip.setLayout(null);
	  panelsPayslip.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsPayslip.setBackground(new Color(51, 51, 51));
	  panelsPayslip.setBounds(10, 150, 380, 60);
	  paneldash.add(panelsPayslip);
	  
	  JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Payslip");
	  lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
	  lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
	  lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
	  lblNewLabel_1_1_1_1_1_1.setBackground(Color.WHITE);
	  lblNewLabel_1_1_1_1_1_1.setBounds(119, 0, 228, 60);
	  panelsPayslip.add(lblNewLabel_1_1_1_1_1_1);
	  
	  JLabel lblPayslipicon = new JLabel("");
	  lblPayslipicon.setHorizontalAlignment(SwingConstants.CENTER);
	  lblPayslipicon.setIcon(new ImageIcon(iconPayslip));
	  lblPayslipicon.setBounds(23, 0, 70, 60);
	  panelsPayslip.add(lblPayslipicon);
	  
	  JPanel panelsLogout = new JPanel();
	  panelsLogout.addMouseListener(new PanelButtonMouseAdapter(panelsLogout){
		  public void mouseClicked(MouseEvent e) {
			 
			  String StatusOffline = "OFFLINE";
			  String DateOffline = showTimeOffline(timeOffline);
			  
			  try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
				String timeoutquery = "UPDATE usersStatus SET StatusOffline = '"+ StatusOffline +  "' , DateOffline = '" +DateOffline + "' WHERE Id = '" + Id + "'";
				Statement states = null;
				states = con.createStatement();
						
						int ans = JOptionPane.showOptionDialog(null, 
								  "Are you sure do you want to logout?", 
								  "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
						  if (ans == 0) {
							  
							  if(!states.execute(timeoutquery)) {
								  UsersDashBoard.this.dispose();
								  FrameLogin login = new FrameLogin();
								  login.setVisible(true);
							  
								  con.close();
							  	  states.close();
							  }
						 }	
			  } catch (SQLException e2) {
			      e2.printStackTrace();
			  }

		  }
	  });
	  panelsLogout.setLayout(null);
	  panelsLogout.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsLogout.setBackground(new Color(51, 51, 51));
	  panelsLogout.setBounds(10, 524, 380, 60);
	  paneldash.add(panelsLogout);
	  
	  JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Logout");
	  lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
	  lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
	  lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
	  lblNewLabel_1_1_1_1_1_1_1.setBackground(Color.WHITE);
	  lblNewLabel_1_1_1_1_1_1_1.setBounds(119, 0, 228, 60);
	  panelsLogout.add(lblNewLabel_1_1_1_1_1_1_1);
	  
	  JLabel lblLogouticon = new JLabel("");
	  lblLogouticon.setIcon(new ImageIcon(iconLogout));
	  lblLogouticon.setHorizontalAlignment(SwingConstants.CENTER);
	  lblLogouticon.setBounds(23, 0, 70, 60);
	  panelsLogout.add(lblLogouticon);
	  
	  JPanel paneProfile = new JPanel();
	  
	  paneProfile.setLayout(null);
	  paneProfile.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  paneProfile.setBackground(new Color(51, 51, 51));
	  paneProfile.setBounds(10, 11, 400, 140);
	  contentPane.add(paneProfile);
	  
	  JPanel panelsProfile = new JPanel();
	  panelsProfile.addMouseListener(new PanelButtonMouseAdapter(panelsProfile){
		  public void mouseClicked(MouseEvent e) {
			  menuClicked(panelProfile);
		  }
	  });
	  panelsProfile.setBounds(10, 11, 380, 129);
	  paneProfile.add(panelsProfile);
	  panelsProfile.setLayout(null);
	  panelsProfile.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsProfile.setBackground(new Color(51, 51, 51));
	  
	  JLabel lblNewLabel_1_2_1 = new JLabel("Welcome,");
	  lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
	  lblNewLabel_1_2_1.setForeground(Color.WHITE);
	  lblNewLabel_1_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
	  lblNewLabel_1_2_1.setBackground(Color.WHITE);
	  lblNewLabel_1_2_1.setBounds(106, 21, 128, 30);
	  panelsProfile.add(lblNewLabel_1_2_1);
	  
	  lblFirstname = new JLabel("Firstname");
	  lblFirstname.setHorizontalAlignment(SwingConstants.LEFT);
	  lblFirstname.setForeground(Color.WHITE);
	  lblFirstname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
	  lblFirstname.setBackground(Color.WHITE);
	  lblFirstname.setBounds(237, 21, 143, 30);
	  
	  panelsProfile.add(lblFirstname);
	  
	  lblIdname = new JLabel("");
	  lblIdname.setHorizontalAlignment(SwingConstants.CENTER);
	  lblIdname.setForeground(new Color(255, 255, 255));
	  lblIdname.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
	  lblIdname.setBounds(106, 0, 274, 20);
	  panelsProfile.add(lblIdname);
	  
	  JPanel paneMaincontent = new JPanel();
	  paneMaincontent.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  paneMaincontent.setBounds(420, 101, 936, 660);
	  contentPane.add(paneMaincontent);
	  paneMaincontent.setLayout(null);
	  
	  setLocationRelativeTo(null);
	  contentPane.setVisible(true);

	  lblFirstname.setText(firstname);
	  lblIdname.setText(String.valueOf(Id));
	  
	  JLabel lblNewLabel_1_2_1_3 = new JLabel("View Profile to see more information");
	  lblNewLabel_1_2_1_3.setBounds(0, 94, 380, 24);
	  panelsProfile.add(lblNewLabel_1_2_1_3);
	  lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
	  lblNewLabel_1_2_1_3.setForeground(Color.WHITE);
	  lblNewLabel_1_2_1_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
	  lblNewLabel_1_2_1_3.setBackground(Color.WHITE);
	  
	  JLabel lblStatus = new JLabel("ONLINE");
	  lblStatus.setForeground(Color.WHITE);
	  lblStatus.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
	  lblStatus.setBounds(156, 59, 113, 24);
	  panelsProfile.add(lblStatus);
	  
	  JLabel lblOnlineLogo = new JLabel("");
	  lblOnlineLogo.setHorizontalAlignment(SwingConstants.CENTER);
	  lblOnlineLogo.setBounds(269, 54, 46, 35);
	  lblOnlineLogo.setIcon(new ImageIcon(iconOnline));
	  panelsProfile.add(lblOnlineLogo);
	  
	  JPanel panel_1 = new JPanel();
	  panel_1.setBackground(new Color(105, 105, 105));
	  panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panel_1.setBounds(0, 0, 92, 82);
	  panelsProfile.add(panel_1);
	  panel_1.setLayout(null);
	  
	  JLabel lblProfile = new JLabel("");
	  
	  lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
	  lblProfile.setBounds(2, 5, 88, 72);
	  Image profilePicture = new ImageIcon
				(images).getImage().getScaledInstance(lblProfile.getHeight(), lblProfile.getWidth(), Image.SCALE_SMOOTH);
	  lblProfile.setIcon(new ImageIcon(profilePicture));
	  panel_1.add(lblProfile);
	  
	  paneMaincontent.add(panelProfile);
	  paneMaincontent.add(panelHome);
	  paneMaincontent.add(panelPayroll);
	  paneMaincontent.add(panelPayslip);
	  
	  menuClicked(panelHome);
 } 
	 public void menuClicked(JPanel panel) {
		 panelProfile.setVisible(false);
		 panelHome.setVisible(false);
		 panelPayroll.setVisible(false);
		 panelPayslip.setVisible(false);
		 
		 panel.setVisible(true);
	 }
	 private class PanelButtonMouseAdapter extends MouseAdapter{
		 JPanel panel;
		 public PanelButtonMouseAdapter(JPanel panel) {
			 this.panel = panel;
		 }
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
		  		panel.setBackground(new Color(0, 0, 0));
		  	}
		  	@Override
		  	
		  	public void mouseExited(MouseEvent e) {
		  		panel.setBackground(new Color(51, 51, 51));
		  	}
		  	@Override
		  	public void mousePressed(MouseEvent e) {
		  		panel.setBackground(new Color(51, 51, 51));
		  	}
		  	@Override
		  	public void mouseReleased(MouseEvent e) {
		  		panel.setBackground(new Color(0, 0, 0));
		  	}
		  	
	 }
	 
	 public String showTimeOffline(String timeOffline) {
			
			this.timeOffline = timeOffline;
			Date d = new Date();
			SimpleDateFormat s = new SimpleDateFormat("hh:mm a");
			return timeOffline = s.format(d);
			
	}
	 

}

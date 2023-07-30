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
import java.awt.Rectangle;
 
public class StaffDashBoard extends JFrame { 
 
 private JPanel contentPane;
 private Image iconProfile = new ImageIcon
			("src/res/iconstaff.png")
			.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
 private Image iconOnline = new ImageIcon
			("src/res/online.png")
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
 private Image iconHome = new ImageIcon
			("src/res/iconHome.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 private Image iconAttendance = new ImageIcon
			("src/res/iconAtteandance.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 private Image iconEmployee = new ImageIcon
			("src/res/iconEmployeelist.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 private Image iconPayroll = new ImageIcon
			("src/res/iconPayroll.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 private Image iconLogout = new ImageIcon
			("src/res/iconLogout.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
 
 private A_HomePageStaff panelHome;
 private B_AttendanceStaffPage panelAttendance;
 private C_EmployeeStaffPage panelEmployee;
 private D_PayrollPageStaff panelPayroll;
 private JLabel lblName;
 private JLabel lblPosition;

 /** 
  * Launch the application. 
  */ 
 	public static void main(String[] args) { 
		
 			AdminDashBoard frame = new AdminDashBoard(); 
			frame.setVisible(true); 
 	} 
 
 /** 
  * Create the frame. 
  */ 
 	 public StaffDashBoard() {
 		initialize();
 	 }
 	 public StaffDashBoard(String name, String position) {
 		initialize();
 		lblName.setText(name);
 		lblPosition.setText(position);
 	 }
 	 
	 public void initialize() { 
	  setUndecorated(true); 
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  setBounds(100, 100, 1366, 768); 
	  contentPane = new JPanel(); 
	  contentPane.setBackground(new Color(21, 21, 21)); 
	  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
	 
	  setContentPane(contentPane);
	  contentPane.setLayout(null);
	  
	  panelHome = new A_HomePageStaff();
	  panelHome.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelHome.setBounds(0, 0, 936, 660);
	  panelAttendance = new B_AttendanceStaffPage();
	  panelAttendance.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelAttendance.setBounds(0, 0, 936, 660);
	  panelEmployee = new C_EmployeeStaffPage();
	  panelEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelEmployee.setBounds(0, 0, 936, 660);
	  panelPayroll = new D_PayrollPageStaff();
	  panelPayroll.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelPayroll.setBounds(0, 0, 936, 660);
	  
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
	  
	  JPanel panelsAttendance = new JPanel();
	  panelsAttendance.addMouseListener(new PanelButtonMouseAdapter(panelsAttendance){
		  public void mouseClicked(MouseEvent e) {
			  menuClicked(panelAttendance);
		  }
	  });
	  panelsAttendance.setLayout(null);
	  panelsAttendance.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsAttendance.setBackground(new Color(51, 51, 51));
	  panelsAttendance.setBounds(10, 80, 380, 60);
	  paneldash.add(panelsAttendance);
	  
	  JLabel lblNewLabel_1_1 = new JLabel("Attendance");
	  lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
	  lblNewLabel_1_1.setForeground(Color.WHITE);
	  lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
	  lblNewLabel_1_1.setBackground(Color.WHITE);
	  lblNewLabel_1_1.setBounds(119, 0, 228, 60);
	  panelsAttendance.add(lblNewLabel_1_1);
	  
	  JLabel lblAttendicon = new JLabel("");
	  lblAttendicon.setHorizontalAlignment(SwingConstants.CENTER);
	  lblAttendicon.setIcon(new ImageIcon(iconAttendance));
	  lblAttendicon.setBounds(23, 0, 70, 60);
	  panelsAttendance.add(lblAttendicon);
	  
	  JPanel panelsEmployee = new JPanel();
	  panelsEmployee.addMouseListener(new PanelButtonMouseAdapter(panelsEmployee){
		  public void mouseClicked(MouseEvent e) {
			  menuClicked(panelEmployee);
		  }
	  });
	  panelsEmployee.setLayout(null);
	  panelsEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsEmployee.setBackground(new Color(51, 51, 51));
	  panelsEmployee.setBounds(10, 150, 380, 60);
	  paneldash.add(panelsEmployee);
	  
	  JLabel lblNewLabel_1_1_1 = new JLabel("Employee");
	  lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
	  lblNewLabel_1_1_1.setForeground(Color.WHITE);
	  lblNewLabel_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
	  lblNewLabel_1_1_1.setBackground(Color.WHITE);
	  lblNewLabel_1_1_1.setBounds(119, 0, 228, 60);
	  panelsEmployee.add(lblNewLabel_1_1_1);
	  
	  JLabel lblEmployeeicon = new JLabel("");
	  lblEmployeeicon.setHorizontalAlignment(SwingConstants.CENTER);
	  lblEmployeeicon.setIcon(new ImageIcon(iconEmployee));
	  lblEmployeeicon.setBounds(23, 0, 70, 60);
	  panelsEmployee.add(lblEmployeeicon);
	  
	  JPanel panelsPayroll = new JPanel();
	  panelsPayroll.addMouseListener(new PanelButtonMouseAdapter(panelsPayroll){
		  public void mouseClicked(MouseEvent e) {
			  menuClicked(panelPayroll);
		  }
	  });
	  panelsPayroll.setLayout(null);
	  panelsPayroll.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsPayroll.setBackground(new Color(51, 51, 51));
	  panelsPayroll.setBounds(10, 220, 380, 60);
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
	  
	  JPanel panelsLogout = new JPanel();
	  panelsLogout.addMouseListener(new PanelButtonMouseAdapter(panelsLogout){
		  public void mouseClicked(MouseEvent e) {
			  int ans = JOptionPane.showOptionDialog(null, 
					  "Are you sure do you want to logout?", 
					  "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
			  if (ans == 0) {
				  StaffDashBoard.this.dispose();
				  FrameLogin login = new FrameLogin();
				  login.setVisible(true);
			  }
		  }
	  });
	  panelsLogout.setLayout(null);
	  panelsLogout.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsLogout.setBackground(new Color(51, 51, 51));
	  panelsLogout.setBounds(10, 520, 380, 60);
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
	  panelsProfile.setBounds(10, 11, 380, 129);
	  paneProfile.add(panelsProfile);
	  panelsProfile.setLayout(null);
	  panelsProfile.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  panelsProfile.setBackground(new Color(51, 51, 51));
	  
	  JLabel lblNewLabel_1_2_1 = new JLabel("Welcome,");
	  lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
	  lblNewLabel_1_2_1.setForeground(Color.WHITE);
	  lblNewLabel_1_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
	  lblNewLabel_1_2_1.setBackground(Color.WHITE);
	  lblNewLabel_1_2_1.setBounds(109, -7, 134, 36);
	  panelsProfile.add(lblNewLabel_1_2_1);
	  
	  lblName = new JLabel("STAFF");
	  lblName.setHorizontalAlignment(SwingConstants.LEFT);
	  lblName.setForeground(Color.WHITE);
	  lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
	  lblName.setBackground(Color.WHITE);
	  lblName.setBounds(252, -7, 128, 36);
	  panelsProfile.add(lblName);
	  
	  lblPosition = new JLabel("Staff");
	  lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
	  lblPosition.setForeground(new Color(220, 220, 220));
	  lblPosition.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
	  lblPosition.setBackground(Color.WHITE);
	  lblPosition.setBounds(125, 21, 211, 47);
	  panelsProfile.add(lblPosition);
	  
	  JLabel lblNewLabel_1_2_1_3 = new JLabel("View Profile to see more information");
	  lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
	  lblNewLabel_1_2_1_3.setForeground(Color.WHITE);
	  lblNewLabel_1_2_1_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
	  lblNewLabel_1_2_1_3.setBackground(Color.WHITE);
	  lblNewLabel_1_2_1_3.setBounds(0, 100, 380, 30);
	  panelsProfile.add(lblNewLabel_1_2_1_3);
	  
	  JLabel lblStatus = new JLabel("ONLINE");
	  lblStatus.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
	  lblStatus.setForeground(new Color(255, 255, 255));
	  lblStatus.setBounds(180, 70, 118, 24);
	  panelsProfile.add(lblStatus);
	  
	  JLabel lblOnlineLogo = new JLabel("");
	  lblOnlineLogo.setHorizontalAlignment(SwingConstants.CENTER);
	  lblOnlineLogo.setBounds(295, 65, 41, 35);
	  lblOnlineLogo.setIcon(new ImageIcon(iconOnline));
	  panelsProfile.add(lblOnlineLogo);
	  
	  JLabel lblProfile = new JLabel("");
	  lblProfile.setBounds(0, 0, 99, 89);
	  lblProfile.setIcon(new ImageIcon(iconProfile));  
	  panelsProfile.add(lblProfile);
	  
	  JPanel paneMaincontent = new JPanel();
	  paneMaincontent.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	  paneMaincontent.setBounds(420, 101, 936, 660);
	  contentPane.add(paneMaincontent);
	  paneMaincontent.setLayout(null);
	  
	  setLocationRelativeTo(null);
	  contentPane.setVisible(true);
	  
	  paneMaincontent.add(panelHome);
	  paneMaincontent.add(panelAttendance);
	  paneMaincontent.add(panelEmployee);
	  paneMaincontent.add(panelPayroll);
	  
	  menuClicked(panelHome);
 } 
	 public void menuClicked(JPanel panel) {
		 panelHome.setVisible(false);
		 panelAttendance.setVisible(false);
		 panelEmployee.setVisible(false);
		 panelPayroll.setVisible(false);
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
}
